package IHM;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Ecurie;
import Object.Equipe;

public class SeeOrganisationInfoFrame extends JFrame{

	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private VueOrgaInfo orgainfo;
	
	public SeeOrganisationInfoFrame(Ecurie e) {
		orgainfo = new VueOrgaInfo(e);
		orgainfo.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(650, 500));
		getContentPane().setLayout(null);
		getContentPane().add(orgainfo);
	}
}
