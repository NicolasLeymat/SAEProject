package Object;

import Application.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
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
		return Ecurie.getEcurieFromNomAll(connex, nomEcurie).get(0);
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
	
	public List<Joueur> getJoueurs(){
		return this.listeJoueurs;
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
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, equipe.getNom());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) != 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("insert into LMN3783A.sae_equipe(nom, nombrejoueur, points, nom_ecurie, id_jeu) values(?,?,?,?,?)");
			pst.setString(1, equipe.getNom());
			pst.setInt(2, equipe.listeJoueurs.size());
			pst.setInt(3, equipe.getPoints());
			pst.setString(4,equipe.getNomEcurie());
			pst.setInt(5,equipe.getIdJeu());
			pst.executeUpdate();
			rs.close();
			pst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}
	
	public static int modifierEquipe(Connection connex, Equipe e, Equipe eNew) {
		PreparedStatement pst;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, e.getNom());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("update LMN3783A.sae_equipe set nom = ?, nombrejoueur = ?, nom_ecurie = ? where nom = ?" );
			pst.setString(1, eNew.getNom());
			pst.setInt(2, eNew.getJoueurs().size());
			pst.setInt(3, eNew.points);
			pst.setInt(4, eNew.getEcurie(connex).getId());
			pst.setInt(5, eNew.getIdJeu());
			pst.setString(6, e.getNom());
			pst.executeUpdate();
			rs.close();
			pst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 1;
	}
	
	public static int supprimerEquipe(Connection connex, Equipe e) {
		PreparedStatement pst;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, e.getNom());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			
			pst = connex.prepareStatement("delete from LMN3783A.sae_equipe where nom = ?" );
			pst.setString(1, e.getNom());
			pst.executeUpdate();
			rs.close();
			pst.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1; 
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
			rs = st.executeQuery("Select nom, points, nom_ecurie, id_jeu from LMN3783A.sae_equipe order by nom");
			while (rs.next()) {
				e = new Equipe(rs.getString(1),rs.getInt(2),rs.getString(3), rs.getInt(4));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(connex, e.getNom());
				equipes.add(e);
			}
			rs.close();
			st.close();
			return equipes;
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return equipes;
	}

	public static List<Equipe> getClassementByGame(int id_jeu) {
		List<Equipe> equipes = new ArrayList<Equipe>();
		Connection connex = Connexion.connexion();
		Equipe e = null;
		try {
			PreparedStatement ps = connex.prepareStatement("Select nom, points, nom_ecurie,id_jeu from LMN3783A.sae_equipe where id_jeu = ? ORDER BY points");
			ps.setInt(1,id_jeu);
			ResultSet rs = ps.executeQuery();
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
			pst = connex.prepareStatement("Select nom, points, nom_ecurie, id_jeu from LMN3783A.sae_equipe where nom_ecurie= ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(connex, e.getNom());
				r.add(e);
			}
			rs.close();
			pst.close();
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	public static List<Equipe> getEquipeFromNomAll(Connection connex, String nom) {
		PreparedStatement pst = null;
		ResultSet rs;
		List<Equipe> l = new LinkedList<>();
		Equipe e = null;
		try {
			pst = connex.prepareStatement("Select nom, points, nom_ecurie, id_jeu from LMN3783A.sae_equipe where nom LIKE ?");
			pst.setString(1, nom+"%");
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Equipe(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				e.listeJoueurs = Joueur.getJoueursFromEquipe(connex, e.getNom());
				l.add(e);
			}
			rs.close();
			pst.close();
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return l;
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
