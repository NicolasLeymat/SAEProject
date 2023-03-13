package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import IHM.champ.ChampFrame;

public class ControleurChamp implements ActionListener{
	
	private ChampFrame frame;
	
	public ControleurChamp() {
		this.frame = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getText()) {
			case "Championnat du monde":{
				this.frame = new ChampFrame();
				this.frame.setVisible(true);
				break;
			}
		}
	}
}