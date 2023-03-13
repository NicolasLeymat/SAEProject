package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEcurie.class, TestEquipe.class, TestJeu.class, TestJoueur.class, TestOrganisateur.class, TestModeDeJeu.class, TestNationalite.class })
public class AllTests {

}
