package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Equipe;

public class TestEquipe {

	// Enregistre une equipe dans l'application
		@Test
		public void testEnregistrerEquipe() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			
			assertEquals(Equipe.enregistrerEquipe(e),1);
			Equipe.supprimerEquipe(e);
		}
		
		// Essaie d'enregistre une equipe deja existante dans l'application
		@Test
		public void testEnregistrerEquipeDejaExistante() throws Exception {
			Equipe e = new Equipe("Vitality Fortnite");
			e.setId(100);
			e.setIdEcurie(0);
			e.setIdModeDeJeu(0);
			assertEquals(Equipe.enregistrerEquipe(e),-1);
		}
		
		// Modifie une equipe dans l'application
		@Test
		public void testModifierEquipe() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			Equipe.enregistrerEquipe(e);
			e.setNom("Foune CSGO");
			e.addPoints(12);
			assertEquals(Equipe.modifierEquipe(e),1);
			Equipe.supprimerEquipe(e);
		}
		
		// Essaie de modifier une equipe qui n'existe pas dans l'application
		@Test
		public void testModifierEquipeNonExistante() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			assertEquals(Equipe.modifierEquipe(e),-1);
		}
		// Supprime une equipe de l'application
		@Test
		public void testSupprimerEquipe() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			Equipe.enregistrerEquipe(e);
			assertEquals(Equipe.supprimerEquipe(e),1);
		}
		
		// Essaie de supprimer une equipe n'existant pas dans l'application
		@Test
		public void testSupprimerEquipeNonExistante() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			assertEquals(Equipe.supprimerEquipe(e),-1);
		}
		
		// Recupere toutes les equipes de l'application
		@Test
		public void testGetAllEquipes() throws Exception {
			List<Equipe> liste = Equipe.getAllEquipes();
			assertEquals(liste.get(0).getNom(), "Cloud9 Fortnite");
			assertEquals(liste.get(1).getNom(), "Evil Geniuses Fortnite");
			assertEquals(liste.get(2).getNom(), "Faze Fortnite");
			assertEquals(liste.get(3).getNom(), "Fire ST Fortnite");
			assertEquals(liste.get(4).getNom(), "Fnatic Fortnite");
			assertEquals(liste.get(5).getNom(), "G2 Fortnite");
			assertEquals(liste.get(6).getNom(), "Liquid Fortnite");
			assertEquals(liste.get(7).getNom(), "Natus Vincere Fortnite");
			assertEquals(liste.get(8).getNom(), "NRG Fortnite");
			assertEquals(liste.get(9).getNom(), "OG Fortnite");
			assertEquals(liste.get(10).getNom(), "OpTic Fortnite");
			assertEquals(liste.get(11).getNom(), "SK Fortnite");
			assertEquals(liste.get(12).getNom(), "Spirit Fortnite");
			assertEquals(liste.get(13).getNom(), "Storm Fortnite");
			assertEquals(liste.get(14).getNom(), "Vitality Fortnite");
			assertEquals(liste.get(15).getNom(), "100 Thieves Fortnite");
		}

		//Recupere toutes les equipes dont le nom commence par la parametre
		@Test
		public void testGetEquipesFromNomAll() throws Exception {
			List<Equipe> liste = Equipe.getEquipeFromNomAll("F");
			assertEquals(liste.get(0).getNom(), "Faze Fortnite");
			assertEquals(liste.get(1).getNom(), "Fire ST Fortnite");
			assertEquals(liste.get(2).getNom(), "Fnatic Fortnite");
		}
		
		//Recupere l'equipe a partir de son nom
		@Test
		public void testGetEquipeFromNom() throws Exception {
			Equipe e = Equipe.getEquipeFromNom("Cloud9 Fortnite");
			assertEquals(e.getId(), 3);
		}
		
		// Recupere toutes les equipes associees a une ecurie
		@Test
		public void testGetEquipesFromEcurie() throws Exception {
			List<Equipe> liste = Equipe.getEquipesFromEcurie(0);
			assertEquals(liste.get(0).getNom(), "Vitality Fortnite");

		}
	
}
