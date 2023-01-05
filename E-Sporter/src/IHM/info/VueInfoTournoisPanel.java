package IHM.info;

import javax.swing.*;
import Object.Tournoi;

import java.awt.*;


public class VueInfoTournoisPanel extends JPanel {
    public VueInfoTournoisPanel(Tournoi tournoi) {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));



        // Création des modèles de tableau
        TableauMatch tableModel1 = new TableauMatch(tournoi.getPhasePoule().getMatchs());

        // Création des tableaux
        JTable table1 = new JTable(tableModel1);

        // Création de la barre de défilement pour les tableaux
        JScrollPane scrollPane1 = new JScrollPane(table1);

        this.add(scrollPane1);







    }


}