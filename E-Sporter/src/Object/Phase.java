package Object;

import java.util.ArrayList;
import java.util.List;

public abstract class Phase {
    private Tournoi tournoi;
    private List<Match> matchs;

    public abstract void genererMatchs();

    public abstract boolean isElim();

    public Tournoi getTournoi() {
        return tournoi;
    }

    public Phase(Tournoi tournoi) {
        this.tournoi = tournoi;
        this.matchs = new ArrayList<>();
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public Match getMatch(int i) {
        return matchs.get(i);
    }

    public int getId() {
        return 0;
    }

    //Verifie que tous les matchs à jouer ont un gagnant
    public abstract boolean matchsFinis() ;

    @Override
    public String toString() {
        return "Phase{" +
                "elim=" + isElim() +
                ", matchs=\n" + getMatchs() +
                '}';
    }
}
