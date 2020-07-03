package moteur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class JPanelImage extends JPanel {
    private static final long serialVersionUID = 3641337531772753865L;
    private String sNomImage;
    private Image image = null;

    public JPanelImage() {
        this.sNomImage = null;
    }

    public JPanelImage(String sNom) {
        this.sNomImage = sNom;
        this.chargerImage();
    }

    public void setImage(String sNom) {
        this.sNomImage = sNom;
        this.chargerImage();
    }

    private void chargerImage() {
        if (this.sNomImage != null) {
            String sNomFile = ".\\images\\" + this.sNomImage;

            try {
                this.image = ImageIO.read(new File(sNomFile));
            } catch (IOException var3) {
                this.image = null;
            }
        }

        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), (ImageObserver)null);
        }

    }

}
