package IHM.tournois;



import javax.swing.JFrame;
import Object.Match;

public class FrameArbitrageTournois extends JFrame {
	private Match match;
  
	public FrameArbitrageTournois(Match t) {
		this.match = t;
	    // définition de la fenêtre
	    setTitle("Fenêtre avec deux listes");
	    setSize(500, 275);
	    setLocationRelativeTo(null);
	    this.setContentPane(new VueArbitrageTournois(t));
	}
  

}

