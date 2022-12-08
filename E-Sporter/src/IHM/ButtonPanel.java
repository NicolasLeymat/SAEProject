package IHM;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

import controleur.ControleurAdd;

import java.awt.GridLayout;
import javax.swing.JLabel;

public class ButtonPanel extends JPanel{

	
	public ButtonPanel() {
		ControleurAdd c = new ControleurAdd(this, null);
		setSize(1200, 100);
		Dimension btnSize = new Dimension(200,75);
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTeam = new JLabel("Listes des équipes : ");
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblTeam.setBounds(120, 10, 150, 30);
		panel.add(lblTeam);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton addSupervisor = new JButton("Ajouter une écurie");
		addSupervisor.setLocation(100, 35);
		panel_1.add(addSupervisor);
		addSupervisor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		addSupervisor.setSize(new Dimension(200, 50));
		addSupervisor.addActionListener(c);
		
		JLabel lblEcuries = new JLabel("Listes des écuries : ");
		lblEcuries.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcuries.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblEcuries.setBounds(120, 10, 150, 30);
		panel_1.add(lblEcuries);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton NewTournament = new JButton("Ajouter un tournoi");
		NewTournament.setLocation(100, 35);
		panel_2.add(NewTournament);
		NewTournament.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NewTournament.setSize(new Dimension(200, 50));
		NewTournament.addActionListener(c);
		
		JLabel lblTournois = new JLabel("Listes des tournois : ");
		lblTournois.setHorizontalAlignment(SwingConstants.CENTER);
		lblTournois.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lblTournois.setBounds(120, 10, 150, 30);
		panel_2.add(lblTournois);
	}
}
