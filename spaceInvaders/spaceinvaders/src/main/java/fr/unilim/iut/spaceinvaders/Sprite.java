package fr.unilim.iut.spaceinvaders;

public abstract class Sprite {

	protected Position origine;
	protected Dimension dimension;
	protected int vitesse;

	public  Sprite(Dimension dimension, Position origine, int vitesse)  {
		super();
		this.dimension = dimension;
		this.origine = origine;
		this.vitesse = vitesse;
	}

	public Sprite() {
		super();
	}

	public boolean occupeLaPosition(int x, int y) {
	    return estAbscisseCouverte(x) && estOrdonneeCouverte(y);
	}

	private boolean estOrdonneeCouverte(int y) {
	   return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private boolean estAbscisseCouverte(int x) {
	   return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int ordonneeLaPlusBasse() {
	    return this.getOrigine().ordonnee() - this.dimension.hauteur() + 1;
	}

	public int ordonneeLaPlusHaute() {
		   return this.getOrigine().ordonnee();
	   }

	public int abscisseLaPlusADroite() {
		   return this.getOrigine().abscisse() + this.dimension.longueur() - 1;
	   }

	public int abscisseLaPlusAGauche() {
		   return this.getOrigine().abscisse();
	   }

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse() + getVitesse());
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse() - getVitesse());
	}

	public void positionner(int x, int y) {
		   this.getOrigine().changerAbscisse(x);
		   this.getOrigine().changerOrdonnee(y);
	   }

	public Position getOrigine() {
		return origine;
	}

	public int hauteur() {
		return this.dimension.hauteur();
	}

	public int longueur() {
		return this.dimension.longueur();
	}

	public int getVitesse() {
		return vitesse;
	}

}