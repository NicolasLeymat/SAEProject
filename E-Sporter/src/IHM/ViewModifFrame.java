package IHM;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Ecurie;
import Object.Equipe;

public class ViewModifFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private ViewModifPanel vue;

	public ViewModifFrame(Equipe e) {
		vue = new ViewModifPanel(e);
		vue.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(600, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}

	public ViewModifFrame(Ecurie eq) {
		vue = new ViewModifPanel(eq);
		vue.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(600, 500));
		getContentPane().setLayout(null);
		getContentPane().add(vue);
	}

}
