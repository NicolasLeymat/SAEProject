package IHM.info;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;
import controleur.ControleurAddFrame;
import controleur.ControleurDelete;
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

import javax.swing.JButton;

public class VueInfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JList<Equipe> listEquipe = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipe = new DefaultListModel<>();
	private static JList<Joueur> listJoueur = new JList<>();
	private static DefaultListModel<Joueur> modeleJoueur = new DefaultListModel<>();
	private static Equipe equipe;
	private static Ecurie ecurie;
	private static Tournoi tournoi;
	private static Joueur joueur;
	private static JLabel nameLbl;
	private int classementCurrentEquipe;
	private static JLabel labelNomEcurie;
	private static JLabel nomTournoi;
	private static JLabel nomJoueur;
	private static JLabel prenomJoueur;
	private static JLabel pseudoJoueur;
	private static JLabel nationaliteJoueur;
	


	public VueInfoPanel(Equipe equipe) {
		modeleJoueur.clear();
		VueInfoPanel.equipe = equipe;
		ControleurAddFrame c = new ControleurAddFrame(equipe);
		ControleurModif cm = new ControleurModif(equipe, this);
		ControleurDelete cd = new ControleurDelete(equipe, this);
		this.setSize(750, 450);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{258, 200, 258, 0};
		gridBagLayout.rowHeights = new int[]{381, 70, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		String nom = "Nom Equipe : " + equipe.getNom();
		
		JPanel panelInfo0 = new JPanel();
		panelInfo0.setLayout(null);
		GridBagConstraints gbc_panelInfo0 = new GridBagConstraints();
		gbc_panelInfo0.fill = GridBagConstraints.BOTH;
		gbc_panelInfo0.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfo0.gridx = 0;
		gbc_panelInfo0.gridy = 0;
		add(panelInfo0, gbc_panelInfo0);

		JLabel lblNewLabel_1 = new JLabel("Nom Ecurie : ");
		lblNewLabel_1.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_1.setBounds(10, 0, 159, 13);
		panelInfo0.add(lblNewLabel_1);
		
		JLabel ecurieLabel = new JLabel(equipe.getEcurie().getNom());
		ecurieLabel.setBounds(10, 23, 159, 22);
		panelInfo0.add(ecurieLabel);
		ecurieLabel.setVerticalAlignment(SwingConstants.TOP);
		ecurieLabel.setFont(ModeleESporter.FONT_MEDIUM);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(equipe.getLogo());
		lblNewLabel_8.setBounds(10, 73, 258, 258);
		panelInfo0.add(lblNewLabel_8);
		
		
		JPanel panelInfo1 = new JPanel();
		panelInfo1.setLayout(null);
		GridBagConstraints gbc_panelInfo1 = new GridBagConstraints();
		gbc_panelInfo1.fill = GridBagConstraints.BOTH;
		gbc_panelInfo1.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfo1.gridx = 1;
		gbc_panelInfo1.gridy = 0;
		add(panelInfo1, gbc_panelInfo1);
		
		nameLbl = new JLabel(equipe.getNom());
		nameLbl.setBounds(10, 20, 158, 17);
		panelInfo1.add(nameLbl);
		nameLbl.setVerticalAlignment(SwingConstants.TOP);
		nameLbl.setFont(ModeleESporter.FONT_MEDIUM);
		
		JLabel lblNewLabel_2 = new JLabel("Nom Equipe : ");
		lblNewLabel_2.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_2.setBounds(10, 0, 158, 13);
		panelInfo1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Classement : ");
		lblNewLabel_4.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_4.setBounds(10, 47, 160, 13);
		panelInfo1.add(lblNewLabel_4);
		
		
		List<Equipe> classement = Equipe.getClassementByGame(equipe.getIdModeDeJeu());
		for(int i = 0; i<classement.size(); i++) {
			if(classement.get(i).getId() == equipe.getId()) {
				classementCurrentEquipe = i;
			}
		}
		JLabel lblNewLabel_5 = new JLabel(""+classementCurrentEquipe + "/" + classement.size());
		lblNewLabel_5.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_5.setBounds(10, 70, 160, 13);
		panelInfo1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Points :");
		lblNewLabel_6.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_6.setBounds(10, 93, 160, 13);
		panelInfo1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(equipe.getPoints()+"");
		lblNewLabel_7.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_7.setBounds(10, 113, 158, 13);
		panelInfo1.add(lblNewLabel_7);
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setLayout(null);
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.insets = new Insets(0, 0, 5, 0);
		gbc_panelJoueur.fill = GridBagConstraints.BOTH;
		gbc_panelJoueur.gridx = 2;
		gbc_panelJoueur.gridy = 0;
		add(panelJoueur, gbc_panelJoueur);
		
		ControleurJList controleur = new ControleurJList();
		modeleJoueur.addAll(equipe.getJoueurs());
		//Solution pour ne pas dupliquer les listeners
		listJoueur = new JList<>();
		//
		listJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		listJoueur.setModel(modeleJoueur);
		JScrollPane scrollPane = new JScrollPane(listJoueur);

		listJoueur.addMouseListener(controleur);
		
		scrollPane.setBounds(0, 36, 272, 264);
		panelJoueur.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Liste des joueurs : ");
		lblNewLabel_3.setFont(ModeleESporter.FONT_MEDIUM);
		lblNewLabel_3.setBounds(0, 0, 272, 35);
		panelJoueur.add(lblNewLabel_3);
		
		JButton addPlayer = new JButton("Ajouter un joueur");
		addPlayer.setFont(ModeleESporter.FONT_MEDIUM);
		addPlayer.setBounds(35, 311, 200, 25);
		addPlayer.addActionListener(c);
		panelJoueur.add(addPlayer);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton modfier_1 = new JButton("Modifier");
		modfier_1.setBounds(52, 10, 175, 50);
		modfier_1.setFont(ModeleESporter.FONT_MEDIUM);
		modfier_1.addActionListener(cm);
		panel.add(modfier_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		JButton delete = new JButton("Supprimer");
		delete.setBounds(52, 10, 175, 50);
		delete.addActionListener(cd);
		panel_1.add(delete);
		delete.setFont(ModeleESporter.FONT_MEDIUM);
		
		
	}


	/**
	 * Panel d'information d'une equipe
	 *
	 * @param equipe L'ecurie
	 */
	public VueInfoPanel(Ecurie equipe) {
		modeleEquipe.clear();
		VueInfoPanel.ecurie = null;
		VueInfoPanel.ecurie = equipe;
		this.setSize(500, 400);
		ControleurAddFrame c = new ControleurAddFrame(equipe);
		ControleurModif cm = new ControleurModif(equipe, this);
		ControleurDelete cd = new ControleurDelete(equipe, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 258, 0};
		gridBagLayout.rowHeights = new int[]{0, 70, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JLabel labelNomEcurie = new JLabel("Nom Ecurie : ");
		labelNomEcurie.setFont(ModeleESporter.FONT_MEDIUM);
		labelNomEcurie.setBounds(0, 10, 145, 17);
		panel_1.add(labelNomEcurie);
		
		VueInfoPanel.labelNomEcurie = new JLabel(equipe.getNom());
		VueInfoPanel.labelNomEcurie.setFont(ModeleESporter.FONT_MEDIUM);
		VueInfoPanel.labelNomEcurie.setBounds(0, 35, 145, 13);
		panel_1.add(VueInfoPanel.labelNomEcurie);
		
		JPanel panelListes = new JPanel();
		panelListes.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		add(panelListes, gbc_panel_2);
		
		ControleurJList controleur = new ControleurJList();
		modeleEquipe.addAll(equipe.getEquipes());
		//
		listEquipe = new JList<>();
		//
		listEquipe.setModel(modeleEquipe);
		listEquipe.addMouseListener(controleur);
		JScrollPane scrollPane = new JScrollPane(listEquipe);
		scrollPane.addMouseListener(controleur);
		scrollPane.setSize(200, 300);
		scrollPane.setBounds(0, 50, 272, 200);
		panelListes.add(scrollPane);
		
		JLabel labelListeEquipe = new JLabel("Listes des équipes :");
		labelListeEquipe.setFont(ModeleESporter.FONT_MEDIUM);
		labelListeEquipe.setBounds(0, 0, 200, 51);
		panelListes.add(labelListeEquipe);
		
		JButton addTeam = new JButton("Ajouter une équipe");
		addTeam.setFont(ModeleESporter.FONT_MEDIUM);
		addTeam.setBounds(35, 261, 200, 25);
		addTeam.addActionListener(c);
		panelListes.add(addTeam);
		
		JPanel panelAjoutSuppression = new JPanel();
		panelAjoutSuppression.setLayout(null);
		GridBagConstraints gbcPanelAjoutSuppression = new GridBagConstraints();
		gbcPanelAjoutSuppression.insets = new Insets(0, 0, 0, 5);
		gbcPanelAjoutSuppression.fill = GridBagConstraints.BOTH;
		gbcPanelAjoutSuppression.gridx = 0;
		gbcPanelAjoutSuppression.gridy = 1;
		add(panelAjoutSuppression, gbcPanelAjoutSuppression);
		
		JButton delete = new JButton("Supprimer");
		delete.setBounds(20, 10, 150, 50);
		delete.setFont(ModeleESporter.FONT_MEDIUM);
		delete.addActionListener(cd);
		panelAjoutSuppression.add(delete);
		
		JPanel panelModification = new JPanel();
		panelModification.setLayout(null);
		GridBagConstraints gbcPanelModification = new GridBagConstraints();
		gbcPanelModification.fill = GridBagConstraints.BOTH;
		gbcPanelModification.gridx = 1;
		gbcPanelModification.gridy = 1;
		add(panelModification, gbcPanelModification);
		
		JButton modfier = new JButton("Modifier");
		modfier.setFont(ModeleESporter.FONT_MEDIUM);
		modfier.setBounds(62, 10, 200, 50);
		modfier.addActionListener(cm);
		panelModification.add(modfier);
	}

	/**
	 * Panel d'informations d'un tournoi
	 * @param t le tournoi
	 */
	public VueInfoPanel(Tournoi t) {
		modeleEquipe.clear();
		VueInfoPanel.tournoi = null;
		VueInfoPanel.tournoi = t;
		this.setSize(750, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 258, 0};
		gridBagLayout.rowHeights = new int[]{0, 70, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JLabel lblNom = new JLabel("Nom Tournoi : ");
		lblNom.setFont(ModeleESporter.FONT_MEDIUM);
		lblNom.setBounds(0, 10, 145, 17);
		panel_1.add(lblNom);
		
		nomTournoi = new JLabel(t.getNom());
		nomTournoi.setFont(ModeleESporter.FONT_MEDIUM);
		nomTournoi.setBounds(0, 35, 145, 13);
		panel_1.add(nomTournoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		
		
		
		
	}

	/**
	 * Panel d'informations sur un joueur
	 * @param joueur
	 */
	public VueInfoPanel(Joueur joueur) {
		VueInfoPanel.joueur = joueur;
		this.setSize(750, 400);
		ControleurModif cm = new ControleurModif(joueur, this);
		ControleurDelete cd = new ControleurDelete(joueur, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 258, 0};
		gridBagLayout.rowHeights = new int[]{0, 70, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelListe = new JPanel();
		panelListe.setLayout(null);
		GridBagConstraints gbcPanelListe = new GridBagConstraints();
		gbcPanelListe.insets = new Insets(0, 0, 5, 5);
		gbcPanelListe.fill = GridBagConstraints.BOTH;
		gbcPanelListe.gridx = 0;
		gbcPanelListe.gridy = 0;
		add(panelListe, gbcPanelListe);
		
		JLabel lblNom = new JLabel("Nom Joueur : ");
		lblNom.setFont(ModeleESporter.FONT_MEDIUM);
		lblNom.setBounds(0, 10, 145, 17);
		panelListe.add(lblNom);
		
		nomJoueur = new JLabel(joueur.getNom());
		nomJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		nomJoueur.setBounds(0, 35, 145, 13);
		panelListe.add(nomJoueur);
	
		
		JPanel panelDroite = new JPanel();
		panelDroite.setLayout(null);
		GridBagConstraints gbcPanelDroite = new GridBagConstraints();
		gbcPanelDroite.insets = new Insets(0, 0, 5, 0);
		gbcPanelDroite.fill = GridBagConstraints.BOTH;
		gbcPanelDroite.gridx = 1;
		gbcPanelDroite.gridy = 0;
		add(panelDroite, gbcPanelDroite);
		
		JLabel prenomJoueurLabel = new JLabel("Prénom Joueur : ");
		prenomJoueurLabel.setFont(ModeleESporter.FONT_MEDIUM);
		prenomJoueurLabel.setBounds(0, 10, 145, 20);
		panelDroite.add(prenomJoueurLabel);
		
		prenomJoueur = new JLabel(joueur.getPrenom());
		prenomJoueur.setBounds(0, 35, 145, 20);
		panelDroite.add(prenomJoueur);
		prenomJoueur.setVerticalAlignment(SwingConstants.TOP);
		prenomJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		
		
		JLabel pseudoJoueurLabel= new JLabel("Pseudonyme Joueur : ");
		pseudoJoueurLabel.setFont(ModeleESporter.FONT_MEDIUM);
		pseudoJoueurLabel.setBounds(0, 60, 145, 20);
		panelListe.add(pseudoJoueurLabel);
		
		pseudoJoueur = new JLabel(joueur.getPseudo());
		pseudoJoueur.setBounds(0, 85, 145, 20);
		panelListe.add(pseudoJoueur);
		pseudoJoueur.setVerticalAlignment(SwingConstants.TOP);
		pseudoJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		
		JLabel dateJoueurLabel= new JLabel("Date de naissance Joueur : ");
		dateJoueurLabel.setFont(ModeleESporter.FONT_MEDIUM);
		dateJoueurLabel.setBounds(0, 60, 200, 20);
		panelDroite.add(dateJoueurLabel);
		
		JLabel dateJoueur = new JLabel(joueur.getDateNaissance());
		dateJoueur.setBounds(0, 85, 145, 20);
		panelDroite.add(dateJoueur);
		dateJoueur.setVerticalAlignment(SwingConstants.TOP);
		dateJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		
		JLabel nationaliteJoueurLabel= new JLabel("Pays de Naissance Joueur : ");
		nationaliteJoueurLabel.setFont(ModeleESporter.FONT_MEDIUM);
		nationaliteJoueurLabel.setBounds(0, 110, 200, 20);
		panelListe.add(nationaliteJoueurLabel);
		
		nationaliteJoueur = new JLabel(joueur.getNationalite().getNom());
		nationaliteJoueur.setBounds(0, 135, 145, 20);
		panelListe.add(nationaliteJoueur);
		nationaliteJoueur.setVerticalAlignment(SwingConstants.TOP);
		nationaliteJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		
		JLabel equipeJoueurLabel= new JLabel("Equipe Joueur : ");
		equipeJoueurLabel.setFont(ModeleESporter.FONT_MEDIUM);
		equipeJoueurLabel.setBounds(0, 110, 200, 20);
		panelDroite.add(equipeJoueurLabel);
		
		JLabel equipeJoueur = new JLabel(Equipe.getNomEquipeFromId(joueur.getIdEquipe()));
		equipeJoueur.setBounds(0, 135, 200, 20);
		panelDroite.add(equipeJoueur);
		equipeJoueur.setVerticalAlignment(SwingConstants.TOP);
		equipeJoueur.setFont(ModeleESporter.FONT_MEDIUM);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(null);
		
		JButton modfier_1 = new JButton("Modifier");
		modfier_1.setBounds(10, 10, 200, 50);
		modfier_1.setFont(ModeleESporter.FONT_MEDIUM);
		modfier_1.addActionListener(cm);
		panel.add(modfier_1);
		
		JButton supprimer = new JButton("Supprimer");
		panel.add(supprimer);
		supprimer.setBounds(290, 10, 200, 50);
		supprimer.addActionListener(cd);
		supprimer.setFont(ModeleESporter.FONT_MEDIUM);
		
		///
		
		///
	}

	public static void updateListJoueur() {
		modeleJoueur.clear();
		equipe = Equipe.getEquipeFromId(equipe.getId());
		modeleJoueur.addAll(equipe.getJoueurs());
		listJoueur.setModel(modeleJoueur);
	}
	
	public static void updateListEquipe() {
		modeleEquipe.clear();
		ecurie = Ecurie.getEcurieFromId(ecurie.getId());
		modeleEquipe.addAll(ecurie.getEquipes());
		System.out.println(ecurie.getEquipes());
		listEquipe.setModel(modeleEquipe);
	}
	
	public static void updateInfoEquipe(String nom) {
		nameLbl.setText(nom);
	}
	
	public static void updateInfoEcurie(String nom) {
		labelNomEcurie.setText(nom);
	}

	public static void updateInfoJoueur(Joueur j) {
		nomJoueur.setText(j.getNom());
		prenomJoueur.setText(j.getPrenom());
		pseudoJoueur.setText(j.getPseudo());
		nationaliteJoueur.setText(j.getNationalite().getNom());
		
	}
}
