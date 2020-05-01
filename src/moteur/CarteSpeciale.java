package moteur;

public abstract class CarteSpeciale extends Carte {
	
	boolean effect;

	public CarteSpeciale(Couleur couleur, int points, boolean effect) {
		super(couleur, points);
		this.effect = effect;
		// TODO Auto-generated constructor stub
	}

	public boolean getEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}
	
	

}
