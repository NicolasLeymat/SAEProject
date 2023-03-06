package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import IHM.info.SeeInfoFrame;
import IHM.info.VueInfoTournoisFrame;
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
			
		switch(name) {
		case "Equipe":{
			if (VueInscriptionTournois.listEquipesTournoi.getModel().getSize() < 16) {
		
			Equipe eq = (Equipe) this.vue.getInfoToObject();
			this.modele.addParticipation(eq,t);
			VueInscriptionTournois.updateListEquipe(t);
			break;
		}
		}
		case "EquipeTournoi":{
			
			if ( VueInscriptionTournois.listEquipesTournoi.getModel().getSize() > 0){
			
			Equipe eq = (Equipe) this.vue.getListEquipesTournoi();
			if(eq != null) {
				this.modele.deleteParticipation(eq,t);
				VueInscriptionTournois.updateListEquipe(t);
			}
			break;
		}
		}
	}
		
}
}
