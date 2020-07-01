package moteur;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame {
    private JPanel mainPanel;
    private JPanel menuRetour;
    private JButton btnRetourMenu;


    public Player(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setPreferredSize(new Dimension(1500, 900));
        this.setTitle("Nouvelle partie");

    }
}
