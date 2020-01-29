package moteur;

public class PlusDeux extends CarteSpeciale{
	
	private Talon talon;
	

	

	public PlusDeux(Couleur couleur, int points) {
		super(couleur, points);
		
		
		
	}
	
	

	public void PlusD(Joueur j) {
		j.pioche(talon);
		j.pioche(talon);

		
	}



	@Override
	public String toString() {
		return "PlusDeux []";
	}
	
	

	
	

}
