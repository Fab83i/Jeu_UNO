package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlusDeux extends CarteSpeciale{
	
	private Talon talon;
	private BufferedImage imageCarte;


	public PlusDeux(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
		try {
			this.imageCarte = ImageIO.read(new File("images/cartesImages/"+ couleur.toString() +"_PlusDeux.png" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void PlusD(Joueur j) {
		j.pioche(talon);
		j.pioche(talon);

		
	}



	@Override
	public String toString() {
		return "PlusDeux ";
	}
	
	

	
	

}
