package Tests;

import org.junit.Before;
import Object.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import Application.Connexion;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class TestsTournoi {
    private List<Ecurie> ecurieList;
    private List<Equipe> equipeList;
    private Tournoi tournoi;
    private  Connection connx;

    @Before
    public void setUp() throws Exception {
        tournoi = new Tournoi("Tournoi test", Date.valueOf("2023-12-12"), 1,1,1, ModeDeJeu.getModeDeJeuFromId(1));
        this.connx = Connexion.connexion();
        for (int i = 0; i < 16; i++) {
            Ecurie ecurieadd = new Ecurie("Ecurie "+i);
            Equipe equipeadd = new Equipe("Equipe "+i);
            ecurieadd.addEquipe(equipeadd);
            tournoi.addEquipe(equipeadd);
        }
    }
    
    @Test
    public void testEnregisterTournoi() throws Exception {
    	this.connx.setAutoCommit(false);
    	assertEquals(1, Tournoi.enregistrerTournoi(tournoi));
    }

    @Test
    public void testGenererMatchsPhaseGroupe () throws Exception {
        tournoi.getPhasePoule().genererPoules();
		System.out.println( tournoi.getPhasePoule().toString());
    }

    @Test
    public void testClassementPoule() throws Exception {
        PhaseDePoule phaseDePoule = tournoi.getPhasePoule();
        phaseDePoule.genererPoules();
       phaseDePoule.enregistrerGagnant(0, phaseDePoule.getMatch(0),1);
        Equipe gagnant =  phaseDePoule.getMatch(0).getWinner();
        System.out.println(tournoi.getPhasePoule().toString());
        assertEquals(gagnant, phaseDePoule.getPremier(0));
    }

    @Test
    public void testPhaseFinale() throws Exception {
        PhaseDePoule phaseDePoule = tournoi.getPhasePoule();
        PhaseFinale phaseE = tournoi.getPhaseElim();
        phaseDePoule.genererPoules();
        int i = 0;
        for (Match m:
             phaseDePoule.getMatchs()) {
            phaseDePoule.enregistrerGagnant(i,m,1);
            i=(i+1)%4;
        }
        tournoi.genererPhaseFinale();
        for (int j = 0; j < 3; j++) {
            for (Match m:
                 phaseE.getMatchsAJouer()) {
                m.setWinner(1);
            }
            phaseE.genererMatchs();
        }
        tournoi.ajouterPoints();
        System.out.println(tournoi.toString());
        assertEquals(115,phaseE.getMatch(0).getEquipe1().getPoints());
    }


}
