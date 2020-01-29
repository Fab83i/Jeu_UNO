package moteur;

public abstract class Carte {
	
	
	
	

	Couleur couleur;
	protected static int points ;
	

	public Carte(Couleur couleur, int points) {
		this.couleur = couleur;
		Carte.points = points;
		
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public int getPoints() {
		return Carte.points;
	}

	@Override
	public String toString() {
		return "Carte [toString()=" + super.toString() + "]";
	}

	
	

	
	
	

	
	
	
	
	
}
