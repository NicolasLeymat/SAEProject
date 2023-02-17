package IHM.add;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * Cette classe permet de créer la fenêtre permettant d'ajouter des objets à l'application.
 */
public class AddFrame extends JFrame {

	/**
	 * Variables d'instance privées
	 */
	private static final long serialVersionUID = 1L;
	// définir la largeur de la fenêtre
	private static final int WIDTH = 450;
	// définir la hauteur de la fenêtre
	private static final int HEIGHT = 500;
	// stocker le contenu de la fenêtre
	private AddPanel contentPane;
	// stocker le mode d'ajout
	private String mode;

	/**
	 * Créer une nouvelle instance permettant d'ajouter un objet à la fenêtre
	 * 
	 * @param type est le type de l'objet
	 * @param obj  est l'objet à ajouter
	 */
	public AddFrame(String type, Object obj) {
		this.setMode(type);
		// éviter un bug de responsivité
		this.setResizable(false);
		this.setMinimumSize(getMinimumSize(type));
		//création et ajout de la grille dans le panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		this.setLayout(gridBagLayout);
		// ajout de l'objet au panel
		contentPane = new AddPanel(type, obj);
		// création des contraintes
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		// ajout des contraintes
		this.add(contentPane, constraints);
	}

	//méthode permettant de renvoyer le mode
	public String getMode() {
		return mode;
	}
	
	//méthode permettant de mettre à jour le mode
	public void setMode(String type) {
		this.mode = type;
	}

	// méthode qui calcule la taille minimale de la fenêtre en fonction du type de l'objet
	private Dimension getMinimumSize(String type) {
		switch (type) {
		case "Player":
			return new Dimension(WIDTH, HEIGHT - 150);
		case "Team":
			return new Dimension(WIDTH, HEIGHT - 200);
		case "Orga":
			return new Dimension(WIDTH, HEIGHT - 150);
		case "Tournament":
			return new Dimension(WIDTH, HEIGHT - 100);
		default:
			return new Dimension(WIDTH, HEIGHT);
		}
	}
}
