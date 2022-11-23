package controleur;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import Application.Connexion;
import Object.Ecurie;
import Object.Equipe;

public class ModeleESporter {

	public static List<Equipe> resultatRechercheEquipes;
	public static List<Ecurie> resultatRechercheEcuries;
	private Connection connx;
	
	public ModeleESporter() {
		this.resultatRechercheEcuries = new LinkedList<>();
		this.resultatRechercheEquipes = new LinkedList<>();
		connx = Connexion.connexion();
	}
	
	public List<Equipe> getRecherche(String prompt){
		return Equipe.getEquipeFromNomAll(connx, prompt);
	}
	
	public List<Ecurie> getRechercheEcurie(String prompt){
		return Ecurie.getEcurieFromNomAll(connx, prompt);
	}
	
	public void setLastRecherche(List<Ecurie> lec, List<Equipe> leq) {
		this.resultatRechercheEcuries = lec;
		this.resultatRechercheEquipes=  leq;	
	}
}
