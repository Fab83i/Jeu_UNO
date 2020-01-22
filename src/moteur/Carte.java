package moteur;

public abstract class Carte {
	
	

	
	public enum Couleur{
		Rouge,
		Bleu,
		Jaune,
		Vert,
		Noir,
		
	}
	
	Couleur couleur;

	public Carte() {
		
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	
	
	

	
	
	
	
	
}
