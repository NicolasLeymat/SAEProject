package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeDeJeu {
	
	private int id_Mode;
	private String nom;
	private int nbMinJoueur;
	private Jeu jeu;
	
	private ModeDeJeu(int id, String nom, int nbJoueur, Jeu jeu) {
		this.id_Mode = id;
		this.nom = nom;
		this.nbMinJoueur = nbJoueur;
		this.jeu = jeu;
	}
	
	
	public static ModeDeJeu getModeDeJeu(Connection connx, int id) {
		ModeDeJeu res = null;
		PreparedStatement pst;
		try {
			pst = connx.prepareStatement("Select * from SAE_MODE_DE_JEU where id_Mode = ?");
			pst.setInt(0, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				res = new ModeDeJeu(rs.getInt(0), rs.getString(1), rs.getInt(2),Jeu.getJeuFromId(rs.getInt(3)));
			}
		}catch (SQLException e) {
			e.getStackTrace();
		}
		
		return res;
	}


	public int getId_Mode() {
		return id_Mode;
	}


	public void setId_Mode(int id_Mode) {
		this.id_Mode = id_Mode;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbMinJoueur() {
		return nbMinJoueur;
	}


	public void setNbMinJoueur(int nbMinJoueur) {
		this.nbMinJoueur = nbMinJoueur;
	}


	public Jeu getJeu() {
		return jeu;
	}


	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	
	
}