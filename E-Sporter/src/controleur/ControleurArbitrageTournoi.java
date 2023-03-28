package controleur;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.tournois.VueArbitrageMatch;
import object.Match;

public class ControleurArbitrageTournoi implements ActionListener {
    private VueArbitrageMatch vue;

    private ModeleESporter modele;
    private Match match;


    public ControleurArbitrageTournoi(VueArbitrageMatch vue) {
        this.vue = vue;
        this.match = vue.getMatch();
        this.modele = new ModeleESporter();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
            JButton bouton = (JButton) e.getSource();
            if (bouton == vue.getButtonWin1()) {
                bouton.setEnabled(false);
                vue.getButtonWin2().setEnabled(true);
                match.setWinner(1);
            }
            else {
                bouton.setEnabled(false);
                vue.getButtonWin1().setEnabled(true);
                match.setWinner(2);
            }
            modele.getPanelFrame(vue).dispose();

    }
}
