package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Ecurie;
import Object.Equipe;

public class TestEcurie {

	// Enregistre une ecurie dans l'application
		@Test
		public void testEnregistrerEcurie() throws Exception {
			Ecurie e = new Ecurie("Fiouze Clan");
			assertEquals(Ecurie.enregistrerEcurie(e),1);
			Ecurie.supprimerEcurie(e);
		}
			
		// Essaie d'enregistre une ecurie deja existante dans l'application
		@Test
		public void testEnregistrerEcurieDejaExistante() throws Exception {
			Ecurie e = new Ecurie("FaZe Clan");
			e.setId(100);
			assertEquals(Ecurie.enregistrerEcurie(e),-1);
		}
		
		// Enregistre une ecurie ainsi que ses equipes dans l'application
		@Test
		public void testEnregistrerEcurieEtEquipes() {
			Ecurie e = new Ecurie("Sauce");
			e.setId(100);
			Equipe eq = new Equipe("Toast");
			e.addEquipe(eq);
			assertEquals(Ecurie.enregistrerEcurie(e),1);
		}
		
		//Recupere l'ecurie a partir de son nom
		@Test
		public void testGetEcurieFromNom() throws Exception {
			Ecurie e = Ecurie.getEcurieFromNom("FaZe Clan");
			assertEquals(e.getId(), 1);
		}
		
		//Recupere toutes les equipes dont le nom commence par la parametre
		@Test
		public void testGetEcuriesFromNomAll() throws Exception {
			List<Ecurie> liste = Ecurie.getEcurieFromNomAll("F");
			assertEquals(liste.get(0).getNom(), "FaZe Clan");
			assertEquals(liste.get(1).getNom(), "Fire Starters");
			assertEquals(liste.get(2).getNom(), "Fnatic");
		}
		
		@Test
		public void testGetAllEcuries() throws Exception {
			List<Ecurie> liste = Ecurie.getAllEcuries();
			assertEquals(liste.get(0).getNom(), "Cloud9");
			assertEquals(liste.get(1).getNom(), "Evil Geniuses");
			assertEquals(liste.get(2).getNom(), "FaZe Clan");
			assertEquals(liste.get(3).getNom(), "Fire Starters");
			assertEquals(liste.get(4).getNom(), "Fnatic");
			assertEquals(liste.get(5).getNom(), "G2 Esports");
			assertEquals(liste.get(6).getNom(), "Natus Vincere");
			assertEquals(liste.get(7).getNom(), "NRG");
			assertEquals(liste.get(8).getNom(), "OG");
			assertEquals(liste.get(9).getNom(), "OpTic Gaming");
			assertEquals(liste.get(10).getNom(), "SK Korea");
			assertEquals(liste.get(11).getNom(), "Storm");
			assertEquals(liste.get(12).getNom(), "Team Liquid");
			assertEquals(liste.get(13).getNom(), "Team Spirit");
			assertEquals(liste.get(14).getNom(), "Vitality");
			assertEquals(liste.get(15).getNom(), "100 Thieves");
		}
	
}
