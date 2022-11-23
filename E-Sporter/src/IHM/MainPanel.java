package IHM;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class MainPanel extends JPanel{

	public MainPanel() {
		this.setSize(1200, 625);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane teamPanel = new JScrollPane();
		add(teamPanel, BorderLayout.WEST);
		
		JScrollPane ecuriePanel = new JScrollPane();
		add(ecuriePanel, BorderLayout.EAST);
		
		JScrollPane tournamentPanel = new JScrollPane();
		add(tournamentPanel, BorderLayout.CENTER);
	}
}
