package IHM.champ;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

import Object.Equipe;
import controleur.ControleurFilter;
import controleur.ControleurJList;
import controleur.ControleurModif;
import controleur.ModeleESporter;

import java.awt.Color;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;


public class ChampPanel extends JPanel {

	private Equipe e;
	private JComboBox<String> filterMode;
	
	private static JList<Equipe> listEquipe = new JList<>();
	private static DefaultListModel<Equipe> modelEquipe = new DefaultListModel<>();
	
	
	public ChampPanel() {
		ControleurJList controleurEquipe = new ControleurJList();	
		ControleurModif controleurModif = new ControleurModif(e, this); 
		ChampPanel.changeModelResultChamp(Equipe.getClassementByGame(0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{350, 0};
		gridBagLayout.rowHeights = new int[]{350, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		ControleurFilter<String> controleurMode = new ControleurFilter<>("Championnat");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		listEquipe.addMouseListener(controleurEquipe);
		listEquipe.setModel(modelEquipe);
		JScrollPane teamPanel = new JScrollPane(listEquipe);
		teamPanel.setBounds(90, 50, 300, 300);
		panel.add(teamPanel);
		teamPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		JPanel filterTeamPanel = new JPanel();
		teamPanel.setColumnHeaderView(filterTeamPanel);
		filterMode = new JComboBox<>();
		filterMode.setFont(ModeleESporter.FONT_MEDIUM);
		filterMode.addActionListener(controleurMode);
		filterTeamPanel.add(filterMode);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, ModeleESporter.FONT_SIZE_LARGE));
		btnAnnuler.setBounds(10, 10, 200, 50);
		btnAnnuler.addActionListener(controleurModif);
		panel_1.add(btnAnnuler); 
		 
		
		for(String s : ModeleESporter.getAllModeName()){
			filterMode.addItem(s);
		}
	}
	
	public static void changeModelResultChamp(List<Equipe> l) {
		modelEquipe.clear();
		modelEquipe.addAll(l);
	}
}
