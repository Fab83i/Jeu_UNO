package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SuperJoker extends CarteSpeciale {

	private BufferedImage imageCarte;

	public SuperJoker(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
		try {
			this.imageCarte = ImageIO.read(new File("images/cartesImages/SuperJoker.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return "SuperJoker ";
	}

}
