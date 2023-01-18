package controleur;

import IHM.info.VueInfoTournoisFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Object.Phase;
import Object.Tournoi;

public class ControlleurListeMatch implements ActionListener {
    private enum ETAT {
        ENCOURS,FINIPOULE,FINIELIM,FINI
    }

    private ETAT etat;
    private VueInfoTournoisFrame vue;

    public ControlleurListeMatch(VueInfoTournoisFrame vue) {
        this.vue = vue;
        setBoutonSuivant();
    }

    public void setBoutonSuivant() {
        if (vue.getTournoi().elimmatchsfini()) {
            System.out.println("ELIM");
            if (!vue.getTournoi().getPhaseElim().estFinie()) {
                System.out.println("ELIM FINIE");
                this.etat = ETAT.FINIELIM;
                vue.setActiveNextButton(true);
            } else {
                System.out.println("TOURNOI FINI");
                this.etat = ETAT.FINI;
                vue.setActiveNextButton(true);
            }
        } else if (vue.getTournoi().getPhaseElim() == null) {
            System.out.println("POULE FINIE");
            System.out.println(vue.getTournoi().getPhaseElim());
            this.etat = ETAT.FINIPOULE;
            vue.setActiveNextButton(true);
        } else {
            System.out.println("POULE OU ELIM PAS FINIE");
            System.out.println(vue.getTournoi().getPhaseElim());
            this.etat = ETAT.ENCOURS;
            vue.setActiveNextButton(false);
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bouton = (JButton) e.getSource();
        switch (etat) {
            case FINIPOULE -> {
                etat = ETAT.ENCOURS;
                System.out.println(vue.getTournoi());
                vue.getTournoi().genererPhaseFinale();
                Phase.enregistrerPhase(vue.getTournoi().getPhaseElim());
                System.out.println("PHASE ELIM GENERE");
                System.out.println(vue.getTournoi().getPhaseElim());
                bouton.setEnabled(false);
                vue.dispose();
            }
            case FINIELIM -> {
                etat = ETAT.ENCOURS;
                vue.getTournoi().getPhaseElim().genererMatchs();
                vue.getTournoi().getPhaseElim().enregistrerMatchs();
                bouton.setEnabled(false);
                vue.dispose();
            }
            case FINI -> {
                bouton.setText("Terminer le tournoi");
                try {
                    vue.getTournoi().ajouterPoints();
                    vue.getTournoi().setEtat(Tournoi.ETAT.FINI);
                    System.out.println (vue.getTournoi().actualiserEtat());
                    System.out.println(vue.getTournoi().getEtat());
                    vue.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
