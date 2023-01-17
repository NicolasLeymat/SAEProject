package controleur;

import IHM.info.VueInfoTournoisFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurListeMatch implements ActionListener {
    private enum ETAT {
        ENCOURS,FINIPOULE,FINIELIM,FINI
    }

    private ETAT etat;
    private VueInfoTournoisFrame vue;

    public ControlleurListeMatch(VueInfoTournoisFrame vue) {
        this.vue = vue;
        if (!vue.getTournoi().getPhasePoule().matchsFinis()) {
            System.out.println("POULE PAS FINIE");
            this.etat = ETAT.ENCOURS;
            vue.setActiveNextButton(false);
        } else if (!(vue.getTournoi().getPhaseElim() == null) && vue.getTournoi().getPhaseElim().matchsFinis()) {
            System.out.println("ELIM");
            if (!vue.getTournoi().getPhaseElim().estFinie()) {
                System.out.println("ELIM FINIE");
                this.etat = ETAT.FINIELIM;
            }
            else {
                System.out.println("C LA FIN");
                this.etat = ETAT.FINI;
            }
            vue.setActiveNextButton(true);
        }
        else {
            System.out.println("POULE FINIE");
            this.etat =ETAT.FINIPOULE;
            vue.setActiveNextButton(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bouton = (JButton) e.getSource();
        switch(etat) {
            case FINIPOULE : etat = ETAT.ENCOURS;
            System.out.println(vue.getTournoi());
            vue.getTournoi().genererPhaseFinale();
            bouton.setEnabled(false);
            break;

            case FINIELIM: etat =ETAT.ENCOURS;
            vue.getTournoi().getPhaseElim().genererMatchs();
            bouton.setEnabled(false);
            break;

            case FINI:
                bouton.setText("Terminer le tournoi");
                try {
                    vue.getTournoi().ajouterPoints();
                    vue.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }

        }
    }
}
