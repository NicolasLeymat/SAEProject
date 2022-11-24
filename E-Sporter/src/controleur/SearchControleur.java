package controleur;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import IHM.MainPanel;
import IHM.VuePrincipale;
import Object.Ecurie;
import Object.Equipe;

public class SearchControleur implements CaretListener{

	private VuePrincipale vue;
	private ModeleESporter modele;
	public static List<Ecurie> rechercheEcurie = new LinkedList<>();
	public static List<Equipe> rechercheEquipe = new LinkedList<>();

	
	public SearchControleur(VuePrincipale vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		JTextField j = (JTextField) e.getSource();
		ModeleESporter.resultatRechercheEquipes.clear();
		ModeleESporter.resultatRechercheEcuries.clear();
		rechercheEcurie.clear();
		rechercheEquipe.clear();
		String prompt = j.getText();
		//System.out.println(prompt);
		this.modele.setLastRecherche(this.modele.getRechercheEcurie(prompt), this.modele.getRecherche(prompt));
		rechercheEcurie.addAll(ModeleESporter.resultatRechercheEcuries);
		rechercheEquipe.addAll(ModeleESporter.resultatRechercheEquipes);
		//System.out.println(ModeleESporter.resultatRechercheEcuries.toString() + ModeleESporter.resultatRechercheEquipes.toString());
		MainPanel.changeModelElementEquipe(rechercheEquipe);
		MainPanel.changeModelElementEcurie(rechercheEcurie);
	}

}
