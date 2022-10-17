package Object;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Application.Connexion;
import sun.security.mscapi.CKeyPairGenerator.RSA;

public class Ecurie {

	private String nom;
	private List<Equipe> listeEquipes;

	// Ajouter photo type : String
	public Ecurie(String nom) {
		this.nom = nom;
		this.listeEquipes = new ArrayList<Equipe>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addEquipe(Equipe equipe) {
		this.listeEquipes.add(equipe);
	}

	public Equipe getEquipe(int i) {
		return this.listeEquipes.get(i);
	}

	public int getId() {
		Connection co = Connexion.connexion();
		java.sql.Statement st;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id_ecuries from ecurie where " + this.nom + "= ecurie.nom");
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
