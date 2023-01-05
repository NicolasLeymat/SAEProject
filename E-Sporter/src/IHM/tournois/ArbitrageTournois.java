package IHM.tournois;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArbitrageTournois extends JFrame {
  
	public ArbitrageTournois() {
	    // définition de la fenêtre
	    setTitle("Fenêtre avec deux listes");
	    setSize(500, 400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // création des listes et de leurs modèles de données
	    DefaultListModel<String> modeleListe1 = new DefaultListModel<>();
	    modeleListe1.addElement("Élément 1");
	    modeleListe1.addElement("Élément 2");
	    modeleListe1.addElement("Élément 3");
	    modeleListe1.addElement("Élément 4");
	    
	    DefaultListModel<String> modeleListe2 = new DefaultListModel<>();
	    modeleListe2.addElement("Élément 1");
	    modeleListe2.addElement("Élément 2");
	    modeleListe2.addElement("Élément 3");
	    modeleListe2.addElement("Élément 4");
	    GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[]{193, 193, 0};
	    gridBagLayout.rowHeights = new int[]{285, -23, 0};
	    gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	    gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
	    getContentPane().setLayout(gridBagLayout);
	    
	    // création des titres
	    JLabel titreListe1 = new JLabel("Equipe 1");
	    titreListe1.setBounds(98, 29, 39, 13);
	    titreListe1.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    // création des panneaux pour contenir les titres et les listes
	    JPanel panneauListe1 = new JPanel();
	    panneauListe1.setLayout(null);
	    panneauListe1.add(titreListe1);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(40, 75, 160, 200);
	    panneauListe1.add(scrollPane_1);
	    GridBagConstraints gbc_panneauListe1 = new GridBagConstraints();
	    gbc_panneauListe1.fill = GridBagConstraints.BOTH;
	    gbc_panneauListe1.insets = new Insets(0, 0, 5, 5);
	    gbc_panneauListe1.gridx = 0;
	    gbc_panneauListe1.gridy = 0;
	    getContentPane().add(panneauListe1, gbc_panneauListe1);
	    JLabel titreListe2 = new JLabel("Equipe 2");
	    titreListe2.setBounds(91, 28, 48, 15);
	    titreListe2.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    JPanel panneauListe2 = new JPanel();
	    panneauListe2.setLayout(null);
	    panneauListe2.add(titreListe2);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(40, 75, 160, 200);
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
	    boutonListe1.setBounds(80, 0, 61, 21);
	    panel.add(boutonListe1);
	    boutonListe1.setPreferredSize(new Dimension(20, 20));
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setLayout(null);
	    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	    gbc_panel_1.fill = GridBagConstraints.BOTH;
	    gbc_panel_1.gridx = 1;
	    gbc_panel_1.gridy = 1;
	    getContentPane().add(panel_1, gbc_panel_1);
	    JButton boutonListe2 = new JButton("Gagné");
	    boutonListe2.setBounds(85, 0, 61, 21);
	    panel_1.add(boutonListe2);
	    boutonListe2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	}
  
	public static void main(String[] args) {
		ArbitrageTournois fenetre = new ArbitrageTournois();
   
	}
}

