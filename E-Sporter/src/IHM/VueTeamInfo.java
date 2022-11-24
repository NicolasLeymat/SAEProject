package IHM;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import Object.Equipe;

public class VueTeamInfo extends JPanel{

	private ViewTeamInfoPanel v;
	
	public VueTeamInfo(Equipe e) {
		this.setSize(600, 400);
		v = new ViewTeamInfoPanel(e);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		this.add(v);
		
	}
	
}
