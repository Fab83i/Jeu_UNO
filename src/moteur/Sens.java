package moteur;

public class Sens extends CarteSpeciale {
	
	private Partie p;
	
	public Sens(Couleur couleur) {
		super();
	}
	
	
	
	
	




	//Utiliser une variable 1 -1
	
	public void chgtSens() {
		if (p.getSens() == -1) {
			p.setSens(1);
		}
		else {
			p.setSens(-1);
		}
		
		
		
		
		
	}

}
