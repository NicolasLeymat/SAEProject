package Object;

public class Tournoi {

	private String nom;
	private String dateTournoi;
	private int notoriete;
	private Jeu jeu;

	public Tournoi(String nom, String dateTournoi, int notoriete, Jeu jeu) throws Exception {
		
		if (notoriete > 3 || notoriete < 0) {
			throw new Exception();
		}
		
		this.nom = nom;
		this.dateTournoi = dateTournoi;
		//this.championnat = championnat;
		this.notoriete = notoriete;
		this.jeu = jeu;
	}

	public String getNom() {
		return nom;
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
	
}
