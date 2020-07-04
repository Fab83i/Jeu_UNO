package moteur;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarteClassique extends Carte {

	private int numero;
	private BufferedImage imageCarte;

	public CarteClassique(Couleur couleur, int numero, int points) {

		super(couleur, points);
		this.numero = numero;
				try {
					this.imageCarte = ImageIO.read(new File("images/cartesImages/"+ couleur.toString() +"_" + numero + ".png" ));
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	@Override
	public String toString() {
		return "CarteClassique ";
	}

	public int getNumero() {
		return numero;
	}

}
