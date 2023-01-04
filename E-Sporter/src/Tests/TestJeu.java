package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Jeu;

public class TestJeu {
	
	@Test
	public void testGetJeuFromId() {
		Jeu j = Jeu.getJeuFromId(0);
		assertEquals(j.getNom(), "Fortnite");
		assertEquals(j.getModesDeJeu().get(3).getNom(), "1v1");
		assertEquals(j.getModesDeJeu().get(4).getNom(), "2v2");
		assertEquals(j.getModesDeJeu().get(5).getNom(), "3v3");
		assertEquals(j.getModesDeJeu().get(6).getNom(), "4v4");
		assertEquals(j.getModesDeJeu().get(7).getNom(), "5v5");
		assertEquals(j.getModesDeJeu().get(8).getNom(), "6v6");
	}
	
	@Test
	public void testGetJeuFromIdNonExistant() {
		Jeu j = Jeu.getJeuFromId(100);
		assertEquals(j, null);
	}
	
	@Test
	public void testGetAlljeux() {
		List<Jeu> jeux = Jeu.getAllJeux();
		assertEquals(jeux.get(0).getNom(),"Apex Legends");
		assertEquals(jeux.get(1).getNom(),"COD:Warzone");
		assertEquals(jeux.get(2).getNom(),"CS:GO");
		assertEquals(jeux.get(3).getNom(),"Dota 2");
		assertEquals(jeux.get(4).getNom(),"Fortnite");
		assertEquals(jeux.get(5).getNom(),"League of Legends");
		assertEquals(jeux.get(6).getNom(),"Overwatch 2");
		assertEquals(jeux.get(7).getNom(),"PUBG");
		assertEquals(jeux.get(8).getNom(),"Rocket League");
		assertEquals(jeux.get(9).getNom(),"Team Fortress 2");
		assertEquals(jeux.get(10).getNom(),"Valorant");
	}
	
}
