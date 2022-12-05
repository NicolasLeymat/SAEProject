package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Application.Connexion;

/*
 * Travail restant :
 * - ajouter le logo
 * - refactorer
 * - ajouter l'id de l'ecurie a une equipe quand on l'ajoute a une ecurie
 * - rajouter plus de constructeurs pour simplifier certains cas
 */

//Classe qui definit les fonctions d'une ecurie
public class Ecurie {
	
	/**
	 * nom de l'ecurie
	 */
	private String nom;
	/**
	 * liste contenant les equipes d'une ecurie
	 */
	private List<Equipe> listeEquipes;
	/**
	 * id d'une ecurie
	 */
	private int id;
	/**
	 * logo d'une ecurie
	 */
	private String logo;
	/**
	 * construit une ecurie a partir d'un nom
	 * @param nom
	 * 		nom d'une ecurie
	 */
	public Ecurie(String nom) {
		this.nom = nom;
		this.id = -1;
		this.listeEquipes = new ArrayList<Equipe>();
	}
	/**
	 * retourne l'id d'une ecurie
	 * @return id de l'ecurie
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * affecte une id a une ecurie
	 * @param id
	 * 		id d'une ecurie
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * retourne le nom d'une ecurie
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * change le nom d'une ecurie
	 * @param nom
	 * 		nouveau nom de l'ecurie
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * retourne l'adresse du logo d'une ecurie
	 * @return adresse logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * ajoute ou modifie l'adresse du logo d'une ecurie
	 * @param logo
	 * 		adresse du logo d'une ecurie
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	

	/**
	 * ajoute une equipe a une ecurie
	 * @param equipe
	 */
	public void addEquipe(Equipe equipe) {
		this.listeEquipes.add(equipe);
	}
	/**
	 * retourne une equipe appartenant a une ecurie a partir de son nom
	 * @param nom
	 * 		nom de l'ecurie
	 * @return une ecurie ou null
	 */
	public Equipe getEquipe(String nom) {
		for (Equipe equipe : this.listeEquipes) {
			if (equipe.getNom() == nom) {
				return equipe;
			}
		}
		return null;	
	}
	/**
	 * supprime une equipe d'une ecurie
	 * @param equipe
	 * 		equipe a supprimer
	 */
	public void removeEquipe(Equipe equipe) {
		this.listeEquipes.remove(equipe);
	}
	/**
	 * retourne toutes les equipes d'une ecurie
	 * @return equipes
	 */
	public List<Equipe> getEquipes(){
		return this.listeEquipes;
	}
	/**
	 * ajoute une liste d'equipes dans une ecurie en supprimant les equipes deja 
	 * existante si elles existent
	 * @param liste 
	 * 		liset d'equipes
	 */
	public void addEquipes(List<Equipe> liste) {
		this.listeEquipes = liste;
	}


