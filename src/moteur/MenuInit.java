package moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInit extends JFrame{
    private JPanel menu;
    private JPanel logo_info;
    private JPanel buttons;
    private JButton rulesButton;
    private JButton playButton;


    public MenuInit() {


        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RulesPanel mrp = new RulesPanel();
                mrp.setVisible(true);
                MenuInit.this.setVisible(false);

            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitParameters tableInit = new InitParameters();
                tableInit.setVisible(true);
                MenuInit.this.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        MenuInit mjf = new MenuInit();
        mjf.setContentPane(new MenuInit().menu);
        mjf.setTitle("Jeu Uno");
        mjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mjf.pack();
        mjf.setVisible(true);

    }


}
