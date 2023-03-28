package ihm.info;

import javax.swing.*;

import ihm.tournois.FrameArbitrageTournois;
import object.Match;
import object.Tournoi;
import controleur.ControlleurListeMatch;
import controleur.ModeleESporter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class VueInfoTournoisPanel extends JPanel {

    public VueInfoTournoisPanel(Tournoi tournoi, ControlleurListeMatch controleur,VueInfoTournoisEnCoursFrame sourceFrame) {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        List<ListeMatch> listes = new ArrayList<>();

        // Création des modèles de tableau
        if (!(tournoi.getPhaseElim() == null)) {
             listes.add(new ListeMatch(tournoi.getPhaseElim().getMatchsAJouer()));
        }
        else {
            for (int i = 0; i < 4; i++) {
             listes.add(new ListeMatch(tournoi.getPhasePoule().getListeMatchPoule(i)));
            }

        }

        //Spacing
        //this.add(Box.createRigidArea(new Dimension(0,5)));

        if (listes.size() >1) {
        for (int i = 0; i < listes.size(); i++) {
        setList(tournoi, controleur, sourceFrame, listes.get(i),"Poule "+(i+1));
        }}
        else {
            if (tournoi.getPhaseElim().estFinale()) {
                setList(tournoi, controleur, sourceFrame,new ListeMatch(tournoi.getPhaseElim().getMatchsAJouer().subList(0,1)) ,"Petite finale");
                setList(tournoi, controleur, sourceFrame,new ListeMatch(tournoi.getPhaseElim().getMatchsAJouer().subList(1,2)) ,"Finale");
            }
            else {
                String titre;
                if (tournoi.getPhaseElim().getMatchsAJouer().size()<=2) {
                    titre = "Demi finale";
                } else if (tournoi.getPhaseElim().getMatchsAJouer().size()<=4) {
                    titre = "Quarts de finale";
                }
                else {
                    titre = "Phase éliminatoire";
                }
                setList(tournoi, controleur, sourceFrame, new ListeMatch(tournoi.getPhaseElim().getMatchsAJouer()), titre);
            }
        }


    }

    private void setList(Tournoi tournoi, ControlleurListeMatch controleur, VueInfoTournoisEnCoursFrame sourceFrame, ListeMatch listeMatch,String titre) {


        // Création des tableaux
        JList jListMatchs = new JList(listeMatch);
        jListMatchs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ligne = jListMatchs.getSelectedIndex();

                Match match  =(Match) listeMatch.getValueAt(ligne);

                System.out.println(tournoi);
                FrameArbitrageTournois window = new FrameArbitrageTournois(match);
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

        jListMatchs.setFont(new Font("monospaced",Font.PLAIN, ModeleESporter.FONT_SIZE_MEDIUM));

        // Création de la barre de défilement pour les tableaux

        JScrollPane scrollPane1 = new JScrollPane(jListMatchs);


        JLabel titreMatchs = new JLabel(titre);
        titreMatchs.setFont(ModeleESporter.FONT_LARGE);
        titreMatchs.setAlignmentX(0.5f);
        this.add(titreMatchs);
        //this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(scrollPane1);
    }


}