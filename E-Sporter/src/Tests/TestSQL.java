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
		
		List<Equipe> liste2 = Equipe.getEquipesFromEcurie(Connexion.connexion(), 5);
		for (Equipe e : liste2) {
			System.out.println(e.toString());
		}
		
		//Equipe.enregistrerEquipe(Connexion.connexion(), new Equipe("Vitality A", 0, 0, 1));
		
		Ecurie e = Ecurie.getEcurieFromId(Connexion.connexion(), 1);
		System.out.println(e);
		
		 //Ecurie.enregistrerEcurie(Connexion.connexion(), new Ecurie("Astralis"));
		
<<<<<<< Updated upstream
		int id = Jeu.getId(Connexion.connexion(), new Jeu("Valorant"));
		System.out.println(id);
=======
		Ecurie e1 = Ecurie.getEcurieFromId(Connexion.connexion(), 4);
		Ecurie.modifierEcurie(Connexion.connexion(), e1, "T3");
>>>>>>> Stashed changes
	}
	

}
