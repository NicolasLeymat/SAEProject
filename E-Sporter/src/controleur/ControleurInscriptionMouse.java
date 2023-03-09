package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import IHM.info.SeeInfoFrame;
import IHM.info.VueInfoTournoisEnCoursFrame;
import IHM.tournois.FrameClassementTournois;
import IHM.tournois.FrameInscriptionTournois;
import IHM.tournois.VueInscriptionTournois;
import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;

public class ControleurInscriptionMouse extends MouseListenerImp {

	private VueInscriptionTournois vue;
	private ModeleESporter modele;
	private String name;
	
	public ControleurInscriptionMouse(VueInscriptionTournois vue, String name) {
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.name = name;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Tournoi t =this.vue.getTournoi();

		//activation si double click
		if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
			dbClickAjoutRetrait(t);
		}

	}

	private void dbClickAjoutRetrait(Tournoi t) {
		switch(name) {
		case "Equipe":{
			if (this.vue.getAllListEquipesTournoi().size() < 16) {
			Equipe eq = (Equipe) this.vue.getInfoToObject();
			VueInscriptionTournois.addListEquipeTournoi(eq);
			this.modele.addParticipation(eq, t);
			VueInscriptionTournois.updateListEquipe(t);
		}
			break;
		}
		case "EquipeTournoi":{

			if ( this.vue.getAllListEquipesTournoi().size() > 0){

			Equipe eq = (Equipe) this.vue.getListEquipesTournoi();
			if(eq != null) {
				VueInscriptionTournois.delListEquipeTournoi(eq);
				this.modele.deleteParticipation(eq, t);
				VueInscriptionTournois.updateListEquipe(t);
			}
			break;
		}
		}
	}
	}
}
