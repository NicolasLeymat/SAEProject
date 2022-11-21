package Tests;

import java.util.List;

import Application.Connexion;
import Object.*;

public class TestSQL {

	public static void main(String[] args) throws Exception {
		List<Equipe> liste = Equipe.getAllEquipes(Connexion.connexion());
		for (Equipe e : liste) {
			System.out.println(e.toString());
		}
		
		List<Equipe> liste2 = Equipe.getEquipesFromEcurie(Connexion.connexion(), "test");
		for (Equipe e : liste2) {
			System.out.println(e.toString());
		}
		
		//Equipe.enregistrerEquipe(Connexion.connexion(), new Equipe("Vitality A", 0, 0, 1));
		
		Ecurie e = Ecurie.getEcurieFromNom(Connexion.connexion(), "Vitality");
		System.out.println(e);
		
		 //Ecurie.enregistrerEcurie(Connexion.connexion(), new Ecurie("Astralis"));
		
		int id = Jeu.getId(Connexion.connexion(), new Jeu("Valorant"));
		System.out.println(id);
		Ecurie e1 = Ecurie.getEcurieFromNom(Connexion.connexion(), "Astralis");
	}
	

}
