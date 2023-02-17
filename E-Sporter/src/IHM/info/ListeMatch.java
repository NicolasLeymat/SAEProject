package IHM.info;

import java.util.List;
import Object.Match;

import javax.swing.*;

public class ListeMatch extends AbstractListModel {
    private List<Match> matchs;
    private static final int TAILLESEP = 50;
    private static final String VSTRING = "CONTRE";
    public ListeMatch(List<Match> matchs) {
        this.matchs = matchs;
    }

    @Override
    public int getSize() {
        return matchs.size();
    }

    /**
     *
     * @param index L'indice de la liste
     * @return affiche les informations sur les matchs d'un tournoi
     */
    @Override
    public Object getElementAt(int index) {
        Match match = matchs.get(index);
        // Nom de l'equipe ainsi que des espaces pour centrer
        String stringE1="";
        String stringE2="";
        // Il n'y a pas de if-else car un match peut ne pas avoir de gagnant s'il n'a pas ete joué
        //Ajoute une couronne à gauche du nom de l'equipe gagnante
        if (match.getWinner() == match.getEquipe1()) {
            stringE1 +="👑 ";
        }
        if (match.getWinner() == match.getEquipe2()) {
            stringE2 +="👑 ";
        }
        stringE1 += match.getEquipe1().getNom();
        stringE2 += match.getEquipe2().getNom();
        String res =stringE1;
        int separateur = TAILLESEP -stringE1.length();
        for (int i = 0; i < separateur; i++) {
            res+=" ";
        }
        res+= VSTRING;

        for (int i = 0; i < (TAILLESEP-VSTRING.length())/2; i++) {
            res+=" ";
        }
        res+=stringE2;
        return res;
    }

    public Object getValueAt(int ligne) {
        return matchs.get(ligne);
    }
}
