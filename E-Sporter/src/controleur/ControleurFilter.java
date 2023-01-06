package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ControleurFilter<E> implements ActionListener{

	private String filterType;
	
	public ControleurFilter(String filterType) {
		this.filterType = filterType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<E> comboBox = (JComboBox<E>)e.getSource();
		int index = comboBox.getSelectedIndex();
		E item = comboBox.getItemAt(index);
		System.out.println(item.toString() + " / " + this.filterType);
		
	}
	
}
