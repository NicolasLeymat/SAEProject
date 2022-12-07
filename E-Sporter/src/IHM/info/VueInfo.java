package IHM.info;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Object.Ecurie;
import Object.Equipe;
import controleur.ControleurModif;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;

public class VueInfo extends JPanel {

	private JPanel v;
	
	public VueInfo(Ecurie e) {
		this.setSize(600, 400);
		ControleurModif c = new ControleurModif(e, this);
		v = new ViewInfoPanel(e);
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton modfier = new JButton("Modifier");
		modfier.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modfier.setBounds(390, 0, 200, 50);
		modfier.addActionListener(c);
		panel.add(modfier);
		
	}
	
	public VueInfo(Equipe e) {
		this.setSize(600, 400);
		ControleurModif c = new ControleurModif(e, this);
		v = new ViewInfoPanel(e);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 50};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE, 0.0};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_v = new GridBagConstraints();
		gbc_v.insets = new Insets(0, 0, 5, 0);
		gbc_v.gridx = 0;
		gbc_v.gridy = 0;
		this.add(v, gbc_v);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton modfier = new JButton("Modifier");
		modfier.setBounds(257, 5, 85, 25);
		modfier.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modfier.setBounds(390, 0, 200, 50);
		modfier.addActionListener(c);
		panel.add(modfier);
		
		
		JButton add_To_Tournament = new JButton("Ajouter à un tournoi");
		add_To_Tournament.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		add_To_Tournament.setBounds(10, 0, 200, 50);
		panel.add(add_To_Tournament);
		
	}
}
