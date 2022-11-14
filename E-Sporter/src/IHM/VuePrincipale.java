package IHM;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class VuePrincipale extends JPanel{

	public VuePrincipale() {
		this.setSize(1200, 725);
		this.setLayout(null);
		
		SearchPanel searchPanel = new SearchPanel();
		
		MainPanel mainPanel = new MainPanel();
		mainPanel.setSize(1200, 625);
		
		this.add(searchPanel);
		this.add(mainPanel);
	}

//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1200, 725);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setLocation(0, 0);
//		panel.setSize(1186, 663);
//		frame.getContentPane().add(panel);
//		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.columnWidths = new int[]{395, 395, 395, 0};
//		gbl_panel.rowHeights = new int[] {100, 500, 100, 0};
//		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		panel.setLayout(gbl_panel);
//		
//		JLabel EquipesName = new JLabel("Equipes");
//		EquipesName.setHorizontalAlignment(JLabel.CENTER);
//		EquipesName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_EquipesName = new GridBagConstraints();
//		gbc_EquipesName.fill = GridBagConstraints.HORIZONTAL;
//		gbc_EquipesName.insets = new Insets(0, 0, 5, 5);
//		gbc_EquipesName.gridx = 0;
//		gbc_EquipesName.gridy = 0;
//		panel.add(EquipesName, gbc_EquipesName);
//		
//		JLabel Ecuries = new JLabel("Ecuries");
//		Ecuries.setHorizontalAlignment(JLabel.CENTER);
//		Ecuries.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_Ecuries = new GridBagConstraints();
//		gbc_Ecuries.fill = GridBagConstraints.BOTH;
//		gbc_Ecuries.insets = new Insets(0, 0, 5, 5);
//		gbc_Ecuries.gridx = 1;
//		gbc_Ecuries.gridy = 0;
//		panel.add(Ecuries, gbc_Ecuries);
//		
//		JLabel Tournois = new JLabel("Tournois");
//		Tournois.setHorizontalAlignment(JLabel.CENTER);
//		Tournois.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_Tournois = new GridBagConstraints();
//		gbc_Tournois.fill = GridBagConstraints.BOTH;
//		gbc_Tournois.insets = new Insets(0, 0, 5, 0);
//		gbc_Tournois.gridx = 2;
//		gbc_Tournois.gridy = 0;
//		panel.add(Tournois, gbc_Tournois);
//		
//		JScrollPane EquipesList = new JScrollPane();
//		EquipesList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		GridBagConstraints gbc_EquipesList = new GridBagConstraints();
//		gbc_EquipesList.fill = GridBagConstraints.BOTH;
//		gbc_EquipesList.insets = new Insets(0, 0, 5, 5);
//		gbc_EquipesList.gridx = 0;
//		gbc_EquipesList.gridy = 1;
//		panel.add(EquipesList, gbc_EquipesList);
//		
//		JScrollPane EcuriesList = new JScrollPane();
//		EcuriesList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		GridBagConstraints gbc_EcuriesList = new GridBagConstraints();
//		gbc_EcuriesList.fill = GridBagConstraints.BOTH;
//		gbc_EcuriesList.insets = new Insets(0, 0, 5, 5);
//		gbc_EcuriesList.gridx = 1;
//		gbc_EcuriesList.gridy = 1;
//		panel.add(EcuriesList, gbc_EcuriesList);
//		
//		JScrollPane TournoisList = new JScrollPane();
//		TournoisList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		GridBagConstraints gbc_TournoisList = new GridBagConstraints();
//		gbc_TournoisList.insets = new Insets(0, 0, 5, 0);
//		gbc_TournoisList.fill = GridBagConstraints.BOTH;
//		gbc_TournoisList.gridx = 2;
//		gbc_TournoisList.gridy = 1;
//		panel.add(TournoisList, gbc_TournoisList);
//		
//		Button AddEquipesButton = new Button("Ajouter Equipe");
//		AddEquipesButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_AddEquipesButton = new GridBagConstraints();
//		gbc_AddEquipesButton.insets = new Insets(0, 0, 5, 5);
//		gbc_AddEquipesButton.gridx = 0;
//		gbc_AddEquipesButton.gridy = 2;
//		panel.add(AddEquipesButton, gbc_AddEquipesButton);
//		
//		Button AddEcuriesButton = new Button("Ajouter Ecurie");
//		AddEcuriesButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_AddEcuriesButton = new GridBagConstraints();
//		gbc_AddEcuriesButton.insets = new Insets(0, 0, 5, 5);
//		gbc_AddEcuriesButton.gridx = 1;
//		gbc_AddEcuriesButton.gridy = 2;
//		panel.add(AddEcuriesButton, gbc_AddEcuriesButton);
//		
//		Button AddTournoiButton = new Button("Ajouter Tournoi");
//		AddTournoiButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		GridBagConstraints gbc_AddTournoiButton = new GridBagConstraints();
//		gbc_AddTournoiButton.insets = new Insets(0, 0, 5, 0);
//		gbc_AddTournoiButton.gridx = 2;
//		gbc_AddTournoiButton.gridy = 2;
//		panel.add(AddTournoiButton, gbc_AddTournoiButton);
//	}
}
