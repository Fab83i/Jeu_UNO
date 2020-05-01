package moteur;

public class CarteClassique extends Carte {

	private int numero;

	public CarteClassique(Couleur couleur, int numero, int points) {

		super(couleur, points);
		this.numero = numero;

	}

	@Override
	public String toString() {
		return "CarteClassique []";
	}

	public int getNumero() {
		return numero;
	}

}
