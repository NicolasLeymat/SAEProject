package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import object.ModeDeJeu;

public class TestModeDeJeu {

	@Test
	public void testGetModeDeJeuFromNom() {
		ModeDeJeu m = ModeDeJeu.getModeDeJeuFromNom("1v1");
		assertEquals(m.getIdMode(), 2);
	}
	
}
