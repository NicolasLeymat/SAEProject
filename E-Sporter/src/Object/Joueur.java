package Object;


import java.text.DateFormat;

public class Joueur {
private String nom;
private String prenom;
private String pseudo;
private DateFormat datenaissance;
private Nationalite nationalite;
private Equipe equipe;

public Joueur(String nom, String prenom, String pseudo, String datenaissance, Nationalite nationalite, Equipe equipe) throws Exception {
    this.nom = nom;
    this.prenom = prenom;
    this.pseudo = pseudo;
    this.datenaissance.parse(datenaissance);
    this.nationalite = nationalite;
    this.equipe = equipe;
}

    public String getNom() {
        return nom;
    }
     
    public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public DateFormat getDatenaissance() {
        return datenaissance;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
