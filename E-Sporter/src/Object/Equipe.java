package Object;

public class Equipe {
	
	private String nom;
	private int nbJoueurs;
	private int points;
	private Ecurie ecurie;
	private String jeu;

	//Il faudrait peut être changer le type de jeu
	public Equipe(String nom, int nbJoueurs, int points, Ecurie ecurie, String jeu) {
		this.nom = nom;
		this.nbJoueurs = nbJoueurs;
		this.points = points;
		this.ecurie = ecurie;
		this.jeu = jeu;
	}
	
	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
