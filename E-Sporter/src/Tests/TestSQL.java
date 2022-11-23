package Tests;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;

import Application.Connexion;
import Object.*;

public class TestSQL {

	// Enregistre une equipe dans l'application
	@Test
	public void testEnregistrerEquipe() throws Exception {
		Equipe e = new Equipe("Faz CSGO", 0, "Faze Clan", 6);
		assertEquals(Equipe.enregistrerEquipe(Connexion.connexion(), e),1);
		Equipe.supprimerEquipe(Connexion.connexion(), e);
	}
	
	// Essaie d'enregistre une equipe deja existante dans l'application
	@Test
	public void testEnregistrerEquipeDejaExistante() throws Exception {
		Equipe e = new Equipe("Faze CSGO", 0, "Faze Clan", 6);
		assertEquals(Equipe.enregistrerEquipe(Connexion.connexion(), e),-1);
	}
	
	// Modifie une equipe dans l'application
	@Test
	public void testModifierEquipe() throws Exception {
		Equipe e = new Equipe("Faz CSGO", 0, "Faze Clan", 6);
		Equipe.enregistrerEquipe(Connexion.connexion(), e);
		assertEquals(Equipe.modifierEquipe(Connexion.connexion(), e, "Faz CSGO", 5, 12, "Faze Clan", 6),1);
	}
	
	// Essaie de modifier une equipe qui n'existe pas dans l'application
	@Test
	public void testModifierEquipeNonExistante() throws Exception {
		Equipe e = new Equipe("Foune CSGO", 0, "Faze Clan", 6);
		assertEquals(Equipe.modifierEquipe(Connexion.connexion(), e, "Faz CSGO", 5, 12, "Faze Clan", 6),-1);
	}
	
	// Supprime une equipe de l'application
	@Test
	public void testSupprimerEquipe() throws Exception {
		Equipe e = new Equipe("Faz CSGO", 0, "Faze Clan", 6);
		Equipe.enregistrerEquipe(Connexion.connexion(), e);
		assertEquals(Equipe.supprimerEquipe(Connexion.connexion(), e),1);
	}
	
	// Essaie de supprimer une equipe n'existant pas dans l'application
	@Test
	public void testSupprimerEquipeNonExistante() throws Exception {
		Equipe e = new Equipe("Foune CSGO", 0, "Faze Clan", 6);
		assertEquals(Equipe.supprimerEquipe(Connexion.connexion(), e),-1);
	}
	
	// Recupere toutes les equipes de l'application
	@Test
	public void testGetAllEquipes() throws Exception {
		List<Equipe> liste = Equipe.getAllEquipes(Connexion.connexion());
		assertEquals(liste.get(0).getNom(), "Cloud9 Fortnite");
		assertEquals(liste.get(1).getNom(), "Team Liquid Apex Legends");
		assertEquals(liste.get(2).getNom(), "SK Telecom League of Legends");
		assertEquals(liste.get(3).getNom(), "Fnatic Counter-Strike: Global Offensive");
		assertEquals(liste.get(4).getNom(), "Vitality Valorant");
		assertEquals(liste.get(5).getNom(), "Faze CSGO");
		assertEquals(liste.get(6).getNom(), "Atlanta Faze");
		assertEquals(liste.get(7).getNom(), "Faze Fortnite");
	}

	//Recupere toutes les equipes dont le nom commence par la parametre
	@Test
	public void testGetEquipesFromNomAll() throws Exception {
		List<Equipe> liste = Equipe.getEquipeFromNomAll(Connexion.connexion(),"Faze");
		assertEquals(liste.get(0).getNom(), "Faze CSGO");
		assertEquals(liste.get(1).getNom(), "Faze Fortnite");
	}
	
	//Recupere l'equipes a partir de son nom
		@Test
		public void testGetEquipesFromNom() throws Exception {
			Equipe e = Equipe.getEquipeFromNom(Connexion.connexion(),"Cloud9 Fortnite");
			assertEquals(e.getNom(), "Cloud9 Fortnite");
		}
	
	// Recupere toutes les equipes associees a une ecurie
	@Test
	public void testGetEquipesFromEcurie() throws Exception {
		List<Equipe> liste = Equipe.getEquipesFromEcurie(Connexion.connexion(),"Faze Clan");
		assertEquals(liste.get(0).getNom(), "Faze CSGO");
		assertEquals(liste.get(1).getNom(), "Atlanta Faze");
		assertEquals(liste.get(2).getNom(), "Faze Fortnite");
	}
	
	
	
}
