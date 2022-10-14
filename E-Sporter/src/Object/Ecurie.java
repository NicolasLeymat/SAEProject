package Object;

import java.util.ArrayList;
import java.util.List;

public class Ecurie {

	private String nom;
	private List<Equipe> listeEquipes;
	
	public Ecurie(String nom) {
		this.nom = nom;
		this.listeEquipes = new ArrayList<Equipe>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void addEquipe(Equipe equipe) {
		this.listeEquipes.add(equipe);
	}
	
}
