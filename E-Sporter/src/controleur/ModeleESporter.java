package controleur;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Application.Connexion;
import Object.Ecurie;
import Object.Equipe;

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
		allEcurie = Ecurie.getAllEcuries(connx);
		allEquipe = Equipe.getAllEquipes(connx);
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
		return Equipe.getEquipeFromNomAll(connx, prompt);
	}
	
	public List<Ecurie> getRechercheEcurie(String prompt){
		return Ecurie.getEcurieFromNomAll(connx, prompt);
	}
	
	public static List<Equipe> getAllEquipe(){
		return Equipe.getAllEquipes(connx);
	}
	
	public static List<Ecurie> getAllEcurie(){
		return Ecurie.getAllEcuries(connx);
	}

	public void setLastRecherche(List<Ecurie> lec, List<Equipe> leq) {
		resultatRechercheEcuries = lec;
		resultatRechercheEquipes=  leq;	
	}
}
