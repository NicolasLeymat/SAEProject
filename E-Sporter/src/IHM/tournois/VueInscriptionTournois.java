package IHM.tournois;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Object.Equipe;
import Object.Joueur;
import Object.Nationalite;
import Object.Tournoi;
import controleur.ControleurInscription;
import controleur.ModeleESporter;

public class VueInscriptionTournois extends JPanel{

	private Tournoi t;
	private Object obj;
	private static JList<Equipe> list = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipe = new DefaultListModel<>();
	private static JList<Equipe> listEquipesTournoi = new JList<>();
	private static DefaultListModel<Equipe> modeleEquipeTournoi = new DefaultListModel<>();
	private static JScrollPane scrollPane;
	private static JScrollPane scrollPane_1;
	private static JButton btnAjouter;
	private static JButton btnSupprimer;
	
	public VueInscriptionTournois(Tournoi t) {
		this.t = t;
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[]{51, 170, 0, 69, 11, 175, 50, 0};
		gbl_this.rowHeights = new int[]{0, 37, 0, 0, 0, 0, 46, 23, 63, 21, 51, 50, 0};
		gbl_this.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_this.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gbl_this);
		
		ControleurInscription i = new ControleurInscription(this);
		
		JLabel lblNewLabel = new JLabel("Titre Tournois");
		lblNewLabel.setFont(ModeleESporter.FONT_LARGE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Equipes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(ModeleESporter.FONT_MEDIUM);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Equipes tournois");
		lblNewLabel_2.setFont(ModeleESporter.FONT_MEDIUM);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridheight = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		list = new JList<>();
		modeleEquipe.addAll(equipeDif(t, Equipe.getAllEquipesFromModeDeJeu(t.getId_Mode().getIdMode())));		
		list.setModel(modeleEquipe);
		
		listEquipesTournoi = new JList<>();
		modeleEquipeTournoi.addAll(Equipe.getAllEquipesFromTournoi(t));
		listEquipesTournoi.setModel(modeleEquipeTournoi);
		
		scrollPane = new JScrollPane(list);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		this.add(scrollPane, gbc_scrollPane);
		
		
		
		
		scrollPane_1 = new JScrollPane(listEquipesTournoi);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 5;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 4;
		this.add(scrollPane_1, gbc_scrollPane_1);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(ModeleESporter.FONT_SMALL);
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.gridwidth = 2;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 1;
		gbc_btnAjouter.gridy = 10;
		this.add(btnAjouter, gbc_btnAjouter);
		btnAjouter.addActionListener(i);
		if (listEquipesTournoi.getModel().getSize() >= 16) {
			btnAjouter.setEnabled(false);
		}
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(ModeleESporter.FONT_SMALL);
		GridBagConstraints gbc_btnSupprimer_1 = new GridBagConstraints();
		gbc_btnSupprimer_1.gridwidth = 2;
		gbc_btnSupprimer_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer_1.gridx = 4;
		gbc_btnSupprimer_1.gridy = 10;
		this.add(btnSupprimer, gbc_btnSupprimer_1);
		btnSupprimer.addActionListener(i);
		if (listEquipesTournoi.getModel().getSize() <=0) {
			btnSupprimer.setEnabled(false);
		}
	}

	private static List<Equipe> equipeDif(Tournoi t,List<Equipe> allEquipesFromModeDeJeu) {
		List<Equipe> res = new ArrayList<>();
		List<Equipe> test = Equipe.getAllEquipesFromTournoi(t);
		boolean check = false;
		for (Equipe e : allEquipesFromModeDeJeu) {
			check = false;
			for (Equipe e2 : test) {
				if (e.getId() == e2.getId()) {
					check = true;
					break;
				}
			}
			if (check == false) {
				res.add(e);
			}
		}
		return res;
	}

	public Tournoi getTournoi() {
		return t;
	}

	public Equipe getInfoToObject() {
		return list.getSelectedValue();
	}
	public Equipe getListEquipesTournoi() {
		return listEquipesTournoi.getSelectedValue();
	}

	public static void updateListEquipe(Tournoi t) {
		modeleEquipe.clear();
		modeleEquipe.addAll(equipeDif(t, Equipe.getAllEquipesFromModeDeJeu(t.getId_Mode().getIdMode())));	
		list.setModel(modeleEquipe);
		
		modeleEquipeTournoi.clear();
		modeleEquipeTournoi.addAll(Equipe.getAllEquipesFromTournoi(t));
		listEquipesTournoi.setModel(modeleEquipeTournoi);
		
		if (listEquipesTournoi.getModel().getSize() >= 16) {
			btnAjouter.setEnabled(false);
		}
		
		if (listEquipesTournoi.getModel().getSize() <=0) {
			btnSupprimer.setEnabled(false);
		}
	}

	
}
