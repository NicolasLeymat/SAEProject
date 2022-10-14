package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Equipe {

	private String nom;
	private int points;
	private Ecurie ecurie;
	private String jeu;

	//Il faudrait peut être changer le type de jeu
	public Equipe(String nom, int points, Ecurie ecurie, String jeu) {
		this.nom = nom;
		this.points = points;
		this.ecurie = ecurie;
		this.jeu = jeu;
	}
	
	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getLastId(Connection connex) {
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("Select id_equipes as id from equipe");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}

	public void enregistrerEquipe(Connection connex, String nom, int nombreJoueur, int points, Scanner e) {
		PreparedStatement pst;
		int lastId = this.getLastId(connex);
		try {
			pst = connex.prepareStatement("insert into equipe values(?,?,?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, nom);
			pst.setString(3, nombreJoueur);
			pst.setString(4, points);
			pst.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}
}
