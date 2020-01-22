package moteur;

public abstract class Carte {
	
	
	private Partie p;

	
	public enum Couleur{
		Rouge,
		Bleu,
		Jaune,
		Vert,
		Noir,
		
	}
	
	Couleur coul;

	public Carte() {
		
	}
	
	public void setCouleur(Couleur couleur) {
		this.coul = couleur;
	}

	public Couleur getCouleur() {
		return coul;
	}

	
	
	

	
	
	
	
	
}
