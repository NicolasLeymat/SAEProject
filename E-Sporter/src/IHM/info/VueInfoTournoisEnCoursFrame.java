package ihm.info;

import controleur.ControlleurListeMatch;
import controleur.ModeleESporter;
import object.Tournoi;

import javax.swing.*;
import java.awt.*;


public class VueInfoTournoisEnCoursFrame extends JFrame {
    private Tournoi tournoi;
    private int nbMatchsRestants;

    private JLabel labelMatchsRestants;

    private JButton nextbutton;
    public Tournoi getTournoi() {
        return tournoi;
    }
    public void setButtonText(String s) {
    	nextbutton.setText(s);
    }

    public VueInfoTournoisEnCoursFrame(Tournoi tournoi) {
        this.tournoi =tournoi;
        this.labelMatchsRestants = new JLabel();

        JLabel titreTournoi = new JLabel(tournoi.getNom(),SwingConstants.CENTER);
        titreTournoi.setFont(ModeleESporter.FONT_LARGE);
        titreTournoi.setAlignmentX(0.5f);


        this.setMinimumSize(new Dimension(1400, 600));
        this.setLayout(new BorderLayout());

        this.nextbutton  = new JButton("Phase suivante");
        ControlleurListeMatch controlleurListeMatch = new ControlleurListeMatch(this);
        JPanel panelBoutons = new JPanel();
        VueInfoTournoisPanel  infoTournoisPanel= new VueInfoTournoisPanel(tournoi,controlleurListeMatch,this);


        panelBoutons.setLayout(new BoxLayout(panelBoutons,BoxLayout.LINE_AXIS));
        this.nextbutton.addActionListener(controlleurListeMatch);


        refreshNbMatchs();
        panelBoutons.add(labelMatchsRestants);

        panelBoutons.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        panelBoutons.add(Box.createHorizontalGlue());
        panelBoutons.add(Box.createRigidArea(new Dimension(10, 0)));

        panelBoutons.add(this.nextbutton);
        this.add(panelBoutons);

        JScrollPane scrollInfoTournoiPanel = new JScrollPane(infoTournoisPanel);

        //Put everything together, using the content pane's BorderLayout.
        Container contentPane = getContentPane();
        contentPane.add(titreTournoi, BorderLayout.NORTH);
        contentPane.add(scrollInfoTournoiPanel, BorderLayout.CENTER);
        contentPane.add(panelBoutons, BorderLayout.PAGE_END);


    }

    public void refreshNbMatchs() {
        if (tournoi.getPhaseElim() == null ) {
            nbMatchsRestants = tournoi.getPhasePoule().nbMatchsRestants();
        }
        else {
            nbMatchsRestants = tournoi.getPhaseElim().nbMatchsRestants();
        }
        labelMatchsRestants.setText("Matchs à arbitrer " +nbMatchsRestants);
    }

    public void setActiveNextButton(boolean b) {
        nextbutton.setEnabled(b);
    }


}