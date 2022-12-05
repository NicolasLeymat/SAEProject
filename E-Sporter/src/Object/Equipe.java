package Object;

import Application.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Travail restant :
 * - regler le probleme sur l'utilite de mode de jeu
 * - ajouter constructeur
 */

//Classe qui définit les fonctions d'une équipe
public class Equipe {

	private int id;
	private String nom;
	private int points;
	private int idEcurie;
	private int idJeu;
	private int idModeDeJeu;
	private List<Joueur> listeJoueurs;


	public Equipe(String nom) {
		this.nom = nom;
		this.listeJoueurs = new ArrayList<Joueur>();
		this.id = -1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getIdEcurie() {
		return this.idEcurie;
	}

	public void setIdEcurie(int id) {
		this.idEcurie = id;
	}
	
	public int getIdJeu() {
		return this.idJeu;
	}
	
	public void setIdJeu(int id) {
		this.idJeu = id;
	}
	
	public int getIdModeDeJeu() {
		return idModeDeJeu;
	}
	
	public void setIdModeDeJeu(int id) {
		this.idModeDeJeu = id;
	}
	
	public List<Joueur> getJoueurs(){
		return this.listeJoueurs;
	}
	
	public Ecurie getEcurie() {
		return Ecurie.getEcurieFromId(this.idEcurie);
	}
	
	//Fonction qui permet de retourner le jeu auquel une équipe joue à partir de son id
	public Jeu getJeu(Connection connex) {
		return Jeu.getJeuFromId(connex, idJeu);
	}
	
	//Fonction qui permet d'ajouter un joueur à une équipe
	public void addJoueur(Joueur joueur) {
		this.listeJoueurs.add(joueur);
	}
	
	
	//Fonction qui permet d'enregistrer une équipe dans la base de données
	public static int enregistrerEquipe(Equipe equipe) throws Exception {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, equipe.getNom());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) != 0) {
				return -1;
			}
			
			if (equipe.getId() == -1) {
				equipe.setId(Equipe.getLastId()+1);
			}
			
			pst = connex.prepareStatement("insert into LMN3783A.sae_equipe(id_equipe, nom, nombrejoueur, points, id_ecurie, id_jeu) values(?,?,?,?,?,?)");
			pst.setInt(1, equipe.getId());
			pst.setString(2, equipe.getNom());
			pst.setInt(3, equipe.listeJoueurs.size());
			pst.setInt(4, equipe.getPoints());
			pst.setInt(5,equipe.getIdEcurie());
			pst.setInt(6,equipe.getIdJeu());
			pst.executeUpdate();
			
			for (Joueur j : equipe.getJoueurs()) {
				j.setIdEquipe(equipe.getId());
				Joueur.enregistrerJoueur(j);
			}
			
			rs.close();
			pst.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public static int modifierEquipe(Equipe e) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where id_equipe = ?" );
			pst.setInt(1, e.getId());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("update LMN3783A.sae_equipe set nom = ?, nombrejoueur = ?, id_ecurie = ?, id_jeu = ? where id_equipe = ?" );
			pst.setString(1, e.getNom());
			pst.setInt(2, e.getJoueurs().size());
			pst.setInt(3, e.getIdEcurie());
			pst.setInt(4, e.getIdJeu());
			pst.setInt(5, e.getId());
			pst.executeUpdate();
			
			rs.close();
			pst.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public static int supprimerEquipe(Equipe e) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, e.getNom());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			for (Joueur j : e.getJoueurs()) {
				Joueur.supprimerJoueur(j);
			}
			
			pst = connex.prepareStatement("delete from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, e.getNom());
			pst.executeUpdate();
			
			rs.close();
			pst.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1; 
		}
		return 1;
	}

	public static List<Equipe> getAllEquipes() {
		List<Equipe> equipes = new ArrayList<Equipe>();
		Connection connex = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		Equipe e = null;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("select id_equipe, nom, points, id_ecurie, id_jeu from LMN3783A.sae_equipe order by nom");
			while (rs.next()) {
				e = new Equipe(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setPoints(rs.getInt(3));
				e.setIdEcurie(rs.getInt(4));
				e.setIdJeu(rs.getInt(5));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(e.getId());
				equipes.add(e);
			}
			
			rs.close();
			st.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return equipes;
	}

	public static List<Equipe> getClassementByGame(int id_jeu) {
		Connection connex = Connexion.connexion();
		PreparedStatement ps;
		ResultSet rs;
		List<Equipe> equipes = new ArrayList<Equipe>();
		Equipe e = null;
		
		try {
			
			ps = connex.prepareStatement("select id, nom, points, id_ecurie,id_jeu from LMN3783A.sae_equipe where id_jeu = ? ORDER BY points");
			ps.setInt(1,id_jeu);
			rs = ps.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setPoints(rs.getInt(3));
				e.setIdEcurie(rs.getInt(4));
				e.setIdJeu(rs.getInt(5));
				equipes.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return equipes;
	}

	public static List<Equipe> getEquipesFromEcurie(int id) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst = null;
		ResultSet rs;
		Equipe e = null;
		List<Equipe> r = new ArrayList<Equipe>();
		try {
			pst = connex.prepareStatement("Select id_equipe, nom, points, id_ecurie, id_jeu from LMN3783A.sae_equipe where id_ecurie= ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setPoints(rs.getInt(3));
				e.setIdEcurie(rs.getInt(4));
				e.setIdJeu(rs.getInt(5));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(e.getId());
				r.add(e);
			}
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	public static List<Equipe> getEquipeFromNomAll(String nom) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst = null;
		ResultSet rs;
		List<Equipe> l = new LinkedList<>();
		Equipe e = null;
		
		try {
			
			pst = connex.prepareStatement("Select id_equipe, nom, points, id_ecurie, id_jeu from LMN3783A.sae_equipe where nom LIKE ?");
			pst.setString(1, nom+"%");
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setPoints(rs.getInt(3));
				e.setIdEcurie(rs.getInt(4));
				e.setIdJeu(rs.getInt(5));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(e.getId());
				l.add(e);
			}
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return l;
	}
	
	public static Equipe getEquipeFromNom(String nom) {
		Connection connex = Connexion.connexion();

		PreparedStatement pst = null;
		ResultSet rs;
		Equipe e = null;
		
		try {
			
			pst = connex.prepareStatement("Select id_equipe, nom, points, id_ecurie, id_jeu from LMN3783A.sae_equipe where nom = ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(2));
				e.setId(rs.getInt(1));
				e.setPoints(rs.getInt(3));
				e.setIdEcurie(rs.getInt(4));
				e.setIdJeu(rs.getInt(5));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(e.getId());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	
	public static Equipe getEquipeFromId(int id) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		Equipe e = null;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where id_equipe = ?" );
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return e;
			}
			
			pst = connex.prepareStatement("select id_equipe, nom, points, id_ecurie, id_jeu from LMN3783A.sae_ecurie where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			e = new Equipe(rs.getString(2));
			e.setId(rs.getInt(1));
			e.setNom(rs.getString(2));
			e.setPoints(rs.getInt(3));
			e.setIdEcurie(rs.getInt(4));
			e.setIdJeu(rs.getInt(5));
			e.listeJoueurs = Joueur.getJoueursFromEquipe(rs.getInt(1));
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	
	public static int getLastId() {
		Connection connex = Connexion.connexion();
		Statement st;
		ResultSet rs;
		int r = 0;
		
		try {
			
			st = connex.createStatement();
			rs = st.executeQuery("select max(id_equipe) from LMN3783A.sae_equipe");
			rs.next();
			r = rs.getInt(1);
			
			rs.close();
			st.close();
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	public static String getNomEquipeFromId(int id) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		String s = null;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where id_equipe = ?" );
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return s;
			}
			
			pst = connex.prepareStatement("select nom from LMN3783A.sae_equipe where id_equipe = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			s = rs.getString(1);
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	@Override
	public String toString() {
		return nom + ", points : " + points + ", Jeu=" + idJeu + ", ModeDeJeu=" + idModeDeJeu + ", listeJoueurs=" + listeJoueurs + "]";
	}
	
}
