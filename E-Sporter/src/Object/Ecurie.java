package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Application.Connexion;

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
	public int getId() throws Exception {
		Connection co = Connexion.connexion();
		java.sql.Statement st;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id_ecuries from LMN3783A.sae_ecurie where " + this.nom + "= LMN3783A.sae_ecurie.nom");
			if (!rs.next()) {
			throw new IllegalArgumentException();}
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//Fonction qui permet de récuperer le dernier identifiant de l'écurie
	public int getLastId() {
		Connection ct = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select id_ecuries as id from LMN3783A.sae_ecurie");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	//Fonction qui permet d'enregistrer une écurie dans la base de données
	public int enregistrerEcurie() {
		Connection connex = Application.Connexion.connexion();
		PreparedStatement pst;
		int lastId = this.getLastId();
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_ecurie values(?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, nom);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}
}
