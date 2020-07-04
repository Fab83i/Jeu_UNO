package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sens extends CarteSpeciale {

	private BufferedImage imageCarte;
	
	public Sens(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
		try {
			this.imageCarte = ImageIO.read(new File("images/cartesImages/"+ couleur.toString() +"_sens.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		return "Sens ";
	}



}
