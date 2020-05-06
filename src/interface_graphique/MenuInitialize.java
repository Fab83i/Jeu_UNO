package interface_graphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

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
		lancement.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel logo = new JLabel("logo");
		ImageIcon png = new ImageIcon("/Users/Fab83i/Documents/Java_Uno/Uno_Project/images/logo.png");
		
		logo.setIcon(png);
		lancement.add(logo);
		
		
		
		
		
		
		JPanel poweredBy = new JPanel();
		contentPane.add(poweredBy, BorderLayout.SOUTH);
		
		JLabel lblPoweredByFabi = new JLabel("Powered by Fabi");
		poweredBy.add(lblPoweredByFabi);
		
		JPanel menu = new JPanel();
		contentPane.add(menu, BorderLayout.EAST);
		menu.setLayout(new GridLayout(2, 1, 0, 0));
		
		
		JButton btnJouer = new JButton("Jouer");
		menu.add(btnJouer);
		
		JButton btnRegles = new JButton("Régles du jeu");
		menu.add(btnRegles);
	}

}
