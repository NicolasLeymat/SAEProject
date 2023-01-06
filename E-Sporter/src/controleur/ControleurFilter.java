package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import IHM.MainPanel;
import Object.Ecurie;
import Object.Equipe;
import Object.ModeDeJeu;
import Object.Nationalite;

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
				MainPanel.changeModelElementEquipe(Equipe.getEquipeFromMode(ModeDeJeu.getModeDeJeuFromNom((String) item).getIdMode()));
				break;
			case "Ecurie":
				MainPanel.changeModelElementEcurie(Ecurie.getEcurieFromNat(Nationalite.getByNom((String) item)));
				break;
		}
		//this.vue.updateListEquipe();
		System.out.println(item.toString() + " / " + this.filterType);
		
	}
	
}
