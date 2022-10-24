package Object;


import java.sql.Date;

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
    public Nationalite getNationalite() {
        return nationalite;
    }

    //Fonction qui permet de récuperer l'équipe d'un joueur
    public Equipe getEquipe() {
        return equipe;
    }

    //Fonction qui permet de changer l'équipe d'un joueur
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
