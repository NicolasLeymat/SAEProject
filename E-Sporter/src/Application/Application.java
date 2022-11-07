package Application;

import java.awt.EventQueue;


import IHM.VuePrincipale;

public class Application {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VuePrincipale window = new VuePrincipale();
					window.getframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
