package Object;

public class Jeu {
	
	private int nbParticipantsParEquipe;
	private String nomJeu;
	
	public Jeu(String nomJeu, int nbParticipantsParEquipe) {
		this.nbParticipantsParEquipe = nbParticipantsParEquipe;
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
	
	
	
}
