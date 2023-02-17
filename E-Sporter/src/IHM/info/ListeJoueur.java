package IHM.info;

import javax.swing.*;
import Object.Joueur;

import java.util.List;


public class ListeJoueur extends AbstractListModel {
    private List<Joueur> joueurs;

    /**
     * Constructeur de la liste
     *
     * @param joueurs Liste des joueurs à integrer dans la liste
     */
    public ListeJoueur(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    /**
     * Renvoie la taille de la liste
     *
     * @return nombre d'élements de la liste
     */
    @Override
    public int getSize() {
        return joueurs.size();
    }

    /**
     *
     * @param index l'indice de la liste
     * @return le joueur à l'indice demandé
     */
    @Override
    public Joueur getElementAt(int index) {
        return  joueurs.get(index);
    }


}
