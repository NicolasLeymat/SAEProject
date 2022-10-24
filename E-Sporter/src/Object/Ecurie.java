package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Classe qui définit les fonctions d'une écurie
public class Ecurie {

	private String nom;
	private List<Equipe> listeEquipes;

	// Ajouter photo type : String
	public Ecurie(String nom) {
		this.nom = nom;
		this.listeEquipes = new ArrayList<Equipe>();
	}
	
	//Fonction qui permet de retourner le nom d'une écurie
	public String getNom() {
		return nom;
	}
	
	//Fonction qui permet de changer le nom d'une écurie
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Fonction qui permet de rajouter une équipe à une écurie
	public void addEquipe(Equipe equipe) {
		this.listeEquipes.add(equipe);
	}
	
	//Fonction qui permet de supprimer une équipe dans une écurie
	public void addEquipes(List<Equipe> liste) {
		this.listeEquipes = liste;
	}
	
	public void removeEquipe(Equipe equipe) {
		this.listeEquipes.remove(equipe);
	}
	
	//Fonction qui permet de prendre les informations sur une équipe
	public Equipe getEquipe(String nom) {
		for (Equipe equipe: this.listeEquipes) {
			if (equipe.getNom() == nom) {
				return equipe;
			}			
		}
		return null;		

	}
	
	//Fonction qui permet de récuperer l'identifiant d'une écurie
	public int getId(Connection connex) throws Exception {
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst =  connex.prepareStatement("select id_ecurie from LMN3783A.sae_ecurie where LMN3783A.sae_ecurie.nom = ?");
			pst.setString(0, nom);
			rs = pst.executeQuery();
			if (!rs.next()) {
				throw new IllegalArgumentException();
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//Fonction qui permet de récuperer le dernier identifiant de l'écurie
	public int getLastId(Connection connex) {
		Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("Select id_ecurie as id from LMN3783A.sae_ecurie");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	//Fonction qui permet d'enregistrer une écurie dans la base de données
	public static int enregistrerEcurie(Connection connex, Ecurie e) {
		PreparedStatement pst;
		int lastId = e.getLastId(connex);
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_ecurie values(?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, e.getNom());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}



	public static Ecurie getEcurieFromId(Connection connex, int id) {
		PreparedStatement pst = null;
		ResultSet rs;
		Ecurie e = null;
		try {
			pst = connex.prepareStatement("Select id_ecurie, nom from LMN3783A.sae_ecurie where id_ecurie = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Ecurie(rs.getString(2));
				e.listeEquipes = Equipe.getEquipesFromEcurie(connex,rs.getInt(1));
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return e;
	}

	@Override
	public String toString() {
		return "Ecurie [nom=" + nom + ", listeEquipes=" + listeEquipes + "]";
	}
	
	

}
