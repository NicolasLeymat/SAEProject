package Tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Application.Connexion;
import Object.Ecurie;
import Object.Equipe;

public class TestEcurie {

	@Before
	public void setUp() throws SQLException {
		Connexion.connexion().setAutoCommit(false);
	}
	
	// Enregistre une ecurie dans l'application
	@Test
	public void testEnregistrerEcurie() throws Exception {
		Ecurie e = new Ecurie("Fiouze Clan");
		assertEquals(1,Ecurie.enregistrerEcurie(e));
		Ecurie.supprimerEcurie(e);
	}
			
	// Essaie d'enregistre une ecurie deja existante dans l'application
	@Test
	public void testEnregistrerEcurieDejaExistante() throws Exception {
		Ecurie e = new Ecurie("FaZe Clan");
		e.setId(100);
		assertEquals(-1,Ecurie.enregistrerEcurie(e));
	}
		
	// Enregistre une ecurie ainsi que ses equipes dans l'application
	@Test
	public void testEnregistrerEcurieEtEquipes() {
		Ecurie e = new Ecurie("Sauce");
		e.setId(100);
		Equipe eq = new Equipe("Toast");
		e.addEquipe(eq);
		assertEquals(1,Ecurie.enregistrerEcurie(e));
		assertEquals(1,Ecurie.supprimerEcurie(e));
	}
		
	// Modifie une ecurie dans l'application
	@Test
	public void testModifierEcurie() {
		Ecurie e = new Ecurie("Sauce");
		Ecurie.enregistrerEcurie(e);
		e.setNom("Salsa");
		assertEquals(1,Ecurie.modifierEcurie(e));
		Ecurie.supprimerEcurie(e);
	}
	
	// Essaie de modifier une ecurie qui n'existe pas dans l'application
	@Test
	public void testModifierEcurieNonExistante() {
		Ecurie e = new Ecurie("Sauce");
		e.setNom("Salsa");
		assertEquals(-1, Ecurie.modifierEcurie(e));
	}
	
	// Supprime une ecurie dans l'application
	@Test
	public void testSupprimerEcurie() {
		Ecurie e = new Ecurie("Sauce");
		Ecurie.enregistrerEcurie(e);
		assertEquals(1,Ecurie.supprimerEcurie(e));
	}
		
	// Essaie de supprimer une ecurie qui n'existe pas dans l'application
	@Test
	public void testSupprimerEcurieNonExistante() {
		Ecurie e = new Ecurie("Sauce");
		assertEquals(-1,Ecurie.supprimerEcurie(e));
	}
		
	//Recupere l'ecurie a partir de son nom
	@Test
	public void testGetEcurieFromNom() throws Exception {
		Ecurie e = Ecurie.getEcurieFromNom("FaZe Clan");
		assertEquals(1,e.getId());
	}
		
	//Recupere toutes les equipes dont le nom commence par la parametre
	@Test
	public void testGetEcuriesFromNomAll() throws Exception {
		List<Ecurie> liste = Ecurie.getEcurieFromNomAll("F");
		assertEquals("FaZe Clan", liste.get(0).getNom());
		assertEquals("Fire Starters", liste.get(1).getNom());
		assertEquals("Fnatic", liste.get(2).getNom());
	}
		
	//Recupere une ecurie a partir de son id
	@Test
	public void testGetEcurieFromId() {
		assertEquals("Fnatic", Ecurie.getEcurieFromId(7).getNom());
	}
		
	//Essaie de recuperer une ecurie qui n'existe pas a partir de son id
	@Test
	public void testGetEcurieFromIdNonExistant() {
		assertEquals(null, Ecurie.getEcurieFromId(1000));
	}
		
	//Recupere une ecurie a partir de son id
	@Test
	public void testGetNomEcurieFromId() {
		assertEquals("Storm", Ecurie.getNomEcurieFromId(15));
	}
				
	//Essaie de recuperer une ecurie qui n'existe pas a partir de son id
	@Test
	public void testGetNomEcurieFromIdNonExistant() {
		assertEquals(null, Ecurie.getNomEcurieFromId(1000));
	}
		
		
	 @Test 
	 public void testGetAllEcuries() throws Exception { 
		 List<Ecurie> liste = Ecurie.getAllEcuries(); 
	 	 assertEquals("Cloud9", liste.get(0).getNom());
		 assertEquals("Evil Geniuses", liste.get(1).getNom());
		 assertEquals("FaZe Clan", liste.get(2).getNom());
		 assertEquals("Fire Starters", liste.get(3).getNom());
		 assertEquals("Fnatic", liste.get(4).getNom());
		 assertEquals("G2 Esports", liste.get(5).getNom());
		 assertEquals("Natus Vincere", liste.get(6).getNom());
		 assertEquals("NRG", liste.get(7).getNom());
		 assertEquals("OG", liste.get(8).getNom());
		 assertEquals("OpTic Gaming", liste.get(9).getNom());
		 assertEquals("Rogue", liste.get(10).getNom());
		 assertEquals("SK Korea", liste.get(11).getNom());
		 assertEquals("Storm", liste.get(12).getNom());
		 assertEquals("Team Liquid", liste.get(13).getNom());
		 assertEquals("Team Spirit", liste.get(14).getNom());
		 assertEquals("Test", liste.get(15).getNom());
		 assertEquals("Vitality", liste.get(16).getNom());
		 assertEquals("100 Thieves", liste.get(17).getNom()); 
	 }
		 
	
}
