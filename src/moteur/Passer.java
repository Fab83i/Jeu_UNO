package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Passer extends CarteSpeciale{

	private BufferedImage imageCarte;

	public Passer(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
		try {
			this.imageCarte = ImageIO.read(new File("images/cartesImages/"+ couleur.toString() +"_passer.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Passer ";
	}
	
	

}
