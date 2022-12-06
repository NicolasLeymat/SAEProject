package controleur;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Application.Connexion;
import Object.Ecurie;
import Object.Equipe;
import Object.Jeu;

public class ModeleESporter {

	public static List<Equipe> resultatRechercheEquipes;
	public static List<Ecurie> resultatRechercheEcuries;
	public static List<Equipe> allEquipe;
	public static List<Ecurie> allEcurie;
	private static Connection connx;
	
	public ModeleESporter() {
		resultatRechercheEcuries = new LinkedList<>();
		resultatRechercheEquipes = new LinkedList<>();
		connx = Connexion.connexion();
	}
	
	public static void getAll() {
		allEcurie = Ecurie.getAllEcuries();
		allEquipe = Equipe.getAllEquipes();
		try {
			connx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Object> recherche(String prompt){
		for(Equipe e : allEquipe) {
			
		}
		return null;
	}
	
	public List<Equipe> getRecherche(String prompt){
		return Equipe.getEquipeFromNomAll(prompt);
	}
	
	public List<Ecurie> getRechercheEcurie(String prompt){
		return Ecurie.getEcurieFromNomAll(prompt);
	}
	
	public static List<Equipe> getAllEquipe(){
		return Equipe.getAllEquipes();
	}
	
	public static List<Ecurie> getAllEcurie(){
		return Ecurie.getAllEcuries();
	}

	public void setLastRecherche(List<Ecurie> lec, List<Equipe> leq) {
		resultatRechercheEcuries = lec;
		resultatRechercheEquipes=  leq;	
	}
	
	public void modifierEquipe(Equipe eq) {
		Equipe.modifierEquipe(eq);
	}
	
	public boolean estNomEquipeDispo(String nom) {
		List<Equipe> l = getAllEquipe();
		List<String> l2 = new LinkedList<>();
		int nbOccurence = 0;
		for(Equipe e : l) {
			l2.add(e.getNom());
		}
		
		for(String s : l2) {
			if(s.equals(nom)) {
				nbOccurence += 1;
			}
		}
		if(nbOccurence == 0) {
			return true;
		}else {			
			return false;
		}
	}

	public boolean estNomeEcurieDispo(String nom) {
		List<Ecurie> l = getAllEcurie();
		List<String> l2 = new LinkedList<>();
		int nbOccurence = 0;
		for(Ecurie e : l) {
			l2.add(e.getNom());
		}
		
		for(String s : l2) {
			if(s.equals(nom)) {
				nbOccurence += 1;
			}
		}
		if(nbOccurence == 0) {
			return true;
		}else {			
			return false;
		}
	}
	
	public void modifierEcurie(Ecurie ec) {
		Ecurie.modifierEcurie(ec);
		
	}
}
