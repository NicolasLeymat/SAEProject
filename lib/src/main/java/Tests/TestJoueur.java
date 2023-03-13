package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Joueur;
import Object.Nationalite;

public class TestJoueur {

	// Enregistre un joueur dans l'application
		@Test
		public void testEnregistrerJoueur() throws Exception {
			Joueur j = new Joueur("Veslin", "Lucas", "Saren", "21/07/2003", Nationalite.FR);
			j.setIdEquipe(2);
			assertEquals(Joueur.enregistrerJoueur(j),1);
			assertEquals(Joueur.supprimerJoueur(j),1);
		}
			
		// Essaie d'enregistre un joueur deja present dans l'application
		@Test
		public void testEnregistrerJoueurDejaExistant() throws Exception {
			Joueur j = new Joueur("Desjardin", "Simon", "TommyGun", "05/06/2000", Nationalite.FR);
			j.setIdEquipe(3);
			j.setId(100);
			assertEquals(Joueur.enregistrerJoueur(j),-1);
		}
			
		// Modifie un joueur dans l'application
		@Test
		public void testModifierJoueur() throws Exception {
			Joueur j = new Joueur("Veslin", "Baptiste", "JB", "21/07/1961", Nationalite.FR);
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
	//Recupere tous les joueurs d'une equipe a partir de son id
	@Test
	public void testGetJoueursFromEquipe() {
		List<Joueur> liste = Joueur.getJoueursFromEquipe(2);
		assertEquals("Bibliokiller", liste.get(0).getPseudo());
		assertEquals("Explosssive", liste.get(1).getPseudo());
		assertEquals("LateNever", liste.get(2).getPseudo());
		assertEquals("PewDiePie", liste.get(3).getPseudo());
	}
	
	//Recupere le nom d'un joueur a partir de son id
	@Test
	public void testGetNomJoueurFromId() {
		assertEquals("Bjorne", Joueur.getNomJoueurFromId(11));
	}
	
}
