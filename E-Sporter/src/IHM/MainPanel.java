package IHM;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.xml.transform.Templates;

import Object.Ecurie;
import Object.Equipe;
import controleur.JListControler;
import controleur.JListControlerEcurie;
import controleur.ModeleESporter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel{


	private JList<Equipe> listEquipe = new JList<>();
	private static DefaultListModel<Equipe> modelEquipe = new DefaultListModel<>();
	
	private JList<Ecurie> listEcurie = new JList<>();
	private static DefaultListModel<Ecurie> modelEcurie = new DefaultListModel<>();
	
	public MainPanel() {
		this.setMaximumSize(new Dimension(1200, 625));
		JListControler controleurEquipe = new JListControler();
		JListControlerEcurie controleurEcurie = new JListControlerEcurie();
		setLayout(new GridLayout(0, 3, 0, 0));
		listEquipe.setBorder(null);
		listEquipe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modelEquipe.addAll(ModeleESporter.getAllEquipe());
		listEquipe.setModel(modelEquipe);
		listEquipe.addMouseListener(controleurEquipe);
		JScrollPane teamPanel = new JScrollPane(listEquipe);
		teamPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		teamPanel.setSize(400, 625);
		teamPanel.setMaximumSize(new Dimension(400, 625));
		teamPanel.setMinimumSize(new Dimension(400, 625));
		add(teamPanel);
		
		
		listEcurie.setBorder(null);
		listEcurie.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		modelEcurie.addAll(ModeleESporter.getAllEcurie());
		listEcurie.setModel(modelEcurie);
		listEcurie.addMouseListener(controleurEcurie);
		JScrollPane ecuriePanel = new JScrollPane(listEcurie);
		ecuriePanel.setSize(400, 625);
		ecuriePanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ecuriePanel.setMaximumSize(new Dimension(400, 625));
		ecuriePanel.setMinimumSize(new Dimension(400, 625));
		add(ecuriePanel);
		
		JScrollPane tournamentPanel = new JScrollPane();
		tournamentPanel.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		tournamentPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tournamentPanel.setSize(400, 625);
		tournamentPanel.setMaximumSize(new Dimension(400, 625));
		tournamentPanel.setMinimumSize(new Dimension(400, 625));
		add(tournamentPanel);
	}
	
	public static void changeModelElementEquipe(List<Equipe> l) {
		modelEquipe.clear();
		modelEquipe.addAll(l);
	}
	
	public static void changeModelElementEcurie(List<Ecurie> l) {
		modelEcurie.clear();
		modelEcurie.addAll(l);
	}
}
