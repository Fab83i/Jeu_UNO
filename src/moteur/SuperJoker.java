package moteur;

public class SuperJoker extends CarteSpeciale {
	
	private Talon talon;
	
	public SuperJoker(Couleur couleur) {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void supJok(Joueur j , Couleur couleur) {
		
		for (int i=0 ; i<4 ; i++) {
			j.pioche(talon);
		}
		super.setCouleur(couleur);
		
		
		
	}



	@Override
	public String toString() {
		return "SuperJoker []";
	}
	
	

	

}
