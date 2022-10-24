package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Application.Connexion;

//Classe qui définit les fonctions d'un jeu
public class Jeu {

	private String nomJeu;
	private HashMap<String, Integer> modeDeJeu;

	//Constructeur de la classe "Jeu"
	public Jeu(String nomJeu) {
		this.modeDeJeu = new HashMap<String, Integer>();
		this.nomJeu = nomJeu;
	}

	//Fonction qui permet de récuperer le nom d'un jeu
	public String getNomJeu() {
		return this.nomJeu;
	}

	//Fonction qui permet de changer le nom d'un jeu
	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	//Fonction qui permet de rajouter un mode de jeu
	public void addModeDeJeu(String mode, int nbJoueurs) {
		this.modeDeJeu.put(mode, nbJoueurs);
	}
	
	//Fonction qui permet de récuperer le nombre de joueurs d'un jeu
	public int getNbJoueurs(String nomMode) {
		return this.modeDeJeu.get(nomMode);
	}

	//Fonction qui permet de récuperer l'identifiant d'un jeu
	public int getId() {
		Connection co = Connexion.connexion();
		java.sql.Statement st;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id_jeu from LMN3783A.sae_jeu where '" + this.nomJeu + "'= LMN3783A.sae_jeu.nom");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//Fonction qui permet de récuperer le dernier identifiant d'un jeu
	public int getLastId() {
		Connection ct = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select id_jeu as id from LMN3783A.sae_jeu");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
	
	//Fonction qui permet d'enregistrer un jeu dans la base de données
	public int enregistrerJeu() {
		Connection connex = Application.Connexion.connexion();
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
	
	public static Jeu getJeuFromId(Connection connx, int id) {
        Jeu jeu = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = connx.prepareStatement("SELECT nom as n FROM LMN3783A where id_jeu = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                jeu = new Jeu(rs.getString("n"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jeu;
    }


}
