package IHM.tournois;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import Object.Tournoi;


public class FrameClassementTournois extends JFrame {

	private VueClassementTournois contentPane;
	
	/**
	 * Create the frame.
	 */
	public FrameClassementTournois(Tournoi t) {
		setBounds(100, 100, 1000, 665);
		contentPane = new VueClassementTournois(t);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
