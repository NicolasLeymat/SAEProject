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
		this.modeDeJeu = new HashMap<String,Integer>();
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
	
	//Fonction qui permet de récuperer le nombre de joueurs d'un jeu
		public int getNbJoueurs(String nomMode) {
			return this.modeDeJeu.get(nomMode);
	}
		
	public static int getId(Jeu jeu) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = connex.prepareStatement("select id_jeu from LMN3783A.sae_jeu where LMN3783A.sae_jeu.nom = ?");
			pst.setString(1, jeu.getNomJeu());
			rs = pst.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		}
	
	public int enregistrerJeu() {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		int lastId = this.getLastId();
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_jeu values(?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, nomJeu);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
	}
	
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
                jeu = new Jeu(rs.getString("n"));
            }
            
            rs.close();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jeu;
    }


}
