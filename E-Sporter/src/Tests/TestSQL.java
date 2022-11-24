package Tests;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Application.Connexion;
import Object.Ecurie;
import Object.Equipe;
public class TestSQL {
	
	List<Equipe> liste;
	
	@Before
	public void setUp() throws Exception {
		liste = Equipe.getAllEquipes(Connexion.connexion());
		for (Equipe e : liste) {
			System.out.println(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsererUneEquipe() throws  Exception{
		Connection connec = Connexion.connexion();
		Ecurie nom = new Ecurie("nom");
		Equipe equipe = new Equipe("test",10, "nom", 3);
		try {
			connec.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1, Ecurie.enregistrerEcurie(connec, nom));
		assertEquals(1, Equipe.enregistrerEquipe(connec,equipe));
	}
	
	
	/////////////////////////////////////////////////TEST ECURIE//////////////////////////////////////////////////////////
	
	// Enregistre une equipe dans l'application
	@Test
	public void testEnregistrerEquipe() throws Exception {
		assertEquals(liste.get(1).getNom(), "Faze Fortnite");
	}
	
	//Recupere l'equipe a partir de son nom
	@Test
	public void testGetEquipeFromNom() throws Exception {
		Equipe e = Equipe.getEquipeFromNom(Connexion.connexion(),"Cloud9 Fortnite");
		assertEquals(e.getNom(), "Cloud9 Fortnite");
	}
	
	// Recupere toutes les equipes associees a une ecurie
	@Test
	public void getAllEquipe() {
		assertEquals(liste.get(2).getNom(), "Faze Fortnite");
	}
	
	/////////////////////////////////////////////////TEST EQUIPE//////////////////////////////////////////////////////////
	// Enregistre une ecurie dans l'application
	@Test
	public void testEnregistrerEcurie() throws Exception {
		Ecurie e = new Ecurie("Fiouze Clan");
		assertEquals(Ecurie.enregistrerEcurie(Connexion.connexion(), e),1);
		Ecurie.supprimerEcurie(Connexion.connexion(), e);
	}
		
	// Essaie d'enregistre une ecurie deja existante dans l'application
	@Test
	public void testEnregistrerEcurieDejaExistante() throws Exception {
		Ecurie e = new Ecurie("Faze Clan");
		assertEquals(Ecurie.enregistrerEcurie(Connexion.connexion(), e),-1);
	}
	
	//Recupere l'ecurie a partir de son nom
	@Test
	public void testGetEcurieFromNom() throws Exception {
		Ecurie e = Ecurie.getEcurieFromNom(Connexion.connexion(),"Faze Clan");
		assertEquals(e.getNom(), "Faze Clan");
	}
	
	//Recupere toutes les equipes dont le nom commence par la parametre
	@Test
	public void testGetEcuriesFromNomAll() throws Exception {
		List<Ecurie> liste = Ecurie.getEcurieFromNomAll(Connexion.connexion(),"F");
		assertEquals(liste.get(0).getNom(), "Faze Clan");
		assertEquals(liste.get(1).getNom(), "Fnatic");
	}
	
}