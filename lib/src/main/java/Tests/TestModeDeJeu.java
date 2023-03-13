package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Object.ModeDeJeu;

public class TestModeDeJeu {

	@Test
	public void testGetModeDeJeuFromNom() {
		ModeDeJeu m = ModeDeJeu.getModeDeJeuFromNom("1v1");
		assertEquals(m.getIdMode(), 2);
	}
	
}
