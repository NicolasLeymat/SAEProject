package IHM.info;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import controleur.ControleurAdd;
import controleur.ControleurJList;
import controleur.ControleurModif;
import controleur.ModeleESporter;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VueInfoPanel extends JPanel{

	private static JList<Equipe> list = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipe = new DefaultListModel<>();
	private static JList<Joueur> listJ = new JList<>();
	private static DefaultListModel<Joueur> modeleJoueur = new DefaultListModel<>();
	private static Equipe e;
	private static Ecurie ec;
	private int classementCurrentEquipe;
	
	

	/**
	 * @wbp.parser.constructor
	 */
	public VueInfoPanel(Equipe e) {
		modeleJoueur.clear();
		this.e = null;
		this.e = e; 
		ControleurAdd c = new ControleurAdd(this, e);
		ControleurModif cm = new ControleurModif(e, this);
		this.setSize(600, 450);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 258, 0};
		gridBagLayout.rowHeights = new int[]{300, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		String nom = "Nom Equipe : " + e.getNom();
		
		JPanel panelInfo0 = new JPanel();
		panelInfo0.setLayout(null);
		GridBagConstraints gbc_panelInfo0 = new GridBagConstraints();
		gbc_panelInfo0.fill = GridBagConstraints.BOTH;
		gbc_panelInfo0.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfo0.gridx = 0;
		gbc_panelInfo0.gridy = 0;
		add(panelInfo0, gbc_panelInfo0);

		JLabel ecurieLabel = new JLabel(e.getNom());
		ecurieLabel.setBounds(0, 21, 159, 22);
		panelInfo0.add(ecurieLabel);
		ecurieLabel.setVerticalAlignment(SwingConstants.TOP);
		ecurieLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Nom Ecurie : ");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 0, 159, 13);
		panelInfo0.add(lblNewLabel_1);
		
		JPanel panelInfo1 = new JPanel();
		panelInfo1.setLayout(null);
		GridBagConstraints gbc_panelInfo1 = new GridBagConstraints();
		gbc_panelInfo1.fill = GridBagConstraints.BOTH;
		gbc_panelInfo1.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfo1.gridx = 1;
		gbc_panelInfo1.gridy = 0;
		add(panelInfo1, gbc_panelInfo1);
		JLabel lblNewLabel = new JLabel(e.getNom());
		lblNewLabel.setBounds(0, 20, 158, 17);
		panelInfo1.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Nom Equipe : ");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(0, 0, 158, 13);
		panelInfo1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Classement : ");
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(0, 47, 160, 13);
		panelInfo1.add(lblNewLabel_4);
		
		
		List<Equipe> classement = Equipe.getClassementByGame(e.getIdModeDeJeu());
		for(int i = 0; i<classement.size(); i++) {
			if(classement.get(i).getId() == e.getId()) {
				classementCurrentEquipe = i;
			}
		}
		JLabel lblNewLabel_5 = new JLabel(""+classementCurrentEquipe + "/" + classement.size());
		lblNewLabel_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(0, 70, 160, 13);
		panelInfo1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Points :");
		lblNewLabel_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(0, 93, 160, 13);
		panelInfo1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(e.getPoints()+"");
		lblNewLabel_7.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(0, 113, 158, 13);
		panelInfo1.add(lblNewLabel_7);
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setLayout(null);
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.insets = new Insets(0, 0, 5, 0);
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		add(panelJoueur, gbc_panelJoueur);
		
		
		modeleJoueur.addAll(e.getJoueurs());
		System.out.println("--------------------------------------------------\n"+e.getJoueurs());
		listJ.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		listJ.setModel(modeleJoueur);
		JScrollPane scrollPane = new JScrollPane(listJ);
		scrollPane.setBounds(0, 36, 272, 264);
		panelJoueur.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Liste des joueurs : ");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(0, 0, 272, 35);
		panelJoueur.add(lblNewLabel_3);
		
		JButton addPlayer = new JButton("Ajouter un joueur");
		addPlayer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		addPlayer.setBounds(35, 311, 200, 25);
		addPlayer.addActionListener(c);
		panelJoueur.add(addPlayer);
		
		JButton deletePlayer = new JButton("Supprimer un joueur");
		deletePlayer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		deletePlayer.setBounds(35, 347, 200, 25);
		panelJoueur.add(deletePlayer);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(null);
		GridBagConstraints gbc_panelBtn = new GridBagConstraints();
		gbc_panelBtn.gridwidth = 3;
		gbc_panelBtn.insets = new Insets(0, 0, 0, 5);
		gbc_panelBtn.fill = GridBagConstraints.BOTH;
		gbc_panelBtn.gridx = 0;
		gbc_panelBtn.gridy = 1;
		add(panelBtn, gbc_panelBtn);
		
		JButton modfier = new JButton("Modifier");
		modfier.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modfier.setBounds(390, 0, 200, 50);
		modfier.addActionListener(cm);
		panelBtn.add(modfier);
		
		JButton add_To_Tournament = new JButton("Ajouter à un tournoi");
		add_To_Tournament.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		add_To_Tournament.setBounds(10, 0, 200, 50);
		panelBtn.add(add_To_Tournament);
		
		
	}


	public VueInfoPanel(Ecurie e) {
		modeleEquipe.clear();
		this.ec = null;
		this.ec = e;
		this.setSize(600, 400);
		ControleurAdd c = new ControleurAdd(this, e);
		ControleurModif cm = new ControleurModif(e, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 258, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
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
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		
		ControleurJList controleur = new ControleurJList();
		modeleEquipe.addAll(e.getEquipes());
		list.setModel(modeleEquipe);
		list.addMouseListener(controleur);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.addMouseListener(controleur);
		scrollPane.setSize(200, 300);
		scrollPane.setBounds(0, 50, 272, 200);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Listes des équipes :");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 0, 200, 51);
		panel_2.add(lblNewLabel);
		
		JButton addTeam = new JButton("Ajouter une équipe");
		addTeam.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		addTeam.setBounds(35, 261, 200, 25);
		addTeam.addActionListener(c);
		panel_2.add(addTeam);
		
		JButton deleteTeam = new JButton("Supprimer une équipe");
		deleteTeam.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		deleteTeam.setBounds(35, 297, 200, 25);
		panel_2.add(deleteTeam);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		
		JButton modfier = new JButton("Modifier");
		modfier.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modfier.setBounds(390, 0, 200, 50);
		modfier.addActionListener(cm);
		panel_3.add(modfier);
	}

	public static void updateListJoueur() {
		modeleJoueur.clear();
		e = Equipe.getEquipeFromId(e.getId());
		modeleJoueur.addAll(e.getJoueurs());
		listJ.setModel(modeleJoueur);
	}
	
	public static void updateListEquipe() {
		modeleEquipe.clear();
		ec = Ecurie.getEcurieFromId(ec.getId());
		modeleEquipe.addAll(ec.getEquipes());
		listJ.setModel(modeleJoueur);
	}
}
