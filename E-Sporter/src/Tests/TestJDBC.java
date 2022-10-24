package Tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Application.Connexion;
import Object.*;

public class TestJDBC {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsererUneEquipe() throws  Exception{
		Connection connec = Connexion.connexion();
		Ecurie nom = new Ecurie("nom");
		Equipe equipe = new Equipe("test",10, 2, 3);
		try {
			connec.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1, Ecurie.enregistrerEcurie(connec, nom));
		assertEquals(1, Equipe.enregistrerEquipe(connec,equipe));
	}

}
