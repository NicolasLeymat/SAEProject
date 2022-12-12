package IHM.modif;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Ecurie;
import Object.Equipe;

public class VueModifFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private VueModifPanel vue;

	public VueModifFrame(Equipe e) {
		vue = new VueModifPanel(e);
		vue.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(600, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}

	public VueModifFrame(Ecurie eq) {
		vue = new VueModifPanel(eq);
		vue.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(600, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}

}
