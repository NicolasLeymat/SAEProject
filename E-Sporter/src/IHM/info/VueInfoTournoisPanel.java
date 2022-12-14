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

        ListeMatch listemodel1;
        // Création des modèles de tableau
        if (tournoi.getPhasePoule().matchsFinis()) {
             listemodel1 = new ListeMatch(tournoi.getPhaseElim().getMatchs());
        }
        else {
             listemodel1 = new ListeMatch(tournoi.getPhasePoule().getMatchs());
        }

        //Spacing
        this.add(Box.createRigidArea(new Dimension(0,5)));

        // Création des tableaux
        JList table1 = new JList(listemodel1);
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ligne = table1.getSelectedIndex();

                Match match  =(Match) listemodel1.getValueAt(ligne);

                System.out.println(tournoi);
                IHM.tournois.ArbitrageTournois window = new ArbitrageTournois(match);
                window.setVisible(true);
            }
        });
        DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //table1.setCellRenderer(centerRenderer);
        table1.setFont(new Font("monospaced",Font.PLAIN, ModeleESporter.FONT_SIZE_MEDIUM));

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