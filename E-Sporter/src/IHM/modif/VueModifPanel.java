package IHM.modif;


import javax.swing.JPanel;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import controleur.ControleurModif;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class VueModifPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NameTF;
	private Equipe e;
	private Ecurie ec;

	public VueModifPanel(Equipe e) {
		this.e = e;
		ControleurModif c = new ControleurModif(e, this); 
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{100, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel PrincPanel = new JPanel();
		PrincPanel.setLayout(null);
		GridBagConstraints gbc_PrincPanel = new GridBagConstraints();
		gbc_PrincPanel.insets = new Insets(0, 0, 5, 0);
		gbc_PrincPanel.fill = GridBagConstraints.BOTH;
		gbc_PrincPanel.gridx = 0;
		gbc_PrincPanel.gridy = 0;
		add(PrincPanel, gbc_PrincPanel);
		
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 92, 27);
		PrincPanel.add(lblNewLabel);
		
		NameTF = new JTextField(e.getNom());
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NameTF.setBounds(10, 36, 430, 28);
		NameTF.setColumns(10);
		PrincPanel.add(NameTF);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnNewButton.setBounds(240, 25, 200, 50);
		btnNewButton.addActionListener(c);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(c);
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnAnnuler.setBounds(10, 25, 100, 50);
		panel.add(btnAnnuler);
	}
	
	public VueModifPanel(Ecurie ec) {
		this.ec = ec;
		ControleurModif c = new ControleurModif(ec, this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel PrincPanel = new JPanel();
		PrincPanel.setLayout(null);
		GridBagConstraints gbc_PrincPanel = new GridBagConstraints();
		gbc_PrincPanel.insets = new Insets(0, 0, 5, 0);
		gbc_PrincPanel.fill = GridBagConstraints.BOTH;
		gbc_PrincPanel.gridx = 0;
		gbc_PrincPanel.gridy = 0;
		add(PrincPanel, gbc_PrincPanel);
		
		NameTF = new JTextField(ec.getNom());
		NameTF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NameTF.setBounds(10, 36, 430, 28);
		NameTF.setColumns(10);
		PrincPanel.add(NameTF);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 92, 27);
		PrincPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnNewButton.setBounds(240, 25, 200, 50);
		btnNewButton.addActionListener(c);
		panel.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnAnnuler.setBounds(10, 25, 100, 50);
		btnAnnuler.addActionListener(c);
		panel.add(btnAnnuler);
	}
	
	public Equipe getAllInfoEquipe() {
		Equipe res = this.e;
		res.setNom(this.NameTF.getText());
		return res;
	}
	
	public Ecurie getAllInfoEcurie() {
		Ecurie res = this.ec;
		res.setNom(this.NameTF.getText());
		return res;
	}
}

