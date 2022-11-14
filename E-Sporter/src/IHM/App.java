package IHM;

import javax.swing.JFrame;

public class App extends JFrame{

	public App() {
		this.setVisible(true);
		this.setSize(1200, 625);
		this.add(new VuePrincipale());
	}
	
}
