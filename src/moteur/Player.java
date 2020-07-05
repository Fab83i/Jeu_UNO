package moteur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JFrame {
    private JPanel mainPanel;
    private JPanel menuRetour;
    private JButton btnRetourMenu;
    private JPanel mainPlayer;
    private JPanel adversairePanel;
    private JPanel gamePanel;
    private JPanel myCardsPanel;


    public Player(int nbJoueur, ArrayList<String> listPrenoms){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setPreferredSize(new Dimension(1500, 900));
        this.setTitle("Nouvelle partie");
        Partie p = new Partie(nbJoueur, listPrenoms);
        this.gamePanel = new JPanelGame(p);

    }
}
