package IHM.info;

import javax.swing.*;

import IHM.tournois.FrameArbitrageTournois;
import Object.Tournoi;
import Object.Match;
import controleur.ControlleurListeMatch;
import controleur.ModeleESporter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class VueInfoTournoisPanel extends JPanel {

    public VueInfoTournoisPanel(Tournoi tournoi, ControlleurListeMatch controleur,VueInfoTournoisEnCoursFrame sourceFrame) {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        ListeMatch listeMatch;
        // Création des modèles de tableau
        if (!(tournoi.getPhaseElim() == null)) {
             listeMatch = new ListeMatch(tournoi.getPhaseElim().getMatchsAJouer());
        }
        else {
             listeMatch = new ListeMatch(tournoi.getPhasePoule().getMatchs());
        }

        //Spacing
        this.add(Box.createRigidArea(new Dimension(0,5)));

        // Création des tableaux
        JList jListMatchs = new JList(listeMatch);
        jListMatchs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ligne = jListMatchs.getSelectedIndex();

                Match match  =(Match) listeMatch.getValueAt(ligne);

                System.out.println(tournoi);
                IHM.tournois.FrameArbitrageTournois window = new FrameArbitrageTournois(match);
                window.setVisible(true);

                window.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        Match.validerVainqueur(match);
                        jListMatchs.repaint();
                        sourceFrame.refreshNbMatchs();
                        controleur.setBoutonSuivant();
                    }
                });
            }
        });
        DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //jListMatchs.setCellRenderer(centerRenderer);
        jListMatchs.setFont(new Font("monospaced",Font.PLAIN, ModeleESporter.FONT_SIZE_MEDIUM));

        // Création de la barre de défilement pour les tableaux

        JScrollPane scrollPane1 = new JScrollPane(jListMatchs);

        JLabel titreTournoi = new JLabel(tournoi.getNom());
        titreTournoi.setFont(ModeleESporter.FONT_LARGE);
        titreTournoi.setAlignmentX(0.5f);
        this.add(titreTournoi);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JLabel titreMatchs = new JLabel("Matchs en cours");
        titreMatchs.setFont(ModeleESporter.FONT_LARGE);
        titreMatchs.setAlignmentX(0.5f);
        this.add(titreMatchs);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(scrollPane1);



    }


}