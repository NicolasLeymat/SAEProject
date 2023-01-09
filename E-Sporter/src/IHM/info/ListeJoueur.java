package IHM.info;

import javax.swing.*;
import Object.Joueur;

import java.util.List;


public class ListeJoueur extends AbstractListModel {
    private List<Joueur> joueurs;

    public ListeJoueur(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    @Override
    public int getSize() {
        return joueurs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return joueurs.get(index).getPseudo();
    }


}
