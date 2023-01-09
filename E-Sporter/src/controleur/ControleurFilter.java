package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import IHM.MainPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.ModeDeJeu;
import Object.Nationalite;
import Object.Tournoi;
import Object.Tournoi.ETAT;

public class ControleurFilter<E> implements ActionListener{

	private String filterType;
	private MainPanel vue;
	
	public ControleurFilter(String filterType, MainPanel vue) {
		this.vue = vue;
		this.filterType = filterType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<E> comboBox = (JComboBox<E>) e.getSource();
		int index = comboBox.getSelectedIndex();
		E item = comboBox.getItemAt(index);
		switch(this.filterType) {
			case "Equipe":
				if(item.equals("Sans filtre")) {
					MainPanel.changeModelElementEquipe(Equipe.getAllEquipes());
					return;
				}
				MainPanel.changeModelElementEquipe(Equipe.getEquipeFromMode(ModeDeJeu.getModeDeJeuFromNom((String) item).getIdMode()));
				break;
			case "Ecurie":
				if(item.equals("Sans filtre")) {
					MainPanel.changeModelElementEcurie(Ecurie.getAllEcuries());
					return;
				}
				MainPanel.changeModelElementEcurie(Ecurie.getEcurieFromNat(Nationalite.getByNom((String) item)));
				break;
			case "Tournament":
				ETAT etat = null;
				switch ((String)item) {
					case "Sans filtre":
						MainPanel.changeModelElementTournoi(Tournoi.getAllTournois());
						return;
					case "Phase d'inscription":
						etat = ETAT.INSC;
						break;
					case "En cours":
						etat = ETAT.EN_COURS;
						break;
					case "Terminés":
						etat = ETAT.FINI;
						break;
				}
				MainPanel.changeModelElementTournoi(Tournoi.getTournoiWithFilter(etat));
				break;
		}
		//this.vue.updateListEquipe();
		System.out.println(item.toString() + " / " + this.filterType);
		
	}
	
}
