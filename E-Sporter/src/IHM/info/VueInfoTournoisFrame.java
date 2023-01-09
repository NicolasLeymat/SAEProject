package IHM.info;

import Object.Tournoi;

import javax.swing.*;
import java.awt.*;


public class VueInfoTournoisFrame extends JFrame {
    public VueInfoTournoisFrame(Tournoi tournoi) {

        this.setSize(600, 450);
        this.setLayout(new BorderLayout());

        VueInfoTournoisPanel  infoTournoisPanel= new VueInfoTournoisPanel(tournoi);

        JPanel panelBouton = new JPanel();
        panelBouton.setLayout(new BoxLayout(panelBouton,BoxLayout.LINE_AXIS));
        JButton boutonNext  = new JButton("Phase suivante");
        panelBouton.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        panelBouton.add(Box.createHorizontalGlue());
        panelBouton.add(Box.createRigidArea(new Dimension(10, 0)));
        panelBouton.add(boutonNext);
        this.add(panelBouton);

        //Put everything together, using the content pane's BorderLayout.
        Container contentPane = getContentPane();
        contentPane.add(infoTournoisPanel, BorderLayout.CENTER);
        contentPane.add(panelBouton, BorderLayout.PAGE_END);




    }


}