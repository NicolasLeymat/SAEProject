package Object;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Application.Connexion;

public class Jeu {

	private String nomJeu;
	private HashMap<String, Integer> modeDeJeu;

	public Jeu(String nomJeu) {
		this.modeDeJeu = new HashMap<String, Integer>();
		this.nomJeu = nomJeu;
	}

	public String getNomJeu() {
		return this.nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	public void addModeDeJeu(String mode, int nbJoueurs) {
		this.modeDeJeu.put(mode, nbJoueurs);
	}

	public int getId() {
		Connection co = Connexion.connexion();
		java.sql.Statement st;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id_ecuries from ecurie where " + this.nomJeu + "= ecurie.nom");
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
