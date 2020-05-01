package moteur;

public class Sens extends CarteSpeciale {
	
	private Partie p;
	
	public Sens(Couleur couleur, int points, boolean effect) {
		super(couleur, points, effect);
	}
	
	
	
	


	//Utiliser une variable 1 -1
	
	@Override
	public String toString() {
		return "Sens []";
	}






	public void chgtSens() {
		if (p.getSens() == -1) {
			p.setSens(1);
		}
		else {
			p.setSens(-1);
		}
		
		
		
		
		
	}

}
