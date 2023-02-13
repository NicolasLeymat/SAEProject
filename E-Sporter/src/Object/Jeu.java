package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Application.Connexion;

public class Jeu {

	/**
	 * id du jeu
	 */
	private int id;
	/**
	 * nom du jeu
	 */
	private String nom;
	/**
	 * tous les modes de jeu d'un jeu
	 */
	private List<ModeDeJeu> modesDeJeu;
	
	/**
	 * construit un jeu a partir d'une id et d'un nom
	 * @param id
	 * @param nomJeu
	 */
	public Jeu(int id, String nomJeu) {
		this.id = id;
		this.nom = nomJeu;
		this.modesDeJeu = new ArrayList<ModeDeJeu>();
	}
	
	/**
	 * Retourne un nom
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Modifie un nom
	 * @param nomJeu
	 */
	public void setNom(String nomJeu) {
		this.nom = nomJeu;
	}
	
	/**
	 * Retourne la liste des modes d'un jeu
	 * @return
	 */
	public List<ModeDeJeu> getModesDeJeu(){
		return this.modesDeJeu;
	}
	
	/**
	 * Modifie la liste des modes d'un jeu
	 * @param l
	 */
	public void setModeDeJeu(List<ModeDeJeu> l) {
		this.modesDeJeu = l;
	}
	
	/**
	 * Retourne un id jeu non utilise
	 * @return dernier id de la base +1
	 */
	public int getLastId() {
		Connection ct = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select max(id_jeu) as id from LMN3783A.sae_jeu");
			if (rs.next()) {
				r = rs.getInt("id")+1;
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	/**
	 * Retourne le jeu a partir d'un id
	 * @param id
	 * @return
	 */
	public static Jeu getJeuFromId(int id) {
        Connection connx = Connexion.connexion();
		Jeu jeu = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connx.prepareStatement("SELECT nom as n FROM LMN3783A.sae_Jeu where id_jeu = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                jeu = new Jeu(id, rs.getString("n"));
                jeu.setModeDeJeu(ModeDeJeu.getModesDeJeuFromIdJeu(jeu));
            }
            
            rs.close();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jeu;
    }
	
	/**
	 * Retourne une liste contenant tous les jeux présent dans la base de données
	 * @return List<Jeu>
	 */
	public static List<Jeu> getAllJeux() {
		Connection connx = Connexion.connexion();
		Jeu j = null;
		List<Jeu> res = new LinkedList<>();
		PreparedStatement pst;
		try {
			pst = connx.prepareStatement("Select id_jeu, nom from LMN3783A.SAE_JEU order by nom");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				j = new Jeu(rs.getInt(1), rs.getString(2));
				j.setModeDeJeu(ModeDeJeu.getModesDeJeuFromIdJeu(j));
				res.add(j);
			}
			
			rs.close();
			pst.close();
			
		}catch (SQLException e) {
			e.getStackTrace();
		}
		
		return res;
	}
	/**
	 * Retourner un id
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Modifie un id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}


}
