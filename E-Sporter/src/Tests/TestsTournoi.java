package Tests;

import org.junit.Before;
import Object.*;
import org.junit.Test;

import Application.Connexion;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestsTournoi {
    private List<Ecurie> ecurieList;
    private List<Equipe> equipeList;
    private Tournoi tournoi;
    private  Jeu jeu;

    @Before
    public void setUp() throws Exception {
        jeu = new Jeu("CSGO");
        Connection connx = Connexion.connexion();
        int id_mode = ModeDeJeu.getModeDeJeu(connx, 0).getId_Mode();
        tournoi = new Tournoi("Tournoi test", Date.valueOf("2022-12-12"),1,jeu, 0);

        for (int i = 0; i < 16; i++) {
            Ecurie ecurieadd = new Ecurie("Ecurie "+i);
            Equipe equipeadd = new Equipe("Equipe "+i,0,"Ecurie "+i,1);
            ecurieadd.addEquipe(equipeadd);
            tournoi.addEquipe(equipeadd);
        }
    }

    @Test
    public void testGenererMatchsPhaseGroupe () throws Exception {
        tournoi.getPhasePoule().genererPoules();
		System.out.println( tournoi.getPhasePoule().toString());
    }
}
