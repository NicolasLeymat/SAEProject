package Object;

import java.util.HashMap;

public class Jeu {

	private String nomJeu;
	private HashMap<String, Integer> modeDeJeu;
	
	public Jeu(String nomJeu) {
		this.modeDeJeu = new HashMap<String,Integer>();
		this.nomJeu = nomJeu;
	}
	
	public String getNomJeu() {
		return this.nomJeu;
	}

	
	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}
	
	public void addModeDeJeu(String mode, int nbJoueurs) {
		this.modeDeJeu.put(mode, nbJoueurs);
	}
	
	
	
}
