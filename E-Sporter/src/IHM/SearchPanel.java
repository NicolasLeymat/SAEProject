package IHM;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.Component;
import java.awt.BorderLayout;

public class SearchPanel extends JPanel{
	private JTextField searchField;

	public SearchPanel() {
		ImageIcon icon = new ImageIcon("./src/IHM/search.png");
		this.setVisible(true);
		this.setSize(1200, 100);
		setLayout(null);
		searchField = new JTextField();
		searchField.setLocation(0, 25);
		searchField.setBackground(new Color(255, 255, 255));
		searchField.setSize(1050, 50);
		searchField.setHorizontalAlignment(SwingConstants.LEFT);
		searchField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		searchField.setColumns(50);
		searchField.setToolTipText("Entré le nom à rechercher");
		this.add(searchField, BorderLayout.WEST);
		
		JButton searchBtn = new JButton("", icon);
		searchBtn.setLocation(1050, 25);
		searchBtn.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn.setSize(82, 50);
		searchBtn.setIconTextGap(0);
		this.add(searchBtn, BorderLayout.CENTER);
	}
}
