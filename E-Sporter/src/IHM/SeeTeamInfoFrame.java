package IHM;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Equipe;

public class SeeTeamInfoFrame extends JFrame{

	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private VueTeamInfo teaminfo;
	
	public SeeTeamInfoFrame(Equipe e) {
		teaminfo = new VueTeamInfo(e);
		teaminfo.setBounds(0, 0, 600, 363);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		getContentPane().setLayout(null);
		getContentPane().add(teaminfo);
	}
}
