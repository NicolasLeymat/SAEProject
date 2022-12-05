package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Application.Connexion;

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
	
	
	public static ModeDeJeu getModeDeJeu(int id) {
		Connection connx = Connexion.connexion();
		ModeDeJeu res = null;
		PreparedStatement pst;
		try {
			System.out.println("Coucou");
			pst = connx.prepareStatement("Select id_mode, nom, nb_joueur, id_jeu from LMN3783A.SAE_MODE_DE_JEU where id_Mode = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				res = new ModeDeJeu(rs.getInt(1), rs.getString(2), rs.getInt(3),Jeu.getJeuFromId(rs.getInt(4)));
				
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


	@Override
	public String toString() {
		return "ModeDeJeu [id_Mode=" + id_Mode + ", nom=" + nom + ", nbMinJoueur=" + nbMinJoueur + ", jeu=" + jeu + "]";
	}
	
	
	
	
}