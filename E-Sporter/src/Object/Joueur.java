package Object;


import java.text.DateFormat;

public class Joueur {
private String nom;
private String prénom;
private String pseudo;
private DateFormat datenaissance;
private Nationalite nationalité;
private Equipe equipe;

public Joueur(String nom, String prénom, String pseudo, String datenaissance, Nationalite nationalité, Equipe equipe) throws Exception {
    this.nom = nom;
    this.prénom = prénom;
    this.pseudo = pseudo;
    this.datenaissance.parse(datenaissance);
    this.nationalité = nationalité;
    this.equipe = equipe;
}

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public DateFormat getDatenaissance() {
        return datenaissance;
    }

    public Nationalite getNationalité() {
        return nationalité;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
