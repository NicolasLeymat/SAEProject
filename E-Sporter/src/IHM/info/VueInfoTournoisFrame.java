package IHM.info;

import Object.Tournoi;

import javax.swing.*;


public class VueInfoTournoisFrame extends JFrame {
    public VueInfoTournoisFrame(Tournoi tournoi) {

        this.setSize(600, 450);

        this.add(new VueInfoTournoisPanel(tournoi));




    }


}