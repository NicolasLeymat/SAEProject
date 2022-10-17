package Object;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Application.Connexion;


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
