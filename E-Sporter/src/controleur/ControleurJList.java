package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import IHM.info.SeeInfoFrame;
import IHM.info.VueInfoTournoisFrame;
import IHM.tournois.FrameClassementTournois;
import IHM.tournois.FrameInscriptionTournois;
import Object.Ecurie;
import Object.Equipe;
import Object.Joueur;
import Object.Tournoi;

public class ControleurJList extends MouseListenerImp {

	@Override
	public void mouseClicked(MouseEvent e) {
		JList<?> list = (JList<?>) e.getSource();
		int index = list.locationToIndex(e.getPoint());
		Object element = list.getModel().getElementAt(index);
		String classObject = element.getClass().toString();
		switch (classObject) {
		case "class Object.Equipe":
			SeeInfoFrame window = new SeeInfoFrame((Equipe) (element));
			window.setVisible(true);
			break;
		case "class Object.Ecurie":
			SeeInfoFrame windowEcurie = new SeeInfoFrame((Ecurie) element);
			windowEcurie.setVisible(true);
			break;
		case "class Object.Tournoi":
			Tournoi tournoiSelected = (Tournoi) element;
			try {
				tournoiSelected.getPhasesFromId();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			JFrame windowTournoi = null;
			switch (tournoiSelected.getEtat())  {
				case FINI :
					windowTournoi = new FrameClassementTournois(tournoiSelected);
				break;

				case INSC:
					windowTournoi = new FrameInscriptionTournois(tournoiSelected);
				break;

				case ENC:
					windowTournoi = new VueInfoTournoisFrame(tournoiSelected);
				break;
			}
			windowTournoi.setVisible(true);
			break;
		case "class Object.Joueur":
			SeeInfoFrame windowJoueur = new SeeInfoFrame((Joueur) element);
			windowJoueur.setVisible(true);
			break; 
		}

	}
}
