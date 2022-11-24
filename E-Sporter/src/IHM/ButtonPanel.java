package IHM;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ButtonPanel extends JPanel{

	
	public ButtonPanel() {
		setSize(1200, 100);
		Dimension btnSize = new Dimension(200,75);
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JButton AddTeam = new JButton("Ajouter une équipe");
		AddTeam.setLocation(100, 25);
		panel.add(AddTeam);
		AddTeam.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		AddTeam.setSize(new Dimension(200, 50));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton AddSupervisor = new JButton("Ajouter une écurie");
		AddSupervisor.setLocation(100, 25);
		panel_1.add(AddSupervisor);
		AddSupervisor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		AddSupervisor.setSize(new Dimension(200, 50));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton NewTournament = new JButton("Ajouter un tournoi");
		NewTournament.setLocation(100, 25);
		panel_2.add(NewTournament);
		NewTournament.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		NewTournament.setSize(new Dimension(200, 50));
	}
}
