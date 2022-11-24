package Object;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe qui définit les fonctions d'un joueur
public class Joueur {
	private String nom;
	private String prenom;
	private String pseudo;
	private Date dateNaissance;
	private Nationalite nationalite;
	private String nomEquipe;

	//Contructeur de la classe "Joueur"
	public Joueur(String nom, String prenom, String pseudo, Date dateNaissance, Nationalite nationalite, String nomEquipe) throws Exception {
	    this.nom = nom;
	    this.prenom = prenom;
	    this.pseudo = pseudo;
	    this.dateNaissance = dateNaissance;
	    this.nationalite = nationalite;
	    this.nomEquipe = nomEquipe;
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
    public String getNomEquipe() {
        return nomEquipe;
    }

    //Fonction qui permet de changer l'équipe d'un joueur
    public void setEquipe(String equipe) {
        this.nomEquipe = equipe;
    }
    
    public static int getLastId(Connection connex) {
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = connex.createStatement();
			rs = st.executeQuery("Select id_joueur as id from LMN3783A.sae_joueur");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}
    
    public static int getId(Connection connex, Joueur j) throws Exception {
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = connex
					.prepareStatement("select id_joueur from LMN3783A.sae_joueur where nom = ? and prenom = ? and pseudonyme = ? and datedenaissance = ? and nationalites = ? and nom_equipe = ?");
			pst.setString(1, j.nom);
			pst.setString(2, j.prenom);
			pst.setString(3, j.pseudo);
			pst.setDate(4, j.dateNaissance);
			pst.setString(5, j.nationalite.toString());
			pst.setString(6, j.nomEquipe);
			rs = pst.executeQuery();
			if (!rs.next()) {
				throw new IllegalArgumentException();
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
    
    public static int enregistrerJoueur(Connection connex, Joueur joueur) {
    	PreparedStatement pst;
		int lastId = Joueur.getLastId(connex);
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_joueur where nom = ? and prenom = ? and pseudonyme = ?" );
			pst.setString(1, joueur.getNom());
			pst.setString(2, joueur.getPrenom());
			pst.setString(3, joueur.getPseudo());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				return -1;
			}
			
			pst = connex.prepareStatement("insert into LMN3783A.sae_joueur values(?,?,?,?,?,?,?)");
			pst.setInt(1, lastId+1);
			pst.setString(2, joueur.getNom());
			pst.setString(3, joueur.getPrenom());
			pst.setString(4, joueur.getPseudo());
			pst.setDate(5,joueur.getDatenaissance());
			pst.setString(6,joueur.getNationalite());
			pst.setString(7,joueur.nomEquipe);
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}
		return 1;
    }
    
    public static int modifierJoueur(Connection connex, Joueur j, String newPrenom, String newNom, String newPseudo, Date newDate, Nationalite newNat, String newNomEquipe) throws Exception {
		PreparedStatement pst;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_joueur where nom = ? and prenom = ? and pseudonyme = ?" );
			pst.setString(1, j.getNom());
			pst.setString(2, j.getPrenom());
			pst.setString(3, j.getPseudo());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex
					.prepareStatement("update LMN3783A.sae_joueur set prenom = ?, nom = ?, pseudonyme = ?, datedenaissance = ?, nationalites = ?, nom_equipe = ? where id_joueur = ?" );
			pst.setString(1, newPrenom);
			pst.setString(2, newNom);
			pst.setString(3, newPseudo);
			pst.setDate(4, newDate);
			pst.setString(5, newNat.toString());
			pst.setString(6, newNomEquipe);
			pst.setInt(7, getId(connex,j));
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 1;
	}
    
    public static int supprimerJoueur(Connection connex, Joueur j) {
		PreparedStatement pst;
		try {
			
			pst = connex.prepareStatement("select count(1) from LMN3783A.sae_joueur where nom = ? and prenom = ? and pseudonyme = ?" );
			pst.setString(1, j.getNom());
			pst.setString(2, j.getPrenom());
			pst.setString(3, j.getPseudo());
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				return -1;
			}
			
			pst = connex.prepareStatement("delete from LMN3783A.sae_joueur where nom = ? and prenom = ? and pseudonyme = ?" );
			pst.setString(1, j.getNom());
			pst.setString(2, j.getPrenom());
			pst.setString(3, j.getPseudo());
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1; 
		}
		return 1;
	}
    
    public static List<Joueur> getJoueursFromEquipe(Connection connex, String nom) {
		PreparedStatement pst = null;
		ResultSet rs;
		Joueur e = null;
		List<Joueur> r = new ArrayList<Joueur>();
		try {
			pst = connex.prepareStatement("Select j.nom, j.prenom, j.pseudonyme, j.datedenaissance, j.nationalites, j.nom_equipe from LMN3783A.sae_joueur j, LMN3783A.SAE_Equipe e where e.nom = j.nom_equipe and e.nom = ? order by 3");
			pst.setString(1, nom);
			rs = pst.executeQuery();
			while (rs.next()) {
				e = new Joueur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4), Nationalite.valueOf(rs.getString(5).toUpperCase()), rs.getString(6));
				r.add(e);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return r;
	}

	@Override
	public String toString() {
		return "Joueur [" +
				"nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", pseudo='" + pseudo + '\'' +
				", dateNaissance=" + dateNaissance +
				", nationalite=" + nationalite +
				", nomEquipe='" + nomEquipe + '\'' +
				'}';
	}
}
