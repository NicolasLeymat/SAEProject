package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import IHM.tournois.VueInscriptionTournois;
import Object.Equipe;
import Object.Phase;
import Object.Tournoi;

public class ControleurInscription implements ActionListener{

	private VueInscriptionTournois vue;
	private ModeleESporter modele;
	
	
	public ControleurInscription(VueInscriptionTournois vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		JButton btn = (JButton) e.getSource();
		Tournoi t = this.vue.getTournoi();
		switch(btn.getText()) {
			case "Confirmer":{
				//System.out.println(this.vue.getAllListEquipesTournoi().size());
				List<Equipe> equipes = this.vue.getAllListEquipesTournoi();
				if(equipes.size() == 16) {
					int resultat = JOptionPane.showConfirmDialog(this.vue, "Souhaitez-vous valider l'inscription ?","Confirmer Inscription", JOptionPane.OK_CANCEL_OPTION);
					if (resultat == JOptionPane.OK_OPTION) {
						for(Equipe equipe : equipes) {
							try {
								t.addEquipe(equipe);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
						try {
							System.out.println(t.getEtat());
							t.demarrer();
							Tournoi.modifierTournoi(t);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						Phase.enregistrerPhase(t.getPhasePoule());
					}
				}
				JFrame frame = this.modele.getPanelFrame(vue);
				frame.dispose();
				break;
			}
		}
	
	}
	
}


