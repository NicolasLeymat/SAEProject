package controleur;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import IHM.VuePrincipale;

public class SearchControleur implements CaretListener{

	private VuePrincipale vue;
	private ModeleESporter modele;
	
	
	public SearchControleur(VuePrincipale vue) {
		this.vue = vue;
		this.modele = new ModeleESporter();
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		
		
	}

}
