package controleur;

import IHM.info.VueInfoTournoisFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Object.Phase;
import Object.Tournoi;

public class ControlleurListeMatch implements ActionListener {
    private enum Etat {
        ENCOURS,FINIPOULE,FINIELIM,FINI
    }

    private Etat etat;
    private VueInfoTournoisFrame vue;

    public ControlleurListeMatch(VueInfoTournoisFrame vue) {
        this.vue = vue;
        setBoutonSuivant();
    }

    public void setBoutonSuivant() {
    	Tournoi t = this.vue.getTournoi();
        if (t.elimmatchsfini()) {
            System.out.println("ELIM");
            if (!t.getPhaseElim().estFinie()) {
                this.etat = Etat.FINIELIM;
                vue.setActiveNextButton(true);
            } else {
                this.etat = Etat.FINI;
                vue.setActiveNextButton(true);
            }
        } else if (t.getPhaseElim() == null && t.getPhasePoule().matchsFinis()) {
            this.etat = Etat.FINIPOULE;
            vue.setActiveNextButton(true);
        } else {
            this.etat = Etat.ENCOURS;
            vue.setActiveNextButton(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bouton = (JButton) e.getSource();
    	Tournoi t = this.vue.getTournoi();
        switch (etat) {
            case FINIPOULE: {
                etat = Etat.ENCOURS;
                t.genererPhaseFinale();
                Phase.enregistrerPhase(t.getPhaseElim());
                bouton.setEnabled(false);
                vue.dispose();
            }
            case FINIELIM: {
                etat = Etat.ENCOURS;
                t.getPhaseElim().genererMatchs();
                t.getPhaseElim().enregistrerMatchs();
                bouton.setEnabled(false);
                vue.dispose();
            }
            case FINI: {
                vue.setButtonText("Terminer le tournoi");
            	try {
                    t.ajouterPoints();
                    t.setEtat(Tournoi.EtatTournoi.FINI);
                    Tournoi.modifierTournoi(t);
                    vue.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
