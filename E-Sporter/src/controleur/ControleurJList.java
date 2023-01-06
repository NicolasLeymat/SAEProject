package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import IHM.info.SeeInfoFrame;
import IHM.info.VueInfoTournoisFrame;
import Object.Ecurie;
import Object.Equipe;
import Object.Tournoi;

public class ControleurJList implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		JList<?> list = (JList<?>) e.getSource();
		int index = list.locationToIndex(e.getPoint());
		switch (list.getModel().getElementAt(index).getClass().toString()) {
		case "class Object.Equipe":
			System.out.println(list.getModel().getElementAt(index).toString());
			SeeInfoFrame window = new SeeInfoFrame((Equipe) (list.getModel().getElementAt(index)));
			window.setVisible(true);
			break;
		case "class Object.Ecurie":
			System.out.println(list.getModel().getElementAt(index).getClass().toString());
			SeeInfoFrame windowEcurie = new SeeInfoFrame((Ecurie) list.getModel().getElementAt(index));
			windowEcurie.setVisible(true);
			break;
		case "class Object.Tournoi":
			System.out.println(list.getModel().getElementAt(index).getClass().toString());
			Tournoi tournoiSelected = (Tournoi) list.getModel().getElementAt(index);
			try {
				tournoiSelected.getPhasesfromID();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			VueInfoTournoisFrame windowTournoi = new VueInfoTournoisFrame(tournoiSelected);
			windowTournoi.setVisible(true);
			break;
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
