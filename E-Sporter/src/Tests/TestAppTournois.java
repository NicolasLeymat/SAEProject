package Tests;

import org.junit.Before;
import org.junit.Test;
import Object.*;

import static org.junit.Assert.assertEquals;

public class TestAppTournois {
    private Tournoi t;
    private Jeu j;

    @Before
    public void setUP () {
        this.j = new Jeu ("Rocket League");
        this.t = new Tournoi("Mondial Rocket League 2023","14/07/2023",3);
    }

    @Test
    public void testCreerTournoi () throws Exception {
        Jeu LOL = new Jeu("League of Legends", 5);
        Tournoi t = new Tournoi("World Lol","12/06/2022",1,LOL);
        assertEquals("World Lol",t.getNom());
        assertEquals("12/06/2022",t.getDateTournoi());
        assertEquals(1,t.getNotoriete());
        assertEquals(LOL,t.getJeu());
    }

    @Test
    public void testAjouterEquipe () {
        Ecurie faze =  new Ecurie("Faze Clan");
        t.ajouterEquipe(new Equipe("Faze RL",25,j));
        assertEquals(faze,t.getEquipe(0));
    }

    @Test (expected = TooManyTeamsException.class)
    public void testAjouterEquipe17 () {
        for (int i = 0; i < 16; i++) {
            t.ajouterEquipe(new Equipe("Equipe"+i,25,j));
        }
        t.ajouterEquipe(new Equipe("Equipe 16",25,j));
    }

    @Test (expected = TooLateException.class)
    public void testAjouterEquipe17 () {
        Tournoi t new Tournoi("Vieux Tournoi","12/12/2015",1);
        t.ajouterEquipe(new Equipe("Equipe 1",25,j));
    }

}
