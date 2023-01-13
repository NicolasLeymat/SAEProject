package IHM.tournois;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import IHM.info.TableauMatchHistorique;
import Object.Match;
import Object.Tournoi;
import controleur.ModeleESporter;

public class VueClassementTournois extends JPanel{

	private JTable table;
	private JTable table_1;
	private Tournoi t;
	
	public VueClassementTournois(Tournoi t) {
		this.t = t;
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[]{293, 0};
		gbl_this.rowHeights = new int[]{82, 45, 106, 45, 297, 0};
		gbl_this.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_this.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gbl_this);
		
		JLabel lblNewLabel_2 = new JLabel("Résultats du tournoi");
		lblNewLabel_2.setFont(ModeleESporter.FONT_LARGE);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		this.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Classement");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setFont(ModeleESporter.FONT_MEDIUM);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		this.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(ModeleESporter.FONT_MEDIUM);
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"#", "Equipe", "W", "L"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		this.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Matchs");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(ModeleESporter.FONT_MEDIUM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		this.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		List<Match> matchsPoules = t.getPhasePoule().getMatchs();
		List<Match> matchsElims = t.getPhaseElim().getMatchs();
		List<Match> matchs = new ArrayList<>();
		matchs.addAll(matchsPoules);
		matchs.addAll(matchsElims);
		table_1.setModel(new TableauMatchHistorique(matchs));
		table_1.setShowGrid(false);
		table_1.setFont(ModeleESporter.FONT_SMALL);
		
		scrollPane_1.setViewportView(table_1);
	}
	
}
