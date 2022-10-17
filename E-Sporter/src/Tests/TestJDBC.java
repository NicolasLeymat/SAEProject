package Tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import Application.Application;
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
	public void testInsererUneEquipe() {
		Connection connec = Connexion.connexion();
		Equipe equipe = new Equipe("test",10, new Ecurie("nom"), new Jeu("overwatch"));
		try {
			connec.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1, equipe.enregistrerEquipe());
	}

}
