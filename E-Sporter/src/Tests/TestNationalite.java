package Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import Object.Jeu;
import Object.Nationalite;

public class TestNationalite {

	@Test
	public void testGetPaysByCode(){
		assertEquals("France",Nationalite.getByCode("FR").getNom());
	}
	
	@Test
	public void testGetPaysByNom(){
		assertEquals("VN",Nationalite.getByNom("Vietnam").getCode());
	}
	
	@Test
	public void testGetPaysByCodeFaux(){
		assertEquals(null,Nationalite.getByCode("ZZ"));
	}
	
	@Test
	public void testGetPaysByNomFaux(){
		assertEquals(null,Nationalite.getByNom("Yougoslavie"));
	}
	
}
