package moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitParameters extends JFrame{
    private JPanel formPane;
    private JPanel groupButton;
    private JPanel information;
    private JButton startButton;
    private JButton returnButton;
    private JComboBox comboBox1;
    private JTextField textName1;
    private JLabel number;
    private JLabel name;
    private JTextField textName2;
    private JTextField textName3;
    private JTextField textName4;




    public InitParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(formPane);
        this.pack();
        this.setPreferredSize(new Dimension(1500, 900));
        this.setTitle("Initialisation");
        this.comboBox1.addItem(new ComboItem("Un Joueur", "1"));
        this.comboBox1.addItem(new ComboItem("Deux Joueurs", "2"));
        this.comboBox1.addItem(new ComboItem("Trois Joueurs", "3"));
        this.comboBox1.addItem(new ComboItem("Quatre Joueurs", "4"));


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInit menuInit = new MenuInit();
                menuInit.setVisible(true);
                InitParameters.this.setVisible(false);
            }
        });


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player newPlayer = new Player(new Partie());
                newPlayer.setVisible(true);
                InitParameters.this.setVisible(false);
            }
        });
    }
}
