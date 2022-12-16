package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import IHM.MainPanel;
import IHM.VuePrincipale;
import IHM.info.VueInfoPanel;
import IHM.modif.VueModifFrame;
import IHM.modif.VueModifPanel;
import Object.Ecurie;
import Object.Equipe;

public class ControleurModif implements ActionListener{

	private JPanel vue;
	private Equipe eq;
	private Ecurie ec;
	private ModeleESporter modele;
	private VueModifFrame v;
	private boolean Equipe;
	
	public ControleurModif(Equipe eq,JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.Equipe = true;
		
	}
	
	public ControleurModif(Ecurie eq,JPanel vue) {
		this.ec = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.Equipe = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Modifier")) {
			if(this.Equipe){
				this.v = new VueModifFrame(eq);
				this.v.setVisible(true);
			}else {
				this.v = new VueModifFrame(ec);
				this.v.setVisible(true);
			}
		}
		if(b.getText().equals("Confirmer")) {
			this.modele.getPanelFrame(vue).dispose();
			if(this.Equipe){
				Equipe eqNew = ((VueModifPanel) this.vue).getAllInfoEquipe();
				VueInfoPanel.updateInfoEquipe(eqNew.getNom());
				this.modele.modifierEquipe(eqNew);
			}else{
				Ecurie ecNew = ((VueModifPanel) this.vue).getAllInfoEcurie();
				VueInfoPanel.updateInfoEcurie(ec.getNom());
				this.modele.modifierEcurie(ecNew);
			}
		}
		if(b.getText().equals("Annuler")) {
			this.modele.getPanelFrame(vue).dispose();
			}	
	}

	
	
}
