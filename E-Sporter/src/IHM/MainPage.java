package IHM;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(1186, 663);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{395, 395, 395, 0};
		gbl_panel.rowHeights = new int[] {100, 500, 100};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel EquipesName = new JLabel("Equipes");
		EquipesName.setHorizontalAlignment(JLabel.CENTER);
		EquipesName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_EquipesName = new GridBagConstraints();
		gbc_EquipesName.fill = GridBagConstraints.HORIZONTAL;
		gbc_EquipesName.insets = new Insets(0, 0, 5, 5);
		gbc_EquipesName.gridx = 0;
		gbc_EquipesName.gridy = 0;
		panel.add(EquipesName, gbc_EquipesName);
		
		JLabel Ecuries = new JLabel("Ecuries");
		Ecuries.setHorizontalAlignment(JLabel.CENTER);
		Ecuries.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_Ecuries = new GridBagConstraints();
		gbc_Ecuries.fill = GridBagConstraints.BOTH;
		gbc_Ecuries.insets = new Insets(0, 0, 5, 5);
		gbc_Ecuries.gridx = 1;
		gbc_Ecuries.gridy = 0;
		panel.add(Ecuries, gbc_Ecuries);
		
		JLabel Tournois = new JLabel("Tournois");
		Tournois.setHorizontalAlignment(JLabel.CENTER);
		Tournois.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_Tournois = new GridBagConstraints();
		gbc_Tournois.fill = GridBagConstraints.BOTH;
		gbc_Tournois.insets = new Insets(0, 0, 5, 0);
		gbc_Tournois.gridx = 2;
		gbc_Tournois.gridy = 0;
		panel.add(Tournois, gbc_Tournois);
		
		JScrollPane EquipesList = new JScrollPane();
		EquipesList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_EquipesList = new GridBagConstraints();
		gbc_EquipesList.fill = GridBagConstraints.BOTH;
		gbc_EquipesList.insets = new Insets(0, 0, 5, 5);
		gbc_EquipesList.gridx = 0;
		gbc_EquipesList.gridy = 1;
		panel.add(EquipesList, gbc_EquipesList);
		
		JScrollPane EcuriesList = new JScrollPane();
		EcuriesList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_EcuriesList = new GridBagConstraints();
		gbc_EcuriesList.fill = GridBagConstraints.BOTH;
		gbc_EcuriesList.insets = new Insets(0, 0, 5, 5);
		gbc_EcuriesList.gridx = 1;
		gbc_EcuriesList.gridy = 1;
		panel.add(EcuriesList, gbc_EcuriesList);
		
		JScrollPane TournoisList = new JScrollPane();
		TournoisList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_TournoisList = new GridBagConstraints();
		gbc_TournoisList.insets = new Insets(0, 0, 5, 0);
		gbc_TournoisList.fill = GridBagConstraints.BOTH;
		gbc_TournoisList.gridx = 2;
		gbc_TournoisList.gridy = 1;
		panel.add(TournoisList, gbc_TournoisList);
		
		Button button = new Button("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 2;
		panel.add(button, gbc_button);
		
		Button button_1 = new Button("Ajouter");
		button_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 2;
		panel.add(button_1, gbc_button_1);
		
		Button button_2 = new Button("Ajouter");
		button_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 2;
		panel.add(button_2, gbc_button_2);
	}
	
	public JFrame getframe() {
		return this.frame;
	}
}
