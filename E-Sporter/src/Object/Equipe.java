package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe qui définit les fonctions d'une équipe
public class Equipe {


	private String nom;
	private int points;
	private String nomEcurie;
	private int id_jeu;
	private List<Joueur> listeJoueurs;


	public Equipe(String nom, int points, String nom_ecurie, int id_jeu) {
		this.nom = nom;
		this.points = points;
		this.nomEcurie = nom_ecurie;
		this.id_jeu = id_jeu;
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	public Ecurie getEcurie(Connection connex) {
		return Ecurie.getEcurieFromNom(connex, nomEcurie);
	}

	public void setNomEcurie(String nom_ecurie) {
		this.nomEcurie = nom_ecurie;
	}
	
	public String getNomEcurie() {
		return this.nomEcurie;
	}
	
	private int getIdJeu() {
		return id_jeu;
	}
	
	//Fonction qui permet de retourner le jeu auquel une équipe joue à partir de son id
	public Jeu getJeu(Connection connex) {
		return Jeu.getJeuFromId(connex, id_jeu);
	}


	//Fonction qui permet de changer le nom du jeu auquel une équipe joue
	public void setJeu(int jeu) {
		this.id_jeu = jeu;
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
	
	//Fonction qui permet d'ajouter un joueur à une équipe
	public void addJoueur(Joueur joueur) {
		this.listeJoueurs.add(joueur);
	}

	//Fonction qui permet d'enregistrer une équipe dans la base de données
	public static int enregistrerEquipe(Connection connex, Equipe equipe) throws Exception {
		PreparedStatement pst;
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_equipe(nom, nombrejoueur, points, nom_1, id_jeu) values(?,?,?,?,?)");
			pst.setString(1, equipe.getNom());
			pst.setInt(2, equipe.listeJoueurs.size());
			pst.setInt(3, equipe.getPoints());
			pst.setString(4,equipe.getNomEcurie());
			pst.setInt(5,equipe.getIdJeu());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public static int modifierEquipe(Connection connex, Equipe e, String newName, int nbJoueur, int points, String nomEcurie, int idJeu) {
		PreparedStatement pst;
		try {
			pst = connex
					.prepareStatement("update LMN3783A.sae_equipe set nom = ?, nombrejoueur = ?, points = ?, nom_1 = ?, id_jeu = ? where nom = ?" );
			pst.setString(1, newName);
			pst.setInt(2, nbJoueur);
			pst.setInt(3, points);
			pst.setString(4, nomEcurie);
			pst.setInt(5, idJeu);
			pst.setInt(6, e.getIdJeu());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 1;
	}

	public static List<Equipe> getAllEquipes(Connection connex) {
		List<Equipe> equipes = new ArrayList<Equipe>();
		java.sql.Statement st = null;
		ResultSet rs;
		Equipe e = null;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("Select nom, points, nom_ecurie, id_jeu from LMN3783A.sae_equipe");
			while (rs.next()) {
				e = new Equipe(rs.getString(1),rs.getInt(2),rs.getString(3), rs.getInt(4));
				equipes.add(e);
			}
			return equipes;
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return equipes;
	}

	public static List<Equipe> getEquipesFromEcurie(Connection connex, String nom) {
		PreparedStatement pst = null;
		ResultSet rs;
		Equipe e = null;
		List<Equipe> r = new ArrayList<Equipe>();
		try {
			pst = connex.prepareStatement("Select eq.nom, points, eq.nom, id_jeu from LMN3783A.sae_equipe eq, LMN3783A.SAE_Ecurie ec where eq.nom_ecurie = ec.nom and eq.nom_ecurie = ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(connex, rs.getString(1));
				r.add(e);
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	public static Equipe getEquipeFromNom(Connection connex, String nom) {
		PreparedStatement pst = null;
		ResultSet rs;
		Equipe e = null;
		try {
			pst = connex.prepareStatement("Select nom, points, nom_ecurie, id_jeu from LMN3783A.sae_equipe where nom = ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(connex, nom);
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return e;
	}

	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", points=" + points + ", nomEcurie=" + nomEcurie + ", jeu=" + id_jeu
				+ ", listeJoueurs=" + listeJoueurs + "]";
	}
	
	
}
