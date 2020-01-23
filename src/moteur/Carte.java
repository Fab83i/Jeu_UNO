package moteur;

public abstract class Carte {
	
	
	
	Couleur couleur;

	public Carte(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	
	
	

	
	
	
	
	
}
