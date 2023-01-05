package IHM;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import IHM.info.VueInfoTournoisPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.Tournoi;
import controleur.ControleurJList;
import controleur.ControleurTournoiJList;
import controleur.ControleurEcurieJList;
import controleur.ModeleESporter;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.awt.Font;

public class MainPanel extends JPanel{


	private static JList<Equipe> listEquipe = new JList<>();
	private static DefaultListModel<Equipe> modelEquipe = new DefaultListModel<>();
	
	private static JList<Ecurie> listEcurie = new JList<>();
	private static DefaultListModel<Ecurie> modelEcurie = new DefaultListModel<>();
	
	private static JList<Tournoi> listTournoi = new JList<>();
	private static DefaultListModel<Tournoi> modelTournoi = new DefaultListModel<>();
	
	private static List<Equipe> e = null;
	private static List<Ecurie> ec = null;
	private static List<Tournoi> t = null;
	
	public MainPanel() throws Exception {
		ControleurJList controleurEquipe = new ControleurJList();
		ControleurEcurieJList controleurEcurie = new ControleurEcurieJList();
		ControleurTournoiJList controleurTournoi = new ControleurTournoiJList();
		
		setLayout(new GridLayout(0, 3, 0, 0));
		listEquipe.setBorder(null);
		listEquipe.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
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
		listEcurie.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		modelEcurie.addAll(ModeleESporter.getAllEcurie());
		listEcurie.setModel(modelEcurie);
		listEcurie.addMouseListener(controleurEcurie);
		JScrollPane ecuriePanel = new JScrollPane(listEcurie);
		ecuriePanel.setSize(400, 625);
		ecuriePanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ecuriePanel.setMaximumSize(new Dimension(400, 625));
		ecuriePanel.setMinimumSize(new Dimension(400, 625));
		add(ecuriePanel);
		
		
		listTournoi.setBorder(null);
		listTournoi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		modelTournoi.addAll(ModeleESporter.getAllTournoi());
		listTournoi.setModel(modelTournoi);
		listTournoi.addMouseListener(controleurTournoi);
		JScrollPane tournoiPanel = new JScrollPane(listTournoi);
		tournoiPanel.setSize(400, 625);
		tournoiPanel.setMaximumSize(new Dimension(400, 625));
		tournoiPanel.setMinimumSize(new Dimension(400, 625));
		add(tournoiPanel);

	}
	
	public static void changeModelElementEquipe(List<Equipe> l) {
		modelEquipe.clear();
		modelEquipe.addAll(l);
	}
	
	public static void changeModelElementEcurie(List<Ecurie> l) {
		modelEcurie.clear();
		modelEcurie.addAll(l);
	}
	
	public static void updateListEquipe() {
		modelEquipe.clear();
		e = Equipe.getAllEquipes();
		modelEquipe.addAll(e);
		listEquipe.setModel(modelEquipe);
	}
	
	public static void updateListEcuries() {
		modelEcurie.clear();
		ec = Ecurie.getAllEcuries();
		modelEcurie.addAll(ec);
		listEcurie.setModel(modelEcurie);
	}
}
