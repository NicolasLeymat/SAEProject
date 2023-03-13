package IHM.info;

import java.awt.Dimension;

import javax.swing.JFrame;

import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SeeInfoFrame extends JFrame{

	private final int WIDTH = 768;
	private final int HEIGHT = 450;
	private VueInfoPanel vue;


	/**
	 * Affiche les informations d'une Ecurie
	 *
	 * @param ec l'ecurie dont on souhaite afficher les informations
	 */
	public SeeInfoFrame(Ecurie ec) {
		//Rends visible la Frame
		this.setVisible(true);
		//Donne une taille minimale à la Frame
		this.setMinimumSize(new Dimension(WIDTH - 250, HEIGHT));
		//Utilise l'agencement Agencement-grille-sac
		GridBagLayout gridBagLayout = new GridBagLayout();
		//Definit la largeur des colonnes
		gridBagLayout.columnWidths = new int[]{500, 0};
		//Definit la taille des lignes
		gridBagLayout.rowHeights = new int[]{450, 0};
		//Definit l'importance des colonnes
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		//Applique l'agencement définit ci-dessus au contenu de la frame
		getContentPane().setLayout(gridBagLayout);
		//Cree la vue Associee à la frame
		vue = new VueInfoPanel(ec);
		GridBagConstraints gbc_vue = new GridBagConstraints();
		gbc_vue.fill = GridBagConstraints.BOTH;
		gbc_vue.gridx = 0;
		gbc_vue.gridy = 0;
		getContentPane().add(vue, gbc_vue);
	}

	/**
	 * Affiche les informations d'une Equipe
	 *
	 * @param eq l'equipe dont on souhaite afficher les informations
	 */
	public SeeInfoFrame(Equipe eq) {
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WIDTH+150, HEIGHT+50));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{600, 0};
		gridBagLayout.rowHeights = new int[]{450, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		vue = new VueInfoPanel(eq);
		GridBagConstraints gbc_vue = new GridBagConstraints();
		gbc_vue.fill = GridBagConstraints.BOTH;
		gbc_vue.gridx = 0;
		gbc_vue.gridy = 0;
		getContentPane().add(vue, gbc_vue);
	}
	/**
	 * Affiche les informations d'un Tournoi
	 *
	 * @param t le tournoi dont on souhaite afficher les informations
	 */
	public SeeInfoFrame(Tournoi t) {
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{600, 0};
		gridBagLayout.rowHeights = new int[]{450, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		vue = new VueInfoPanel(t);
		GridBagConstraints gbc_vue = new GridBagConstraints();
		gbc_vue.fill = GridBagConstraints.BOTH;
		gbc_vue.gridx = 0;
		gbc_vue.gridy = 0;
		getContentPane().add(vue, gbc_vue);
	}
	/**
	 * Affiche les informations d'un Joueur
	 *
	 * @param j le joueur dont on souhaite afficher les informations
	 */
	public SeeInfoFrame(Joueur j) {
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{600, 0};
		gridBagLayout.rowHeights = new int[]{450, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		vue = new VueInfoPanel(j);
		GridBagConstraints gbc_vue = new GridBagConstraints();
		gbc_vue.fill = GridBagConstraints.BOTH;
		gbc_vue.gridx = 0;
		gbc_vue.gridy = 0;
		getContentPane().add(vue, gbc_vue);
		
	}
}
