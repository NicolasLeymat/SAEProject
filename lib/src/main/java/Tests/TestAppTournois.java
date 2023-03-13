package Tests;


/*
import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import Object.*;

public class TestAppTournois {
    private Tournoi t;
    private Jeu j;
    //private Ecurie e;

    @Before
    public void setUP () throws Exception {
        this.j = new Jeu ("Rocket League");
        //this.t = new Tournoi("Mondial Rocket League 2023",Date.valueOf("2023-07-14"),3,j);
        //this.e = new Ecurie("Faze RL");
    }
/*
    @Test
    public void testCreerTournoi () throws Exception {
        Jeu LOL = new Jeu("League of Legends");
        Tournoi t = new Tournoi("World Lol",Date.valueOf("2022-11-12"),1,LOL);
        assertEquals("World Lol",t.getNom());
        assertEquals(Date.valueOf("2022-11-12"),t.getDateTournoi());
        assertEquals(1,t.getNotoriete());
        assertEquals(LOL,t.getJeu());
    }

    @Test
    public void testAjouterEquipe () throws Exception {
        //Ecurie faze =  new Ecurie("Faze Clan");
        Equipe fazerl = new Equipe("fazerl",12,"",5);
        t.addEquipe(fazerl);
        assertEquals(fazerl,t.getEquipeTournoi(0));
    }

    @Test (expected = Exception.class)
    public void testAjouterEquipe17 () throws Exception {
        for (int i = 0; i < 16; i++) {
            t.addEquipe(new Equipe("Equipe"+i,25,"",3));
        }
        t.addEquipe(new Equipe("Equipe 16",25,"",3));
    }

    @Test (expected = Exception.class)
    public void testAjouterEquipeTropTard () throws Exception {
        //Tournoi t = new Tournoi("Vieux Tournoi",Date.valueOf("2015-12-12"),1,j);
        t.addEquipe(new Equipe("Equipe 1",25,"",1));
    }
    
    @Test
    public void testGetEquipe() throws Exception {
    	Equipe equipe = new Equipe("Equipe Test",10,"",5);
    	t.addEquipe(equipe);
    	assertEquals(t.getEquipe("Equipe Test"), equipe);
    }
    
    @Test
    public void testGetEquipeFausse() throws Exception {
    	Equipe equipe = new Equipe("Equipe Test",10,"",3);
    	t.addEquipe(equipe);
    	assertEquals(t.getEquipe("Equipe Fest"), null);
    }

}
*/
