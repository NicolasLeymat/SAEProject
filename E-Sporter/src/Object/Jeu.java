package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public int getNbJoueurs(String nomMode) {
		return this.modeDeJeu.get(nomMode);
	}

	public int getId() {
		Connection co = Connexion.connexion();
		java.sql.Statement st;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id_jeu from LMN3783A.sae_jeu where '" + this.nomJeu + "'= LMN3783A.sae_jeu.nom");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getLastId() {
		Connection ct = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select id_jeu as id from LMN3783A.sae_jeu");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}

	public static int enregistrerJeu(Jeu jeu) {
		Connection connex = Application.Connexion.connexion();
		PreparedStatement pst;
		int lastId = jeu.getLastId();
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_jeu values(?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, jeu.nomJeu);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}


}
