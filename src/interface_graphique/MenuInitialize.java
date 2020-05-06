package interface_graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class MenuInitialize extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInitialize frame = new MenuInitialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInitialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel lancement = new JPanel();
		contentPane.add(lancement, BorderLayout.CENTER);
		lancement.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnJouer = new JButton("Jouer");
		lancement.add(btnJouer);
		
		JButton btnRegles = new JButton("Régles du jeu");
		lancement.add(btnRegles);
		
		JPanel poweredBy = new JPanel();
		contentPane.add(poweredBy, BorderLayout.SOUTH);
		
		JLabel lblPoweredByFabi = new JLabel("Powered by Fabi");
		poweredBy.add(lblPoweredByFabi);
	}

}
