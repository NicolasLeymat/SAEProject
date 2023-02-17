package IHM.info;

import java.util.List;
import Object.Match;
import Object.Equipe;

import javax.swing.*;

public class ListeMatch extends AbstractListModel {
    private List<Match> matchs;
    private static final int TAILLESEP = 25;
    private static final int TAILLESEP2 = 15;
    public ListeMatch(List<Match> matchs) {
        this.matchs = matchs;
    }

    @Override
    public int getSize() {
        return matchs.size();
    }

    @Override
    public Object getElementAt(int index) {
        Match match = matchs.get(index);
        String stringE1="";
        String stringJ2="";
        if (match.getWinner() == match.getEquipe1()) {
            stringE1 +="👑 ";
        }
        if (match.getWinner() == match.getEquipe2()) {
            stringJ2 +="👑 ";
        }
        stringE1 += match.getEquipe1().getNom();
        stringJ2 += match.getEquipe2().getNom();
        String res =stringE1;
        int separateur = TAILLESEP -stringE1.length();
        for (int i = 0; i < separateur; i++) {
            res+=" ";
        }
        res+="VS";

        for (int i = 0; i < TAILLESEP2; i++) {
            res+=" ";
        }
        res+=stringJ2;
        return res;
    }

    public Object getValueAt(int ligne) {
        return matchs.get(ligne);
    }
}
