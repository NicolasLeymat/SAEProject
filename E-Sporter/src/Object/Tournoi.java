package Object;

import java.util.ArrayList;

public class Tournoi {

	private String nom;
	private String dateTournoi;
	private int notoriete;
	private Jeu jeu;
	private ArrayList<Equipe> listeEquipe;

	public Tournoi(String nom, String dateTournoi, int notoriete, Jeu jeu) throws Exception {
		
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

	public String getDateTournoi() {
		return dateTournoi;
	}

	public void setDateTournoi(String dateTournoi) {
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
		this.listeEquipe.add(equipe);
	}
	
	public Jeu getJeu() {
		return jeu;
	}
	
	public Equipe getEquipeTournoi(int i) {
		return this.listeEquipe.get(i);
	}
}
