package moteur;

public class SuperJoker extends CarteSpeciale {
	
	
	public SuperJoker(Couleur couleur) {
		super();
		// TODO Auto-generated constructor stub
	}

	private Talon talon;
	
	public void supJok(Joueur j , Couleur couleur) {
		
		for (int i=0 ; i<5 ; i++) {
			j.pioche(talon);
		}
		super.setCouleur(couleur);
		
		
		
	}

	

}
