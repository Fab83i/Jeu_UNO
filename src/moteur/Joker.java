package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Joker extends CarteSpeciale{

	private BufferedImage imageCarte;

	public Joker(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
		try {
			this.imageCarte = ImageIO.read(new File("images/cartesImages/joker.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Joker ";
	}

}
