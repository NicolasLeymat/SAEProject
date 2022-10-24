package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe qui défini les fonctions d'une équipe
public class Equipe {


	private String nom;
	private int points;
	private Ecurie ecurie;
	private Jeu jeu;
	private List<Joueur> listeJoueurs;

	//Constructeur de la classe "Equipe"
	public Equipe(String nom, int points, Ecurie ecurie, Jeu jeu) {
		this.nom = nom;
		this.points = points;
		this.ecurie = ecurie;
		this.jeu = jeu;
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	//Fonction qui permet de récuperer l'écurie d'une équipe
	public Ecurie getEcurie() {
		return ecurie;
	}
	
	//Fonction qui permet de changer le nom de l'écurie de l'équipe
	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	//Fonction qui permet de retourner le jeu auquel une équipe joue
	public Jeu getJeu() {
		return jeu;
	}

	//Fonction qui permet de changer le nom du jeu auquel une équipe joue
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	
	//Fonction qui permet de récuperer le nom d'une équipe
	public String getNom() {
		return nom;
	}
	
	//Fonction qui permet de changer le nom d'une équipe
	public void setNom(String nom) {
		this.nom = nom;
	}

	//Fonction qui permet de récuperer les points gagnés par une équipe
	public int getPoints() {
		return points;
	}

	//Fonction qui permet de changer les points d'une équipe
	public void setPoints(int points) {
		this.points = points;
	}
	
	//Fonction qui permet de récuperer le dernier identifiant d'une équipe
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
	
	//Fonction qui permet d'ajouter un joueur à une équipe
	public void addJoueur(Joueur joueur) {
		this.listeJoueurs.add(joueur);
	}

	//Fonction qui permet d'enregistrer une équipe dans la base de données
	public int enregistrerEquipe(Connection connex) throws Exception {
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
