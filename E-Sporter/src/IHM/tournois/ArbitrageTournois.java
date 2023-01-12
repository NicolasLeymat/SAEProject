package IHM.tournois;


import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import IHM.info.ListeJoueur;
import Object.Match;
import Object.Joueur;

public class ArbitrageTournois extends JFrame {
	private Match match;
  
	public ArbitrageTournois(Match t) {
		this.match = t;
	    // définition de la fenêtre
	    setTitle("Fenêtre avec deux listes");
	    setSize(500, 275);
	    setLocationRelativeTo(null);
	    
	    // création des listes et de leurs modèles de données
	    GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[]{193, 193, 0};
	    gridBagLayout.rowHeights = new int[]{185, 25, 0};
	    gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	    gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	    getContentPane().setLayout(gridBagLayout);
	    
	    // création des titres
	    JLabel titreListe1 = new JLabel(match.getEquipe1().getNom());
	    titreListe1.setBounds(80, 30, 80, 13);
	    titreListe1.setHorizontalAlignment(SwingConstants.CENTER);

	    
	    // création des panneaux pour contenir les titres et les listes
	    JPanel panneauListe1 = new JPanel();
	    panneauListe1.setLayout(null);
	    panneauListe1.add(titreListe1);
		List<Joueur> joueursE1 = match.getEquipe1().getJoueurs();

		JList<Joueur> listeJE1 = new JList<>(new ListeJoueur(joueursE1));
	    JScrollPane scrollPane_1 = new JScrollPane(listeJE1);
		System.out.println("-----------\n"+ joueursE1);
		System.out.println("-----------\n"+ listeJE1.getSize());
	    scrollPane_1.setBounds(40, 65, 160, 100);
	    panneauListe1.add(scrollPane_1);
	    GridBagConstraints gbc_panneauListe1 = new GridBagConstraints();
	    gbc_panneauListe1.fill = GridBagConstraints.BOTH;
	    gbc_panneauListe1.insets = new Insets(0, 0, 5, 5);
	    gbc_panneauListe1.gridx = 0;
	    gbc_panneauListe1.gridy = 0;
	    getContentPane().add(panneauListe1, gbc_panneauListe1);
	    JLabel titreListe2 = new JLabel(match.getEquipe2().getNom());
	    titreListe2.setBounds(80, 30, 80, 15);
	    titreListe2.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    JPanel panneauListe2 = new JPanel();
	    panneauListe2.setLayout(null);
	    panneauListe2.add(titreListe2);
		List<Joueur> joueursE2 = match.getEquipe1().getJoueurs();

		JList<Joueur> listeJE2 = new JList<>(new ListeJoueur(joueursE2));

	    
	    JScrollPane scrollPane = new JScrollPane(listeJE2);
	    scrollPane.setBounds(40, 65, 160, 100);
	    panneauListe2.add(scrollPane);
	    GridBagConstraints gbc_panneauListe2 = new GridBagConstraints();
	    gbc_panneauListe2.fill = GridBagConstraints.BOTH;
	    gbc_panneauListe2.insets = new Insets(0, 0, 5, 0);
	    gbc_panneauListe2.gridx = 1;
	    gbc_panneauListe2.gridy = 0;
	    getContentPane().add(panneauListe2, gbc_panneauListe2);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.fill = GridBagConstraints.BOTH;
	    gbc_panel.insets = new Insets(0, 0, 0, 5);
	    gbc_panel.gridx = 0;
	    gbc_panel.gridy = 1;
	    getContentPane().add(panel, gbc_panel);
	    
	    // création des boutons
	    JButton boutonListe1 = new JButton("Gagné");
	    boutonListe1.setBounds(80, 0, 80, 21);
	    panel.add(boutonListe1);
	    boutonListe1.setPreferredSize(new Dimension(20, 10));
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	    gbc_panel_1.fill = GridBagConstraints.BOTH;
	    gbc_panel_1.gridx = 1;
	    gbc_panel_1.gridy = 1;
	    getContentPane().add(panel_1, gbc_panel_1);
	    JButton boutonListe2 = new JButton("Gagné");
	    boutonListe2.setBounds(81, 0, 82, 21);
	    panel_1.add(boutonListe2);
	    boutonListe2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	}
  

}

