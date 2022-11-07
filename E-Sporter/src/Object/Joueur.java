package Object;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Classe qui définit les fonctions d'un joueur
public class Joueur {
	private String nom;
	private String prenom;
	private String pseudo;
	private Date dateNaissance;
	private Nationalite nationalite;
	private Equipe equipe;

	//Contructeur de la classe "Joueur"
	public Joueur(String nom, String prenom, String pseudo, Date dateNaissance, Nationalite nationalite, Equipe equipe) throws Exception {
	    this.nom = nom;
	    this.prenom = prenom;
	    this.pseudo = pseudo;
	    this.dateNaissance = dateNaissance;
	    this.nationalite = nationalite;
	    this.equipe = equipe;
	}
	
	//Fonction qui permet de récuperer le nom d'un joueur
    public String getNom() {
        return nom;
    }
     
    //Fonction qui permet de changer le nom d'un joueur
    public void setNom(String nom) {
		this.nom = nom;
	}
    
    //Fonction qui permet de changer le prénom d'un joueur
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	//Fonction qui permet de changer le pseudo d'un joueur
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	//Fonction qui permet de changer la nationalité d'un joueur
	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	//Fonction qui permet de récuperer le prénom d'un joueur
	public String getPrenom() {
        return prenom;
    }
	
	//Fonction qui permet de récuperer le pseudo d'un joueur
    public String getPseudo() {
        return pseudo;
    }
    
    //Fonction qui permet de récuperer la date de naissance d'un joueur
    public Date getDatenaissance() {
        return dateNaissance;
    }
    
    //Fonction qui permet de récuperer la nationalité d'un joueur
    public String getNationalite() {
        return nationalite.toString();
    }

    //Fonction qui permet de récuperer l'équipe d'un joueur
    public Equipe getEquipe() {
        return equipe;
    }

    //Fonction qui permet de changer l'équipe d'un joueur
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
    public static int getLastId(Connection connex) {
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("Select id_equipe as id from LMN3783A.sae_equipe");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
    
    public static int enregistrerJoueur(Connection connex, Joueur joueur) {
    	PreparedStatement pst;
		int lastId = Joueur.getLastId(connex);
		try {
			pst = connex.prepareStatement("insert into LMN3783A.sae_joueur values(?,?,?,?,?,?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, joueur.getNom());
			pst.setString(3, joueur.getPrenom());
			pst.setString(4, joueur.getPseudo());
			pst.setDate(5,joueur.getDatenaissance());
			pst.setString(6,joueur.getNationalite());
			pst.setInt(7,joueur.getEquipe().getId(connex));
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
    }
}
