package IHM.add;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class AddPanel extends JPanel {

	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	
	public AddPanel(String type) {
		this.setSize(WIDTH, HEIGHT);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		switch(type) {
			case "Player":{
				break;
			}
			case "Team":{
				break;
			}
			case "Orga":{
				break;
			}
		}
	}

}
