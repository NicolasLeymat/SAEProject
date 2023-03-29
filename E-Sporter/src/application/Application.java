package application;

import ihm.App;

public class Application {

	public static void main(String[] args) {
				try {
					App window = new App();
					window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}
