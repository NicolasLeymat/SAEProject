package IHM.tournois;



import javax.swing.JFrame;
import Object.Match;

public class FrameArbitrageTournois extends JFrame {
	private Match match;
  
	public FrameArbitrageTournois(Match match) {
		this.match = match;
	    // définition de la fenêtre
	    setTitle(match.getEquipe1().getNom() +" VS "+ match.getEquipe2().getNom());
	    setSize(500, 275);
		setResizable(false);
	    setLocationRelativeTo(null);
	    this.setContentPane(new VueArbitrageTournois(match));
	}
  

}

