package Tests;

import org.junit.Before;
import org.junit.Test;
import Object.*;

import static org.junit.Assert.assertEquals;

public class TestAppTournois {
    private Tournoi t;
    private Jeu j;
    private Ecurie e;

    @Before
    public void setUP () throws Exception {
        this.j = new Jeu ("Rocket League");
        this.t = new Tournoi("Mondial Rocket League 2023","14/07/2023",3,j);
        this.e = new Ecurie("Faze RL");
    }

    @Test
    public void testCreerTournoi () throws Exception {
        Jeu LOL = new Jeu("League of Legends");
        Tournoi t = new Tournoi("World Lol","12/06/2022",1,LOL);
        assertEquals("World Lol",t.getNom());
        assertEquals("12/06/2022",t.getDateTournoi());
        assertEquals(1,t.getNotoriete());
        assertEquals(LOL,t.getJeu());
    }

    @Test
    public void testAjouterEquipe () throws Exception {
        Ecurie faze =  new Ecurie("Faze Clan");
        t.addEquipe(new Equipe("Faze RL",25,faze,j));
        assertEquals(faze,t.getEquipe(0));
    }

    @Test (expected = Exception.class)
    public void testAjouterEquipe17 () throws Exception {
        for (int i = 0; i < 16; i++) {
            t.addEquipe(new Equipe("Equipe"+i,25,e,j));
        }
        t.addEquipe(new Equipe("Equipe 16",25,e,j));
    }

    @Test (expected = Exception.class)
    public void testAjouterEquipeTropTard () throws Exception {
        Tournoi t = new Tournoi("Vieux Tournoi","12/12/2015",1,j);
        t.addEquipe(new Equipe("Equipe 1",25,e,j));
    }

}
