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
import Object.Joueur;
import Object.Tournoi;

public class ControleurDelete implements ActionListener{

	private JPanel vue;
	private Equipe eq;
	private Ecurie ec;
	private Tournoi t;
	private Joueur j;
	private ModeleESporter modele;
	private VueModifFrame v;
	private String nature;
	
	public ControleurDelete(Equipe eq,JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Equipe";
		
	}
	
	public ControleurDelete(Ecurie eq,JPanel vue) {
		this.ec = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Ecurie";
	}
	
	public ControleurDelete(Tournoi t,JPanel vue) {
		this.t = t;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Tournoi";
		
	}
	
	public ControleurDelete(Joueur j,JPanel vue) {
		this.j = j;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.nature = "Joueur";
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Modifier")) {
			if(this.nature == "Equipe"){
				this.v = new VueModifFrame(eq);
				this.v.setVisible(true);
			}else if (this.nature == "Ecurie"){
				this.v = new VueModifFrame(ec);
				this.v.setVisible(true);
			}
			else {
				this.v = new VueModifFrame(j);
				this.v.setVisible(true);
			}
		}
		if(b.getText().equals("Confirmer")) {
			this.modele.getPanelFrame(vue).dispose();
			if(this.nature == "Equipe"){
				Equipe eqNew = ((VueModifPanel) this.vue).getAllInfoEquipe();
				VueInfoPanel.updateInfoEquipe(eqNew.getNom());
				this.modele.modifierEquipe(eqNew);
			}else if (this.nature == "Ecurie"){
				Ecurie ecNew = ((VueModifPanel) this.vue).getAllInfoEcurie();
				VueInfoPanel.updateInfoEcurie(ec.getNom());
				this.modele.modifierEcurie(ecNew);
			}else{
				Joueur jNew = ((VueModifPanel) this.vue).getAllInfoJoueur();
				System.out.println(jNew.getId());
				VueInfoPanel.updateInfoJoueur(jNew);
				this.modele.modifierJoueur(jNew);
			}
		}
		if(b.getText().equals("Annuler")) {
			this.modele.getPanelFrame(vue).dispose();
			}	
	}

	
	
}
