package IHM;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Object.Ecurie;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VueOrgaInfo extends JPanel {

	private ViewOrgaInfoPanel v;
	
	public VueOrgaInfo(Ecurie e) {
		this.setSize(600, 400);
		v = new ViewOrgaInfoPanel(e);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 50};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_v = new GridBagConstraints();
		gbc_v.insets = new Insets(0, 0, 5, 0);
		gbc_v.gridx = 0;
		gbc_v.gridy = 0;
		gbc_v.fill = GridBagConstraints.BOTH;
		this.add(v, gbc_v);
	}
	
}
