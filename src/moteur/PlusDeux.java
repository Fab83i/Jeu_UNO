package moteur;

public class PlusDeux extends CarteSpeciale{
	
	private Talon talon;
	

	

	public PlusDeux(Couleur couleur) {
		super();
		
		
		
	}
	
	

	public void PlusD(Joueur j) {
		j.pioche(talon);
		j.pioche(talon);

		
	}

	
	

}
