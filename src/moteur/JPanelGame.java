package moteur;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JPanelGame extends JPanel {
    private BufferedImage image;
    private BufferedImage carteTalon;
    private BufferedImage cartePile;
    private Talon talon;
    private Pile pile;


    public JPanelGame(Partie partie){
        this.talon = partie.getTalon();
        this.pile = partie.getPile();

        try


    }
}
