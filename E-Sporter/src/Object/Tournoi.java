package Object;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Classe qui définit les fonctions d'un tournoi
public class Tournoi {

	private String nom;
	private Date dateTournoi;
	private int notoriete;
	private Jeu jeu;
	private ArrayList<Equipe> listeEquipe;

	//Constructeur de la classe "Tournoi"
	public Tournoi(String nom, Date dateTournoi, int notoriete, Jeu jeu) throws Exception {
		
		if (notoriete > 3 || notoriete < 1) {
			throw new Exception();
		}
		/**if (dateInvalide(dateTournoi)) {
			throw new Exception();
		}*/
		
		this.nom = nom;
		this.dateTournoi = dateTournoi;
		//this.championnat = championnat;
		this.notoriete = notoriete;
		this.jeu = jeu;
		this.listeEquipe = new ArrayList<Equipe>();
	}

    //Fonction qui permet de récuperer le nom d'un tournoi
	public String getNom() {
		return nom;
	}
	
	//Fonction qui permet de récuperer une équipe d'un tournoi
	public Equipe getEquipe (String nom) {
		for (Equipe e : this.listeEquipe) {
			if (e.getNom() == nom) {
				return e;
			}
		}
		return null;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//Fonction qui permet de récuperer la date d'un tournoi
	public Date getDateTournoi() {
		return dateTournoi;
	}
	
	//Fonction qui permet de changer la date d'un tournoi
	public void setDateTournoi(Date dateTournoi) {
		this.dateTournoi = dateTournoi;
	}

	//Fonction qui permet de récuperer la notoriété d'un tournoi
	public int getNotoriete() {
		return notoriete;
	}

	//Fonction qui permet de changer la notoriété
	public void setNotoriete(int notoriete) {
		this.notoriete = notoriete;
	}
	
	//Fonction qui permet d'ajouter une équipe à un tournoi
	public void addEquipe(Equipe equipe) throws Exception{
		if (this.listeEquipe.size()>=16) {
			throw new Exception("");
		}
		if (dateInvalide(this.dateTournoi)==true) {
			throw new Exception();
		}
		this.listeEquipe.add(equipe);
	}
	
	//Fonction qui permet de retourner une réponse positive ou négative si une date est invalide
	private static boolean dateInvalide(Date date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String temp = dtf.format(now);
		Date today = Date.valueOf(temp);
		boolean res = date.before(today);
		return res;
		
	}

	//Fonction qui permet de récuperer le jeu du tournoi
	public Jeu getJeu() {
		return jeu;
	}
	
	//Fonction qui permet de récuperer une équipe d'un tournoi
	public Equipe getEquipeTournoi(int i) {
		return this.listeEquipe.get(i);
	}
}
