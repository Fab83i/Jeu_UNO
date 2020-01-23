package moteur;

public class CarteClassique extends Carte {
	
	
	
	private int numero;
	
	
	public CarteClassique( Couleur couleur , int numero) {
		
		super(couleur);
		this.numero = numero;
		
	}
	


	public int getNumero() {
		return numero;
	}



	@Override
	public String toString() {
		return "CarteClassique []";
	}



	
	
	
	
	
	
	
	
	

}