	/**
	 * enregistre une ecurie dans la base de donnees
	 * si elle n'existe pas deja
	 * ainsi que toutes les equipes et les joueurs associes
	 * @param e 
	 * 		ecurie
	 * @return 1 si la fonction a réussi ou -1 si la fonction a echoue
	 */
	public static int enregistrerEcurie(Ecurie e) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_ecurie where nom = ?" );
			pst.setString(1, e.getNom());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) != 0) {
				return -1;
			}
						
			if (e.getId() == -1) {
				e.setId(Ecurie.getLastId()+1);
			}
			
			pst = connex.prepareStatement("insert into LMN3783A.sae_ecurie(id_ecurie, nom) values(?,?)");
			pst.setInt(1, e.getId());
			pst.setString(2, e.getNom());
			pst.executeUpdate();
			
			for (Equipe eq : e.getEquipes()) {
				eq.setIdEcurie(e.getId());
				Equipe.enregistrerEquipe(eq);
			}
			
			pst.close();
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return 1;
	}
	/**
	 * modifie une equipe dans la base de donnees a partir de son id
	 * si l'id n'existe pas dans la base de donnees, il n'y a pas de modifications
	 * @param e
	 * 		ecurie a modifier
	 * @return 1 si la modification a eu lieu, -1 sinon 
	 */
	public static int modifierEcurie(Ecurie e) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_ecurie where id_ecurie = ?" );
			pst.setInt(1, e.getId());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("update LMN3783A.sae_ecurie set nom = ?" );
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
	/**
	 * supprimer une ecurie de la base de donnees si elle existe
	 * @param e 
	 * 		ecurie
	 * @return 1 si la fonction a réussi ou -1 si la fonction a echoue
	 */
	public static int supprimerEcurie(Ecurie e) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_ecurie where nom = ?" );
			pst.setString(1, e.getNom());
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("delete from LMN3783A.sae_ecurie where nom = ?" );
			pst.setString(1, e.getNom());
			pst.executeUpdate();
			
			for (Equipe eq : e.getEquipes()) {
				Equipe.supprimerEquipe(eq);
			}
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1; 
		}
		return 1;
	}
	/**
	 * retourne l'ecurie associee a un nom si elle existe
	 * @param nom 
	 * 		nom de l'ecurie
	 * @return l'ecurie si elle existe, null sinon
	 */
	public static Ecurie getEcurieFromNom(String nom) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		Ecurie e = null;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_ecurie where nom = ?" );
			pst.setString(1, nom);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return e;
			}
			
			pst = connex.prepareStatement("select id_ecurie, nom from LMN3783A.sae_ecurie where nom = ?");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			rs.next();
			e = new Ecurie(rs.getString(2));
			e.setId(rs.getInt(1));
			e.listeEquipes = Equipe.getEquipesFromEcurie(rs.getInt(1));
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	/**
	 * retourne l'ecurie associee a une id si elle existe
	 * @param id 
	 * 		id de l'ecurie
	 * @return l'ecurie si elle existe, null sinon
	 */
	public static Ecurie getEcurieFromId(int id) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		Ecurie e = null;
		
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_ecurie where id = ?" );
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return e;
			}
			
			pst = connex.prepareStatement("select id_ecurie, nom from LMN3783A.sae_ecurie where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			rs.next();
			e = new Ecurie(rs.getString(2));
			e.setId(rs.getInt(1));
			e.listeEquipes = Equipe.getEquipesFromEcurie(rs.getInt(1));
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	/**
	 * retourne toutes les ecuries dont le nom commence par le parametre nom
	 * @param nom 
	 * 		debut du nom des ecuries a chercher
	 * @return la liste des ecuries dont le nom commence par le parametre nom
	 */
	public static List<Ecurie> getEcurieFromNomAll(String nom) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		List<Ecurie> l = new ArrayList<>();
		Ecurie e = null;
		
		try {
			pst = connex.prepareStatement("select id_ecurie, nom from LMN3783A.sae_ecurie where nom LIKE ? order by nom");
			pst.setString(1, nom+"%");
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Ecurie(rs.getString(2));
				e.setId(rs.getInt(1));
				e.listeEquipes = Equipe.getEquipesFromEcurie(rs.getInt(1));
				l.add(e);
			}
			
			rs.close();
			pst.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return l;
	}
	/**
	 * retourne toutes les ecuries de la base de donnees
	 * @return les ecuries de la base de donnees
	 */
	public static List<Ecurie> getAllEcuries() {
		Connection connex = Connexion.connexion();
		Statement st;
		ResultSet rs;
		List<Ecurie> ecuries = new ArrayList<>();
		Ecurie e = null;
		
		try {
			st = connex.createStatement();
			rs = st.executeQuery("select id_ecurie, nom from LMN3783A.sae_ecurie order by nom");
			while (rs.next()) {
				e = new Ecurie(rs.getString(2));
				e.setId(rs.getInt(1));
				e.listeEquipes = Equipe.getEquipesFromEcurie(rs.getInt(1));
				ecuries.add(e);
			}
			
			rs.close();
			st.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ecuries;
	}
	/**
	 * retourne l'id la plus grande de la base de donnees
	 * @return id
	 */
	public static int getLastId() {
		Connection connex = Connexion.connexion();
		Statement st;
		ResultSet rs;
		int r = 0;
		
		try {
			
			st = connex.createStatement();
			rs = st.executeQuery("select max(id_ecurie) from LMN3783A.sae_ecurie");
			rs.next();
			r = rs.getInt(1);
			
			rs.close();
			st.close();
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return r;
	}

	@Override
	public String toString() {
		return nom + ", Nombre d'équipes posseder : " + this.listeEquipes.size();
	}

}
