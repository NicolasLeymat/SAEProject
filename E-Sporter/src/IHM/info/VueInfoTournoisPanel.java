package IHM.info;

import javax.swing.*;

import IHM.tournois.ArbitrageTournois;
import Object.Tournoi;
import Object.Match;
import controleur.ModeleESporter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VueInfoTournoisPanel extends JPanel {
    public VueInfoTournoisPanel(Tournoi tournoi) {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        TableauMatch tableModel1;
        // Création des modèles de tableau
        if (tournoi.getPhasePoule().matchsFinis()) {
             tableModel1 = new TableauMatch(tournoi.getPhasePoule().getMatchs());
        }
        else {
             tableModel1 = new TableauMatch(tournoi.getPhasePoule().getMatchs());
        }

        //Spacing
        this.add(Box.createRigidArea(new Dimension(0,5)));

        // Création des tableaux
        JTable table1 = new JTable(tableModel1);
        table1.getTableHeader().setFont(ModeleESporter.FONT_MEDIUM);
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ligne = table1.rowAtPoint(e.getPoint());

                Match match  =(Match) tableModel1.getValueAt(ligne);

                System.out.println(tournoi);
                IHM.tournois.ArbitrageTournois window = new ArbitrageTournois(match);
                window.setVisible(true);
            }
        });

        // Création de la barre de défilement pour les tableaux
        JScrollPane scrollPane1 = new JScrollPane(table1);

        JLabel titre = new JLabel(tournoi.getNom());
        titre.setFont(ModeleESporter.FONT_LARGE);
        titre.setAlignmentX(0.5f);
        this.add(titre);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel titreArbitrer = new JLabel("Matchs en cours");
        titreArbitrer.setFont(ModeleESporter.FONT_LARGE);
        titreArbitrer.setAlignmentX(0.5f);
        this.add(titreArbitrer);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(scrollPane1);



    }


}