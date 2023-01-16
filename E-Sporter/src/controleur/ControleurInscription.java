package controleur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import IHM.MainPanel;
import IHM.add.AddPanel;
import IHM.info.VueInfoPanel;
import IHM.tournois.VueInscriptionTournois;
import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;

public class ControleurInscription implements ActionListener{

	private VueInscriptionTournois vue;
	private ModeleESporter modele;
	
	public ControleurInscription(VueInscriptionTournois vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText() == "Ajouter") {
				Equipe obj = (Equipe) this.vue.getInfoToObject();
				Tournoi t = this.vue.getTournoi();
				JFrame frame = this.modele.getPanelFrame(vue);
				this.modele.addParticipation(obj,t);
				VueInscriptionTournois.updateListEquipe(t);
		}
		if (btn.getText() == "Supprimer") {
			Equipe obj = (Equipe) this.vue.getListEquipesTournoi();
			Tournoi t = this.vue.getTournoi();
			JFrame frame = this.modele.getPanelFrame(vue);
			this.modele.deleteParticipation(obj,t);
			VueInscriptionTournois.updateListEquipe(t);
		}
	}
}


