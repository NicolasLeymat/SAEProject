package Object;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tournoi {

	private String nom;
	private Date dateTournoi;
	private int notoriete;
	private Jeu jeu;
	private ArrayList<Equipe> listeEquipe;

	public Tournoi(String nom, Date dateTournoi, int notoriete, Jeu jeu) throws Exception {
		
		if (notoriete > 3 || notoriete < 0) {
			throw new Exception();
		}
		
		this.nom = nom;
		this.dateTournoi = dateTournoi;
		//this.championnat = championnat;
		this.notoriete = notoriete;
		this.jeu = jeu;
		this.listeEquipe = new ArrayList<Equipe>();
	}

	public String getNom() {
		return nom;
	}

	public Equipe getEquipe (int i) {
		return listeEquipe.get(i);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateTournoi() {
		return dateTournoi;
	}

	public void setDateTournoi(Date dateTournoi) {
		this.dateTournoi = dateTournoi;
	}

	public int getNotoriete() {
		return notoriete;
	}

	public void setNotoriete(int notoriete) {
		this.notoriete = notoriete;
	}
	
	public void addEquipe(Equipe equipe) throws Exception{
		if (this.listeEquipe.size()>=16) {
			throw new Exception("WTF");
		}
		if (this.dateValide()==true) {
			throw new Exception();
		}
		this.listeEquipe.add(equipe);
	}
	
	private boolean dateValide() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String temp = dtf.format(now);
		System.out.println(temp.toString());
		Date today = Date.valueOf(temp);
		boolean res = this.dateTournoi.before(today);
		return res;
		
	}

	public Jeu getJeu() {
		return jeu;
	}
	
	public Equipe getEquipeTournoi(int i) {
		return this.listeEquipe.get(i);
	}
}
