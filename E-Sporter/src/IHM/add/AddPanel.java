package IHM.add;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.ModeDeJeu;
import Object.Nationalite;
import Object.Tournoi;
import Object.Tournoi.EtatTournoi;
import controleur.ControleurAddPanel;
import controleur.ModeleESporter;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AddPanel extends JPanel {

	//Variables de classe
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 450;
	private final int HEIGHT = 500;
	
	
	//Variable générale
	private JTextField NameTF;
	private String mode;
	
	//Variable joueur
	private JTextField firstNameTF;
	private JTextField pseudoTF;
	private JFormattedTextField brithDateTF;
	private JComboBox<String> natChoice;
	private Object obj;
	
	//Variable tournoi
	private JComboBox<String> comboChamp;
	private JComboBox<Tournoi.Notoriete> comboNotoriete;
	private JTextField orgaTf;
	private JComboBox<String> comboBox;
	private JButton confirmBtn;
	private JTextField textField;
	
	private Object obj2;
	private static Ecurie oldEc;
	
	public AddPanel(String type, Object obj, Object obj2) {
		ControleurAddPanel c = new ControleurAddPanel(this);
		this.obj = obj;
		this.obj2 = obj2;
		this.setMode(type);
		this.setSize(WIDTH, HEIGHT);
		
		//création du layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{430, 75, 0};
		gridBagLayout.columnWeights = new double[]{2.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//pannel principal
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		GridBagConstraints gbc_MainPanel = new GridBagConstraints();
		gbc_MainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_MainPanel.fill = GridBagConstraints.BOTH;
		gbc_MainPanel.gridx = 0;
		gbc_MainPanel.gridy = 0;
		add(MainPanel, gbc_MainPanel);
		
		// label du titre
		JLabel Title = new JLabel("");
		Title.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		Title.setBounds(125, 0, 200, 25);
		MainPanel.add(Title);
		
		// label du nom
		JLabel nameLabel = new JLabel("Nom  :");
		nameLabel.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		nameLabel.setBounds(10, 53, 80, 20);
		
		// champ de texte du nom
		NameTF = new JTextField();
		NameTF.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		NameTF.setBounds(140, 53, 150, 20);
		NameTF.setColumns(10);
		
		// label du prénom
		JLabel lblPrenom = new JLabel("Prenom  :");
		lblPrenom.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblPrenom.setBounds(10, 78, 80, 20);
		
		// champ de texte du prénom
		firstNameTF = new JTextField();
		firstNameTF.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		firstNameTF.setColumns(10);
		firstNameTF.setBounds(140, 81, 150, 20);
		
		//label du pseudonyme
		JLabel lblPseudonyme = new JLabel("Pseudonyme  :");
		lblPseudonyme.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblPseudonyme.setBounds(10, 108, 91, 20);
		
		// champ de texte du pseudo
		pseudoTF = new JTextField();
		pseudoTF.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		pseudoTF.setColumns(10);
		pseudoTF.setBounds(140, 109, 150, 20);
		
		
		// création du panel des boutons
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(null);
		GridBagConstraints gbc_BtnPanel = new GridBagConstraints();
		gbc_BtnPanel.insets = new Insets(0, 0, 5, 0);
		gbc_BtnPanel.fill = GridBagConstraints.BOTH;
		gbc_BtnPanel.gridx = 0;
		gbc_BtnPanel.gridy = 1;
		add(BtnPanel, gbc_BtnPanel);
		
		// bouton confirmer
		confirmBtn = new JButton("Confirmer");
		confirmBtn.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		confirmBtn.setBounds(230, 10, 200, 50);
		confirmBtn.addActionListener(c);
		BtnPanel.add(confirmBtn);
		
		// label nationalités
		JLabel lblNat = new JLabel("Nationalités : ");
		lblNat.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblNat.setBounds(10, 138, 120, 20);
		
		// création de la boite combinée
		DefaultComboBoxModel<String> modelNat = new DefaultComboBoxModel<>(ModeleESporter.getAllNat()); 
		natChoice = new JComboBox<>();
		natChoice.setModel(modelNat);
		natChoice.setBounds(140, 140, 150, 22);
		
		// label de la date de naissance
		JLabel lblDate = new JLabel("Date de Naissance : ");
		lblDate.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblDate.setBounds(12, 168, 125, 22);
		
		// mise en forme de la date
		brithDateTF = new JFormattedTextField();
		try {
			MaskFormatter formatter = new MaskFormatter("##/##/####");
			formatter.setPlaceholderCharacter('#');
			 brithDateTF = new JFormattedTextField(formatter);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		brithDateTF.setToolTipText("##/##/####");
		brithDateTF.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		brithDateTF.setBounds(140, 171, 150, 22);
		
		//ajout aua pannel principal
		MainPanel.add(nameLabel);
		MainPanel.add(NameTF);
		
		JLabel lblMode = new JLabel("Mode de jeu :");
		lblMode.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblMode.setBounds(10, 85, 120, 20);
		
		DefaultComboBoxModel<String> modeModel = new DefaultComboBoxModel<>(ModeleESporter.getAllModeName());
		comboBox = new JComboBox<>(modeModel);
		comboBox.setBounds(140, 85, 150, 25);
		
		DefaultComboBoxModel<Tournoi.Notoriete> notorieteModel = new DefaultComboBoxModel<>(Tournoi.Notoriete.values());
		comboNotoriete = new JComboBox<>(notorieteModel);
		comboNotoriete.setBounds(140, 152, 150, 25);
		
		JLabel lblNotorit = new JLabel("Notoriété : ");
		lblNotorit.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblNotorit.setBounds(12, 152, 125, 20);
		
		String[] value = new String[2];
		value[1] = "Oui";
		value[0] = "Non";
		DefaultComboBoxModel<String> champModel = new DefaultComboBoxModel<>(value);
		comboChamp = new JComboBox<String>(champModel);
		comboChamp.setBounds(140, 192, 150, 25);
		
		JLabel lblChampionnat = new JLabel("Championnat : ");
		lblChampionnat.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblChampionnat.setBounds(12, 192, 125, 20);
		
		orgaTf = new JTextField();
		orgaTf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		orgaTf.setColumns(10);
		orgaTf.setBounds(140, 229, 150, 20);
		
		JLabel lblNomOrganisateur = new JLabel("Organisateur  :");
		lblNomOrganisateur.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblNomOrganisateur.setBounds(10, 229, 125, 20);
		
		textField = new JTextField();
		textField.setBounds(140, 120, 150, 19);
		textField.setColumns(10);
		textField.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		
		JLabel lblNewLabel = new JLabel("Lien du logo :");
		lblNewLabel.setFont(ModeleESporter.FONT_MEDIUM_LARGE);
		lblNewLabel.setBounds(10, 115, 100, 20);
	
		
		switch(type) {
			case "Player":{
				Title.setText("Ajout d'un joueur");
				MainPanel.add(lblPrenom);
				MainPanel.add(firstNameTF);
				MainPanel.add(lblPseudonyme);
				MainPanel.add(pseudoTF);
				MainPanel.add(natChoice);
				MainPanel.add(lblNat);
				MainPanel.add(lblDate);
				MainPanel.add(brithDateTF);
				break;
			}
			case "Team":{
				Title.setText("Ajout d'une équipe");
				MainPanel.add(lblMode);
				MainPanel.add(comboBox);
				MainPanel.add(lblNewLabel);
				MainPanel.add(textField);
				break;
			}
			case "Orga":{
				Title.setText("Ajout d'une écurie");
				nameLabel.setBounds(10, 70, 80, 30);
				NameTF.setBounds(140, 70, 200, 30);
				confirmBtn.setBounds(250, 10, 150, 50);
				MainPanel.add(natChoice);
				MainPanel.add(lblNat);
				break;
			}
			case "Tournament":{
				Title.setText("Ajout d'un tournoi");
				MainPanel.add(orgaTf);
				MainPanel.add(lblNomOrganisateur);
				MainPanel.add(comboNotoriete);
				MainPanel.add(lblNotorit);
				MainPanel.add(comboChamp);
				MainPanel.add(lblChampionnat);
				MainPanel.add(lblMode);
				MainPanel.add(comboBox);
				lblDate.setBounds(12, 120, 125, 20);
				lblDate.setText("Date de début : ");
				MainPanel.add(lblDate);
				brithDateTF.setBounds(140, 120, 150, 20);
				MainPanel.add(brithDateTF);
				break;
			}
			default:{
				break;
			}
		}
	}

	// renvoie le mode
	public String getMode() {
		return mode;
	}

	// met à jour le mode
	public void setMode(String mode) {
		this.mode = mode;
	}

	// fonction qui renvoie les données d'un objet
	public Object getInfoToObject() {
		
		switch (this.mode) {
			case "Player": {
				if(oldEc == null) {
					oldEc = (Ecurie) obj2;
				}
				Equipe teamToAdd = (Equipe) this.obj;
				Joueur j = new Joueur(this.NameTF.getText(), 
						this.firstNameTF.getText(), 
						this.pseudoTF.getText(), 
						this.brithDateTF.getText(), 
						Nationalite.getByNom((String) this.natChoice.getSelectedItem()));
				j.setIdEquipe(teamToAdd.getId());
				teamToAdd.addJoueur(j);
				//teamToAdd.getEcurie().replaceEquipe(teamToAdd);
				oldEc.replaceEquipe(teamToAdd);
				return j;
			}
			case "Team":{
				Ecurie ecurieToAdd = (Ecurie) this.obj;
				Equipe e = new Equipe(this.NameTF.getText());
				e.setStringLogo(textField.getText());
				e.setIdEcurie(ecurieToAdd.getId());
				e.setIdModeDeJeu(ModeDeJeu.getModeDeJeuFromNom((String)comboBox.getSelectedItem()).getIdMode());
				ecurieToAdd.addEquipe(e);
				oldEc = ecurieToAdd;
				return e;
			}
			case "Orga":{
				Ecurie ec = new Ecurie(this.NameTF.getText());
				ec.setNat(Nationalite.getByNom((String) this.natChoice.getSelectedItem()));
				return ec;
			}
			case "Tournament":{
				
				int champ = 0;
				if(this.comboChamp.getSelectedItem().equals("Oui")) {
					champ = 1;
				}
				Tournoi.Notoriete not  = (Tournoi.Notoriete)  this.comboNotoriete.getSelectedItem();
				Tournoi t = null;
				try {
					t =new Tournoi(this.NameTF.getText(), this.formattingText(), champ, not.getValue() , 0, ModeDeJeu.getModeDeJeuFromNom((String)comboBox.getSelectedItem()), EtatTournoi.INSC);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return t;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + this.mode);
		}
	}
	
	// fonction permettant de gérer le format de la date
	@SuppressWarnings("deprecation")
	private Date formattingText() {
		String textToFormat = this.brithDateTF.getText();
		String[] values = textToFormat.split("/");
		int year = Integer.parseInt(values[2]);
		//System.out.println(year);
		int month = Integer.parseInt(values[1]);
		int day = Integer.parseInt(values[0]);
		return new Date(year - 1900, month - 1, day);
	}
}
