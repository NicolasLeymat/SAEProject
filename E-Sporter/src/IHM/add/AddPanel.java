package IHM.add;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Nationalite;
import controleur.ControleurAdd;
import controleur.ControleurAjout;
import controleur.ModeleESporter;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AddPanel extends JPanel {

	//Class Variable
	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	private String mode;
	
	//OverAll Field
	private JTextField NameTF;
	
	//Player Field
	private JTextField firstNameTF;
	private JTextField pseudoTF;
	private JFormattedTextField brithDateTF;
	private JComboBox<Nationalite> natChoice;
	private Object obj;
	
	
	public AddPanel(String type, Object obj) {
		ControleurAjout c = new ControleurAjout(this);
		this.obj = obj;
		System.out.println(obj);
		this.setMode(type);
		this.setSize(WIDTH, HEIGHT);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		GridBagConstraints gbc_MainPanel = new GridBagConstraints();
		gbc_MainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_MainPanel.fill = GridBagConstraints.BOTH;
		gbc_MainPanel.gridx = 0;
		gbc_MainPanel.gridy = 0;
		add(MainPanel, gbc_MainPanel);
		
		JLabel Title = new JLabel("");
		Title.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Title.setBounds(200, 0, 200, 25);
		MainPanel.add(Title);
		
		JLabel nameLabel = new JLabel("Nom  :");
		nameLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		nameLabel.setBounds(10, 53, 80, 20);
		
		
		NameTF = new JTextField();
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NameTF.setBounds(140, 53, 150, 20);
		NameTF.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom  :");
		lblPrenom.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblPrenom.setBounds(10, 78, 80, 20);
		
		
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		firstNameTF.setColumns(10);
		firstNameTF.setBounds(140, 81, 150, 20);
		
		
		JLabel lblPseudonyme = new JLabel("Pseudonyme  :");
		lblPseudonyme.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblPseudonyme.setBounds(10, 108, 91, 20);
		
		
		pseudoTF = new JTextField();
		pseudoTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		pseudoTF.setColumns(10);
		pseudoTF.setBounds(140, 109, 150, 20);
		
		
		
		JPanel BtnPanel = new JPanel();
		BtnPanel.setLayout(null);
		GridBagConstraints gbc_BtnPanel = new GridBagConstraints();
		gbc_BtnPanel.fill = GridBagConstraints.BOTH;
		gbc_BtnPanel.gridx = 0;
		gbc_BtnPanel.gridy = 1;
		add(BtnPanel, gbc_BtnPanel);
		
		JButton confirmBtn = new JButton("Confirmer");
		confirmBtn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		confirmBtn.setBounds(360, 0, 200, 50);
		confirmBtn.addActionListener(c);
		BtnPanel.add(confirmBtn);
		
		
		JLabel lblNat = new JLabel("Nationalités : ");
		lblNat.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNat.setBounds(10, 138, 91, 20);
		
		DefaultComboBoxModel<Nationalite> modelNat = new DefaultComboBoxModel<>(ModeleESporter.getAllNat());
		natChoice = new JComboBox<>();
		natChoice.setModel(modelNat);
		natChoice.setBounds(140, 140, 150, 22);
		
		JLabel lblDate = new JLabel("Date de Naissance : ");
		lblDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblDate.setBounds(12, 168, 125, 22);
		
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
		brithDateTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		brithDateTF.setBounds(140, 171, 150, 22);
		
		MainPanel.add(nameLabel);
		MainPanel.add(NameTF);
		
		JLabel lblMode = new JLabel("Mode de jeu :");
		lblMode.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblMode.setBounds(10, 85, 90, 20);
		
		DefaultComboBoxModel<String> modeModel = new DefaultComboBoxModel<>(ModeleESporter.getAllModeName());
		JComboBox<String> comboBox = new JComboBox<>(modeModel);
		comboBox.setBounds(140, 85, 150, 25);
		
		
		

		
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
				break;
			}
			case "Orga":{
				Title.setText("Ajout d'une écurie");
				break;
			}
			case "Tournament":{
				break;
			}
		}
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Object getInfoToObject() {
		
		switch (this.mode) {
			case "Player": {
				Equipe teamToAdd = (Equipe) this.obj;
				Joueur j = new Joueur(this.NameTF.getText(), 
						this.firstNameTF.getText(), 
						this.pseudoTF.getText(), 
						this.brithDateTF.getText(), 
						(Nationalite) this.natChoice.getSelectedItem());
				j.setIdEquipe(teamToAdd.getId());
				return j;
			}
			case "Team":{
				Ecurie ecurieToAdd = (Ecurie) this.obj;
				Equipe e = new Equipe(this.NameTF.getText());
				e.setIdEcurie(ecurieToAdd.getId());
			}
			case "Orga":{
				Ecurie e = new Ecurie(this.NameTF.getText());
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + this.mode);
		}
	}

}
