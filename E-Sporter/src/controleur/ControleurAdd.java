package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import IHM.add.AddFrame;
import IHM.add.AddPanel;

public class ControleurAdd implements ActionListener{
	
	private JPanel vue;
	private ModeleESporter modele;
	private AddFrame frame;
	private Object obj;
	
	public ControleurAdd(JPanel v, Object obj) {
		this.vue = v;
		this.modele = new ModeleESporter();
		this.frame = null;
		this.obj = obj;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getText()) {
			case "Ajouter un joueur":{
				this.frame = new AddFrame("Player", this.obj);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter une équipe":{
				this.frame = new AddFrame("Team", this.obj);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter une écurie":{
				this.frame = new AddFrame("Orga", null);
				this.frame.setVisible(true);
				break;
			}
			case "Ajouter un tounoi":{
				this.frame = new AddFrame("Tournament", null);
				this.frame.setVisible(true);
				break;
			}
		}
		
		
	}

}
