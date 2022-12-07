package IHM.info;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import controleur.JListControler;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ViewInfoPanel extends JPanel{

	JList<Equipe> list = new JList<>();
	DefaultListModel<Equipe> modeleEquipe = new DefaultListModel<>();
	JList<Joueur> listJ = new JList<>();
	DefaultListModel<Joueur> modeleJoueur = new DefaultListModel<>();
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public ViewInfoPanel(Equipe e) {
		this.setSize(600, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 258, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		String nom = "Nom Equipe : " + e.getNom();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel ecurieLabel = new JLabel(e.getNom());
		ecurieLabel.setBounds(0, 21, 159, 22);
		panel.add(ecurieLabel);
		ecurieLabel.setVerticalAlignment(SwingConstants.TOP);
		ecurieLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nom Ecurie : ");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 0, 159, 13);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		JLabel lblNewLabel = new JLabel(e.getNom());
		lblNewLabel.setBounds(0, 20, 158, 17);
		panel_1.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Nom Equipe : ");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 158, 13);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		listJ.setModel(modeleJoueur);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 36, 272, 264);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Liste des joueurs : ");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(0, 0, 272, 35);
		panel_2.add(lblNewLabel_3);
		
		JButton AddPlayer = new JButton("Ajouter un joueur");
		AddPlayer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		AddPlayer.setBounds(49, 311, 160, 25);
		panel_2.add(AddPlayer);
		
		JButton DeletePlayer = new JButton("Supprimer un joueur");
		DeletePlayer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		DeletePlayer.setBounds(49, 350, 160, 25);
		panel_2.add(DeletePlayer);
		
		modeleJoueur.addAll(e.getJoueurs());
	}
	
	public ViewInfoPanel(Ecurie e) {
		this.setSize(600, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 258, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Ecurie : ");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 10, 145, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel nomEcurie = new JLabel(e.getNom());
		nomEcurie.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		nomEcurie.setBounds(0, 35, 145, 13);
		panel_1.add(nomEcurie);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		
		JListControler controleur = new JListControler();
		modeleEquipe.addAll(e.getEquipes());
		list.setModel(modeleEquipe);
		list.addMouseListener(controleur);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.addMouseListener(controleur);
		scrollPane.setSize(200, 300);
		scrollPane.setBounds(0, 50, 302, 250);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Listes des équipes :");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 200, 51);
		panel_2.add(lblNewLabel);
	}
}
