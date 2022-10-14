package Object;

import java.util.HashMap;

public class Jeu {
	
	private int nbParticipantsParEquipe;
	private String nomJeu;
	private HashMap<String, Integer> modeDeJeu;
	
	public Jeu(String nomJeu, int nbParticipantsParEquipe) {
		this.modeDeJeu = new HashMap<String,Integer>();
		this.nomJeu = nomJeu;
	}
	
	public String getNomJeu() {
		return this.nomJeu;
	}
	
	public int getNbParticipantsParEquipe() {
		return this.nbParticipantsParEquipe;
	} 
	
	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}
	
	public void addModeDeJeu(String mode, int nbJoueurs) {
		this.modeDeJeu.put(mode, nbJoueurs);
	}
	
	
	
}
