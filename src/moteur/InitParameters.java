package moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private JButton validBtn;
    ArrayList<String> listPrenoms;


    public InitParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(formPane);
        this.pack();
        this.setPreferredSize(new Dimension(1500, 900));
        this.setTitle("Initialisation");

        this.comboBox1.addItem(new ComboItem("Un Joueur", 1));
        this.comboBox1.addItem(new ComboItem("Deux Joueurs", 2));
        this.comboBox1.addItem(new ComboItem("Trois Joueurs", 3));
        this.comboBox1.addItem(new ComboItem("Quatre Joueurs", 4));

        /*
        Sélection des prénoms en fonction du nombre de joueurs.
        Ajout à la liste de String listPrenoms
         */
        listPrenoms = new ArrayList<>();

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
                Player newPlayer = new Player(InitParameters.this.comboBox1.getSelectedIndex() + 1, InitParameters.this.listPrenoms);
                newPlayer.setVisible(true);
                InitParameters.this.setVisible(false);
            }
        });
        validBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(comboBox1.getSelectedIndex()){

                    case 0 :
                        listPrenoms.add(textName1.getText());
                    case 1 :
                        listPrenoms.add(textName1.getText());
                        listPrenoms.add(textName2.getText());
                    case 2 :
                        listPrenoms.add(textName1.getText());
                        listPrenoms.add(textName2.getText());
                        listPrenoms.add(textName3.getText());
                    case 3 :
                        listPrenoms.add(textName1.getText());
                        listPrenoms.add(textName2.getText());
                        listPrenoms.add(textName3.getText());
                        listPrenoms.add(textName4.getText());

                }
                System.out.println("le NbJoueurs est : " + comboBox1.getSelectedIndex());
            }
        });
    }
}
