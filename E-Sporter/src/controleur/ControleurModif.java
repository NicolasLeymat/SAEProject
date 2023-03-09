package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import IHM.MainPanel;
import IHM.info.VueInfoPanel;
import IHM.modif.VueModifFrame;
import IHM.modif.VueModifPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;


public class ControleurModif implements ActionListener{

	private JPanel vue;
	private Equipe eq;
	private Ecurie ec;
	private Joueur j;
	private ModeleESporter modele;
	private VueModifFrame v;
	private String nature;
	
	public ControleurModif(Equipe eq,JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Equipe";
		
	}
	
	public ControleurModif(Ecurie ec,JPanel vue) {
		this.ec = ec;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Ecurie";
	}
	
	public ControleurModif(JPanel vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Tournoi";
		
	}
	
	public ControleurModif(Joueur j,JPanel vue) {
		this.j = j;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Joueur";
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Modifier")) {
			switch(this.nature){
				case "Equipe":
					this.v = new VueModifFrame(eq);
					this.v.setVisible(true);
					break;
				case "Ecurie":
					this.v = new VueModifFrame(ec);
					this.v.setVisible(true);
					break;
				case "Joueur":
					this.v = new VueModifFrame(j);
					this.v.setVisible(true);
					break;
			}
		}
		
		if(b.getText().equals("Confirmer")) {
			this.modele.getPanelFrame(vue).dispose();
		
			switch(this.nature) {				
				case "Equipe":
					
					Equipe eqNew = ((VueModifPanel) this.vue).getAllInfoEquipe();
					JDialog dialog = dialog();
					
					VueInfoPanel.updateInfoEquipe(eqNew.getNom());
					MainPanel.updateListEquipe();			
					this.modele.modifierEquipe(eqNew);
					MainPanel.updateListEquipe();
					VueInfoPanel.updateListEquipe();
					closeDialog(dialog);
					JOptionPane.showMessageDialog(null, "Modification confirmé.");
					break;
				case "Ecurie":
					Ecurie ecNew = ((VueModifPanel) this.vue).getAllInfoEcurie();
					dialog = dialog();
					
					VueInfoPanel.updateInfoEcurie(ec.getNom());
					closeDialog(dialog);
					this.modele.modifierEcurie(ecNew);
					break;
				case "Joueur":
					
					Joueur jNew = ((VueModifPanel) this.vue).getAllInfoJoueur();
					dialog = dialog();
					VueInfoPanel.updateInfoJoueur(jNew);
					MainPanel.updateListEquipe();
					closeDialog(dialog);
					this.modele.modifierJoueur(jNew);
					break;
			}
		}
		if(b.getText().equals("Annuler")) {
			this.modele.getPanelFrame(vue).dispose();
			}	
	}
	
	public JDialog dialog() {
		JOptionPane popup = new JOptionPane("Modification en cours...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, this.vue);
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
