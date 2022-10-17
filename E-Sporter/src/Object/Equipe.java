package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Equipe {


	private String nom;
	private int points;
	private Ecurie ecurie;
	private Jeu jeu;
	private List<Joueur> listeJoueurs;

	//Il faudrait peut être changer le type de jeu
	public Equipe(String nom, int points, Ecurie ecurie, Jeu jeu) {
		this.nom = nom;
		this.points = points;
		this.ecurie = ecurie;
		this.jeu = jeu;
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
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
			rs = st.executeQuery("Select id_equipes as id from LMN3783A.sae_equipe");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	public void addJoueur(Joueur joueur) {
		this.listeJoueurs.add(joueur);
	}

	public int enregistrerEquipe() throws Exception {
		Connection connex = Application.Connexion.connexion();
		PreparedStatement pst;
		int lastId = this.getLastId(connex);
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_equipe values(?,?,?,?,?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, nom);
			pst.setInt(3, listeJoueurs.size());
			pst.setInt(4, points);
			pst.setInt(5,this.ecurie.getId());
			pst.setInt(6,this.jeu.getId());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}
}
