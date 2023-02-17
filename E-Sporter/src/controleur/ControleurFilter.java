package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import IHM.MainPanel;
import IHM.champ.ChampPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.ModeDeJeu;
import Object.Nationalite;
import Object.Tournoi;
import Object.Tournoi.EtatTournoi;

public class ControleurFilter<E> implements ActionListener{

	private String filterType;
	
	public ControleurFilter(String filterType) {
		this.filterType = filterType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")
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
				EtatTournoi etat = null;
				switch ((String)item) {
					case "Sans filtre":
						MainPanel.changeModelElementTournoi(Tournoi.getAllTournois());
						return;
					case "Phase d'inscription":
						etat = EtatTournoi.INSC;
						break;
					case "En cours":
						etat = EtatTournoi.ENC;
						break;
					case "Terminés":
						etat = EtatTournoi.FINI;
						break;
				}
				MainPanel.changeModelElementTournoi(Tournoi.getTournoiWithFilter(etat));
				break;
			case "Championnat":
				ChampPanel.changeModelResultChamp(Equipe.getClassementByGame(ModeDeJeu.getModeDeJeuFromNom((String) item).getIdMode()));
				System.out.println(Equipe.getClassementByGame(ModeDeJeu.getModeDeJeuFromNom((String) item).getIdMode()));
				break;
		}
		
	}
	
}
