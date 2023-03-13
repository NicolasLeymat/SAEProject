package Tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Application.Connexion;
import Object.Equipe;
import Object.Joueur;
import Object.Nationalite;


public class TestEquipe {

	@Before
	public void setUp() throws SQLException {
		Connexion.connexion().setAutoCommit(false);
	}
	
	// Enregistre une equipe dans l'application
	@Test
	public void testEnregistrerEquipe() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setIdModeDeJeu(0);	
		assertEquals(1, Equipe.enregistrerEquipe(e));
		Equipe.supprimerEquipe(e);
	}
		
	// Essaie d'enregistre une equipe deja existante dans l'application
	@Test
	public void testEnregistrerEquipeDejaExistante() throws Exception {
		Equipe e = new Equipe("Vitality Fortnite");
		e.setId(100);
		e.setIdEcurie(0);
		e.setIdModeDeJeu(0);
		assertEquals(-1,Equipe.enregistrerEquipe(e));
	}
	
	// Enregistre une equipe et ses joueurs dans l'application
	public void testEnreistrerEquipeEtJoueurs() throws Exception {
		Equipe e = new Equipe("Test");
		e.setId(100);
		e.setIdEcurie(1);
		e.setIdModeDeJeu(0);
		Joueur j = new Joueur("Lucas","Veslin","Saren","21/07/2003",Nationalite.FR);
		e.addJoueur(j);
		assertEquals(1, Equipe.enregistrerEquipe(e));
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
		assertEquals(1,Equipe.modifierEquipe(e));
		Equipe.supprimerEquipe(e);
	}
		
	// Essaie de modifier une equipe qui n'existe pas dans l'application
	@Test
	public void testModifierEquipeNonExistante() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setIdModeDeJeu(0);
		assertEquals(-1, Equipe.modifierEquipe(e));
	}
		
	// Supprime une equipe de l'application
	@Test
	public void testSupprimerEquipe() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setIdModeDeJeu(0);
		Equipe.enregistrerEquipe(e);
		assertEquals(1, Equipe.supprimerEquipe(e));
	}
		
	// Essaie de supprimer une equipe n'existant pas dans l'application
	@Test
	public void testSupprimerEquipeNonExistante() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setIdModeDeJeu(0);
		assertEquals(-1, Equipe.supprimerEquipe(e));
	}
	
	// Supprime une equipe et ses joueurs de l'application
		@Test
		public void testSupprimerEquipeEtJoueurs() throws Exception {
			Equipe e = new Equipe("Faze CSGO");
			e.setId(100);
			e.setIdEcurie(1);
			e.setIdModeDeJeu(0);
			e.addJoueur(new Joueur("Lucas","Veslin","Saren","21/07/2003",Nationalite.FR));
			Equipe.enregistrerEquipe(e);
			assertEquals(1, Equipe.supprimerEquipe(e));
		}
		
	// Recupere toutes les equipes de l'application
	@Test public void testGetAllEquipes() throws Exception { 
		 List<Equipe> liste = Equipe.getAllEquipes(); 
		 assertEquals("Cloud9 Fortnite", liste.get(0).getNom()); 
		 assertEquals("Evil Geniuses Fortnite II", liste.get(1).getNom()); 
		 assertEquals("Faze Fortnite", liste.get(2).getNom()); 
		 assertEquals("Fire ST Fortnite", liste.get(3).getNom());
		 assertEquals("Fnatic Fortnite", liste.get(4).getNom());
		 assertEquals("G2 Fortnite", liste.get(5).getNom());
		 assertEquals("Liquid Fortnite", liste.get(6).getNom());
		 assertEquals("Natus Vincere Fortnite", liste.get(7).getNom());
		 assertEquals("NRG Fortnite", liste.get(8).getNom());
		 assertEquals("OG Fortnite", liste.get(9).getNom());
		 assertEquals("OpTic Fortnite", liste.get(10).getNom());
		 assertEquals("SK Fortnite", liste.get(11).getNom());
		 assertEquals("Spirit Fortnite", liste.get(12).getNom());
		 assertEquals("Storm Fortnite", liste.get(13).getNom());
		 assertEquals("TestVideo Fortnite II", liste.get(14).getNom());
		 assertEquals("Vitality Fortnite", liste.get(15).getNom());
		 assertEquals("100 Thieves Fortnite", liste.get(16).getNom()); 
	}
		 
	//Recupere toutes les equipes dont le nom commence par la parametre
	@Test
	public void testGetEquipesFromNomAll() throws Exception {
		List<Equipe> liste = Equipe.getEquipeFromNomAll("F");
		assertEquals("Faze Fortnite", liste.get(0).getNom());
		assertEquals("Fire ST Fortnite", liste.get(1).getNom());
		assertEquals("Fnatic Fortnite", liste.get(2).getNom());
	}
		
	//Recupere l'equipe a partir de son nom
	@Test
	public void testGetEquipeFromNom() throws Exception {
		Equipe e = Equipe.getEquipeFromNom("Cloud9 Fortnite");
		assertEquals(3, e.getId());
	}
		
	// Recupere toutes les equipes associees a une ecurie
	@Test
	public void testGetEquipesFromEcurie() throws Exception {
		List<Equipe> liste = Equipe.getEquipesFromEcurie(0);
		assertEquals("Vitality Fortnite", liste.get(0).getNom());
	}
	
	//Recupere le nom d'une equipe a partir de son id
	@Test
	public void testGetNomEquipeFromId() {
		assertEquals("Cloud9 Fortnite", Equipe.getNomEquipeFromId(3));
	}
	
	//Recupere une equipe a partir de son id
	@Test
	public void testGetEquipeFromId() {
		assertEquals("Cloud9 Fortnite", Equipe.getEquipeFromId(3).getNom());
	}
	
}
