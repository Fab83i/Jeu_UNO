package moteur;

import java.awt.image.BufferedImage;

public abstract class Carte {

	Couleur couleur;
	int points;
	BufferedImage image;

	public Carte(Couleur couleur, int points) {
		this.couleur = couleur;
		this.points = points;


	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public int getPoints() {
		return this.points;
	}

	@Override
	public String toString() {
		return "Carte [toString()=" + super.toString() + "]";
	}

}
