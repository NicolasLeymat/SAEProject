package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Organisateur;

public class TestOrganisateur {

	@Test
	public void testGetOrganisateurFromId() {
		Organisateur o = Organisateur.getOrganisateurFromId(2);
		assertEquals(o.getNom(), "Rick");
	}
	
	@Test
	public void testGetOrganisateurFromIdNonExistante() {
		Organisateur o = Organisateur.getOrganisateurFromId(12);
		assertEquals(o, null);
	}
	
	@Test
	public void testGetAllOrganisateurs() {
		List<Organisateur> orgs = Organisateur.getAllOrganisateurs();
		assertEquals(orgs.get(0).getNom(), "Debora");
		assertEquals(orgs.get(1).getNom(), "Rick");
		assertEquals(orgs.get(2).getNom(), "Yevlogiy");
	}
	
}
