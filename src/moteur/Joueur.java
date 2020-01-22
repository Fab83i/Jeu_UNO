package moteur;

import java.util.ArrayList;

public abstract class Joueur {
	
	
	private ArrayList<Carte> carteEnMain;
	
	

	public ArrayList<Carte> getCarteEnMain() {
		return carteEnMain;
	}

	public void setCarteEnMain(ArrayList<Carte> carteEnMain) {
		this.carteEnMain = carteEnMain;
	}
	

	
	

	public void pioche (Talon talon) {
		
		carteEnMain = new ArrayList<Carte>();
		
		Carte carte = talon.carteAuPif();
		carteEnMain.add(carte);
		talon.getCards().remove(carte);
	}

	

	
	
	

}
