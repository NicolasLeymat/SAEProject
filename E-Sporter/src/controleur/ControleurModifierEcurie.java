package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import IHM.ViewModifFrame;
import Object.Ecurie;
import Object.Equipe;

public class ControleurModifierEcurie implements ActionListener{

	private JPanel vue;
	private Ecurie eq;
	private ModeleESporter modele;
	private ViewModifFrame v;
	
	public ControleurModifierEcurie(Ecurie eq,JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		//v = new ViewModifFrame(eq);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Modifier")) {
			this.v = new ViewModifFrame(eq);
			this.v.setVisible(true);
		}
		if(b.getText().equals("confirmer")) {
			vue.setVisible(false);
			this.eq.setNom("");
			this.modele.modifierEcurie(eq);
		}
		if(b.getText().equals("Annuler")) {
			this.v.setVisible(false);
		}	
	}
}
