package moteur;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JPanelGame extends JPanel {

    private Talon talon;
    private Pile pile;


    public JPanelGame(Partie partie) {
        this.talon = partie.getTalon();
        this.pile = partie.getPile();

    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);

        // AJOUT COULEUR DU BACKGROUND
        this.setBackground(Color.darkGray);

        // AFFICHAGE D'UNE CARTE SUR LE TAPIS
        g.drawImage(pile.getCards().get(3).image, this.getWidth()/2, this.getHeight()/2, null);

    }




}
