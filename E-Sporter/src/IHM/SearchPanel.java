package IHM;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class SearchPanel extends JPanel{
	private JTextField searchField;
	
	public SearchPanel() {
		this.setVisible(true);
		this.setSize(1200, 100);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{99, 1000, 101, 0};
		gridBagLayout.rowHeights = new int[]{23, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Recherche : ");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 255, 255));
		searchField.setHorizontalAlignment(SwingConstants.LEFT);
		searchField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		searchField.setColumns(50);
		searchField.setToolTipText("Rechercher");
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.insets = new Insets(0, 0, 0, 5);
		gbc_searchField.fill = GridBagConstraints.BOTH;
		gbc_searchField.gridx = 1;
		gbc_searchField.gridy = 1;
		this.add(searchField, gbc_searchField);
	}
	
	public void changeWitdth(int newWidth) {
		this.searchField.setSize(newWidth, 50);
	}
	
	public void addListenerToSearchField(CaretListener c) {
		this.searchField.addCaretListener(c);
	}
}
