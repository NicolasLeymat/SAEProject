package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import IHM.modif.VueModifFrame;
import Object.Ecurie;
import Object.Equipe;

public class ControleurModif implements ActionListener{

	private JPanel vue;
	private Equipe eq;
	private Ecurie ec;
	private ModeleESporter modele;
	private VueModifFrame v;
	private boolean Equipe;
	
	public ControleurModif(Equipe eq,JPanel vue) {
		this.eq = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.Equipe = true;
		
	}
	
	public ControleurModif(Ecurie eq,JPanel vue) {
		this.ec = eq;
		this.vue = vue;
		this.modele = new ModeleESporter();
		this.Equipe = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Modifier")) {
			this.v = new VueModifFrame(eq);
			this.v.setVisible(true);
		}
		if(b.getText().equals("confirmer")) {
			vue.setVisible(false);
			if(this.Equipe){
				Equipe eqNew = new Equipe(null);
				this.modele.modifierEquipe(eqNew);
			}else{
				Ecurie eqNew = new Ecurie(null);
				this.modele.modifierEcurie(eqNew);
			}
		}
		if(b.getText().equals("Annuler")) {
			this.v.setVisible(false);
		}	
	}

	
	
}
