package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import IHM.MainPanel;
import IHM.info.VueInfoPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;

public class ControleurDelete implements ActionListener {

	private JPanel vue;
	private Equipe eq;
	private Ecurie ec;
	//private Tournoi t;
	private Joueur j;
	private ModeleESporter modele;
	private String nature;

	public ControleurDelete(Equipe eq, JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Equipe";

	}

	public ControleurDelete(Ecurie ec, JPanel vue) {
		this.ec = ec;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Ecurie";
	}

	public ControleurDelete(Tournoi t, JPanel vue) {
		//this.t = t;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Tournoi";

	}

	public ControleurDelete(Joueur j, JPanel vue) {
		this.j = j;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Joueur";

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Supprimer")) {

			int resultat = JOptionPane.showConfirmDialog(this.vue, "Êtes-vous sûr de vouloir vraiment supprimer ceci ?",
					"Confirm", JOptionPane.YES_NO_OPTION);
			if (resultat == JOptionPane.YES_OPTION) {
				switch (this.nature) {
				case "Equipe":
					//traitement
					if (modele.supprimerEquipe(eq) == -2) {
						JOptionPane.showMessageDialog(this.vue, "L'équipe n'a pas pu être supprimée car elle est liée à un tournoi");
						break;
					}
					//pop up indiquant que l'exécution est en cours
					JDialog dialog = dialog();
					MainPanel.updateListEquipe();
					VueInfoPanel.updateListEquipe();
					MainPanel.updateListEcuries();
					//execution terminer fermeture de la pop up
					closeDialog(dialog);
					//pop up affichant le succès de l'opération
					JOptionPane.showMessageDialog(this.vue, "Equipe supprimée avec succès");
					this.modele.getPanelFrame(vue).dispose();
					break;
				case "Ecurie":
					if (modele.supprimerEcurie(ec) == -2) {
						JOptionPane.showMessageDialog(this.vue, "L'écurie n'a pas pu être supprimée car ses équipes sont liées à un tournoi");
						break;
					}
					//pop up indiquant que l'exécution est en cours
					dialog = dialog();
					MainPanel.updateListEcuries();
					//execution terminer fermeture de la pop up
					closeDialog(dialog);
					JOptionPane.showMessageDialog(this.vue, "Ecurie supprimer avec succès");
					this.modele.getPanelFrame(vue).dispose();
					break;
				/*case "Tournoi":
					if (modele.supprimerTournoi(t) == -1) {
						JOptionPane.showMessageDialog(this.vue, "Il faut supprimer les écuries participantes avant de pouvoir supprimer le tournoi!");
						break;
					}
					//pop up indiquant que l'exécution est en cours
					dialog = dialog();
					MainPanel.updateListTournoi();
					//execution terminer fermeture de la pop up
					closeDialog(dialog);
					JOptionPane.showMessageDialog(this.vue, "Tournoi supprimer avec succès");
					this.modele.getPanelFrame(vue).dispose();
					break;*/
				case "Joueur":
					System.out.println(j);
					if (modele.supprimerJoueur(j) == -2) {
						JOptionPane.showMessageDialog(this.vue, "Le Joueur n'a pas être supprimer, réessayez !");
						break;
					}
					//pop up indiquant que l'exécution est en cours
					dialog = dialog();
					VueInfoPanel.updateListJoueur();
					MainPanel.updateListEquipe();
					//execution terminer fermeture de la pop up
					closeDialog(dialog);
					JOptionPane.showMessageDialog(this.vue, "Joueur supprimer avec succès");
					this.modele.getPanelFrame(vue).dispose();
					break;
				}
			}
		}
	}
	public JDialog dialog() {
		JOptionPane popup = new JOptionPane("Suppression en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, this.vue);
		JDialog dialog = popup.createDialog("En cours d'exécution...");
		dialog.setModal(false);
		dialog.setVisible(true);
		return dialog;
		
	}
	
	public void closeDialog(JDialog dialog) {
		dialog.setVisible(false);
		dialog.dispose();
	}
}
