package moteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesPanel extends JFrame {
    private JButton returnButton;
    private JTextPane rulesText;
    private JPanel contentPane;
    private JTextPane plusDeuxContenu;
    private JTextPane sensContenu;
    private JTextPane passeContenu;
    private JTextPane jokerContenu;
    private JTextPane superJokerContenu;

    public RulesPanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.pack();
        this.setPreferredSize(new Dimension(1500, 900));
        this.setTitle("Règles du jeu");

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuInit retour = new MenuInit();
                retour.setVisible(true);
                RulesPanel.this.setVisible(false);
            }
        });
    }
}
