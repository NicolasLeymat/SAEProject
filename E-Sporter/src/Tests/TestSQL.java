package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.*;

public class TestSQL {

	/////////////////////////////////////////////////TEST EQUIPE//////////////////////////////////////////////////////////
	
	// Enregistre une equipe dans l'application
	@Test
	public void testEnregistrerEquipe() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setPoints(0);
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
		e.setPoints(0);
		e.setIdModeDeJeu(0);
		assertEquals(Equipe.enregistrerEquipe(e),-1);
	}
	
	// Modifie une equipe dans l'application
	@Test
	public void testModifierEquipe() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setPoints(0);
		e.setIdModeDeJeu(0);
		Equipe.enregistrerEquipe(e);
		e.setNom("Foune CSGO");
		e.setPoints(12);
		assertEquals(Equipe.modifierEquipe(e),1);
		Equipe.supprimerEquipe(e);
	}
	
	// Essaie de modifier une equipe qui n'existe pas dans l'application
	@Test
	public void testModifierEquipeNonExistante() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setPoints(0);
		e.setIdModeDeJeu(0);
		assertEquals(Equipe.modifierEquipe(e),-1);
	}
	// Supprime une equipe de l'application
	@Test
	public void testSupprimerEquipe() throws Exception {
		Equipe e = new Equipe("Faze CSGO");
		e.setId(100);
		e.setIdEcurie(1);
		e.setPoints(0);
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
		e.setPoints(0);
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
	
	/////////////////////////////////////////////////TEST ECURIE//////////////////////////////////////////////////////////

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
	
/////////////////////////////////////////////////TEST JOUEUR//////////////////////////////////////////////////////////
	
	// Enregistre un joueur dans l'application
	@Test
	public void testEnregistrerJoueur() throws Exception {
		Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
		j.setIdEquipe(2);
		j.setId(100);
		assertEquals(Joueur.enregistrerJoueur(j),1);
		Joueur.supprimerJoueur(j);
	}
		
	// Essaie d'enregistre un joueur deja present dans l'application
	@Test
	public void testEnregistrerJoueurDejaExistant() throws Exception {
		Joueur j = new Joueur("Desjardins", "Simon", "TommyGun", "05/06/2000", Nationalite.FR);
		j.setIdEquipe(3);
		j.setId(100);
		assertEquals(Joueur.enregistrerJoueur(j),-1);
	}
		
	// Modifie un joueur dans l'application
	@Test
	public void testModifierJoueur() throws Exception {
		Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
		j.setIdEquipe(4);
		j.setId(100);
		Joueur.enregistrerJoueur(j);
		j.setNom("Leymat");
		assertEquals(Joueur.modifierJoueur(j),1);
		assertEquals(Joueur.supprimerJoueur(j),1);
	}
		
	// Essaie de modifier un joueur qui n'existe pas dans l'application
	@Test
	public void testModifierJoueurNonExistant() throws Exception {
		Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
		j.setId(100);
		assertEquals(Joueur.modifierJoueur(j),-1);
	}
		
	// Supprime un joueur de l'application
	@Test
	public void testSupprimerJoueur() throws Exception {
		Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
		j.setIdEquipe(2);
		j.setId(100);
		Joueur.enregistrerJoueur( j);
		assertEquals(Joueur.supprimerJoueur(j),1);
	}
		
	// Essaie de supprimer un joueur n'existant pas dans l'application
	@Test
	public void testSupprimerJoueurNonExistant() throws Exception {
		Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
		j.setId(100);
		assertEquals(Joueur.supprimerJoueur(j),-1);
	}
		
	// Recupere tout les joueurs associees a une equipe (flemme de faire le test)
	/*
	 * @Test public void testGetJoueursFromEquipe() throws Exception { List<Joueur>
	 * liste = Joueur.getJoueursFromEquipe(0);
	 * assertEquals(liste.get(0).getPseudo(), "TommyGun");
	 * assertEquals(liste.get(1).getPseudo(), "SmokePlumes");
	 * assertEquals(liste.get(2).getPseudo(), "Alkanoid");
	 * assertEquals(liste.get(1).getPseudo(), "BigDip");
	 * assertEquals(liste.get(2).getPseudo(), "Mortician"); }
	 */
	
}