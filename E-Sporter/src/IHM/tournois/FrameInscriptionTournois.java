package IHM.tournois;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Tournoi;
import controleur.ModeleESporter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameInscriptionTournois extends JFrame {

	private VueInscriptionTournois contentPane;

	/**
	 * Create the frame.
	 */
	public FrameInscriptionTournois(Tournoi t) {
		setBounds(100, 100, 600, 450);
		contentPane = new VueInscriptionTournois(t);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
	}

}
