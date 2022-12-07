package IHM.add;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Object.Nationalite;
import controleur.ModeleESporter;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class AddPanel extends JPanel {

	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	private JTextField NameTF;
	private JTextField firstNameTF;
	private JTextField pseudoTF;
	
	public AddPanel(String type) {
		this.setSize(WIDTH, HEIGHT);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 100, 0};
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
		
		JLabel Title = new JLabel("Ajout d'un");
		Title.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		Title.setBounds(250, 0, 100, 25);
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
		GridBagConstraints gbc_BtnPanel = new GridBagConstraints();
		gbc_BtnPanel.fill = GridBagConstraints.BOTH;
		gbc_BtnPanel.gridx = 0;
		gbc_BtnPanel.gridy = 1;
		add(BtnPanel, gbc_BtnPanel);
		
		
		JLabel lblNat = new JLabel("Nationalités : ");
		lblNat.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNat.setBounds(10, 138, 91, 20);
		
		DefaultComboBoxModel<Nationalite> modelNat = new DefaultComboBoxModel<>(ModeleESporter.getAllNat());
		JComboBox<Nationalite> natChoice = new JComboBox<>();
		natChoice.setModel(modelNat);
		natChoice.setBounds(140, 140, 150, 22);
		
		JLabel lblDate = new JLabel("Date de Naissance : ");
		lblDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblDate.setBounds(12, 168, 125, 22);
		
		JFormattedTextField brithDateTF = new JFormattedTextField();
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
		
		switch(type) {
			case "Player":{
				Title.setText("Ajout d'un joueur");
				MainPanel.add(nameLabel);
				MainPanel.add(NameTF);
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
				break;
			}
			case "Orga":{
				break;
			}
		}
	}
}
