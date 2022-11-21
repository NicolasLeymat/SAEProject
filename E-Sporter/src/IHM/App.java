package IHM;

import java.awt.Dimension;

import javax.swing.JFrame;

public class App extends JFrame{

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 625;
	
	public App() {
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.add(new VuePrincipale());
	}
	
}
