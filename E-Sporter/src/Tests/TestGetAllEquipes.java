package Tests;

import java.util.List;

import Application.Connexion;
import Object.*;

public class TestGetAllEquipes {

	public static void main(String[] args) {
		List<Equipe> liste = Equipe.getAllEquipes(Connexion.connexion());
		for (Equipe e : liste) {
			System.out.println(e.toString());
		}
	}

}
