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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, BorderLayout.EAST);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, BorderLayout.CENTER);
	}
}
