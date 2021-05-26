package fr.unilim.iut.spaceinvaders;

public class Vaisseau extends Sprite {

	public Vaisseau(int longueur, int hauteur) {
	    this(longueur, hauteur, 0, 0);
    }

   public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this(new Dimension(longueur, hauteur), new Position(x, y));
    }

	public Vaisseau(Dimension dimension, Position positionOrigine) {
		this(dimension, positionOrigine, 1);
	}
   
	public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse);
	} 

	public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);
		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}
	
	public Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

		int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		return new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
	}
}