package IHM.add;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddFrame extends JFrame {

	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	private AddPanel contentPane;
	private String mode;
	private Object obj;
	
	/**
	 * Create the frame.
	 */
	public AddFrame(String type, Object obj) {
		this.obj = obj;
		this.setMode(type);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new AddPanel(type, this.obj);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}


	public String getMode() {
		return mode;
	}

	public void setMode(String type) {
		this.mode = type;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	

}
