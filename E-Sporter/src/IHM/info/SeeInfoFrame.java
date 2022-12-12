package IHM.info;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Ecurie;
import Object.Equipe;

public class SeeInfoFrame extends JFrame{

	private final int WIDTH = 600;
	private final int HEIGHT = 450;
	private VueInfoPanel vue;
	
	public SeeInfoFrame(Ecurie ec) {
		vue = new VueInfoPanel(ec);
		vue.setBounds(0, 0, WIDTH, HEIGHT);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(650, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}
	
	public SeeInfoFrame(Equipe eq) {
		vue = new VueInfoPanel(eq);
		vue.setBounds(0, 0, WIDTH, HEIGHT);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(650, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}
}
