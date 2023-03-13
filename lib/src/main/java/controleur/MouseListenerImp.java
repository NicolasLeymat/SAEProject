package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class MouseListenerImp implements MouseListener{
	
	@Override
	public abstract void mouseClicked(MouseEvent e);
	@Override
	public void mousePressed(MouseEvent e) {
		//Methode non utilisé
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//Methode non utilisé
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//Methode non utilisé
	}
	@Override
	public void mouseExited(MouseEvent e) {
		//Methode non utilisé
	}
}
