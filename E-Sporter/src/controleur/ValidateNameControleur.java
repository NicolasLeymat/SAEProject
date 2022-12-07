package controleur;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

import IHM.modif.ViewModifPanel;

public class ValidateNameControleur implements CaretListener {

	private ModeleESporter modele;
	private ViewModifPanel vue;
	
	public ValidateNameControleur(ViewModifPanel v) {
		this.vue = v;
		this.modele = new ModeleESporter();
		//ModeleESporter.getAll();
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		JTextField j = (JTextField) e.getSource();
//		if(!this.modele.estNomEquipeDispo(j.getText())) {
//			j.setBorder(new SplitPaneBorder(Color.RED, null));
//		}else {
//			j.setBorder(new SplitPaneBorder(Color.GREEN, null));
//		}
		
		
	}

}
