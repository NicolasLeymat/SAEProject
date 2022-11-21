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

	// Fonction qui permet de retourner le nom d'une écurie
	public String getNom() {
		return nom;
	}

	// Fonction qui permet de changer le nom d'une écurie
	public void setNom(String nom) {
		this.nom = nom;
	}

	// Fonction qui permet de rajouter une équipe à une écurie
	public void addEquipe(Equipe equipe) {
		this.listeEquipes.add(equipe);
	}

	// Fonction qui permet de supprimer une équipe dans une écurie
	public void addEquipes(List<Equipe> liste) {
		this.listeEquipes = liste;
	}

	public void removeEquipe(Equipe equipe) {
		this.listeEquipes.remove(equipe);
	}

	// Fonction qui permet de prendre les informations sur une équipe
	public Equipe getEquipe(String nom) {
		for (Equipe equipe : this.listeEquipes) {
			if (equipe.getNom() == nom) {
				return equipe;
			}
		}
		return null;

	}


	// Fonction qui permet d'enregistrer une écurie dans la base de données
	public static int enregistrerEcurie(Connection connex, Ecurie e) {
		PreparedStatement pst;
		
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_ecurie (nom) values(?)");
			pst.setString(1, e.getNom());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}



	public static Ecurie getEcurieFromNom(Connection connex, String nom) {
		PreparedStatement pst = null;
		ResultSet rs;
		Ecurie e = null;
		try {
			pst = connex.prepareStatement("Select nom from LMN3783A.sae_ecurie where nom = ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Ecurie(rs.getString(1));
				e.listeEquipes = Equipe.getEquipesFromEcurie(connex, rs.getString(1));
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
