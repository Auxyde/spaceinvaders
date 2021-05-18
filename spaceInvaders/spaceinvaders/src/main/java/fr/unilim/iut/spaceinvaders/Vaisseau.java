package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

    private Position origine;
    private Dimension dimension;

    public Vaisseau(int longueur, int hauteur) {
	    this(longueur, hauteur, 0, 0);
    }

   public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this(new Dimension(longueur, hauteur), new Position(x, y));
    }

    public Vaisseau(Dimension dimension, Position positionOrigine) {
	    this.dimension = dimension;
	    this.origine = positionOrigine;
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

    private int ordonneeLaPlusBasse() {
	    return this.getOrigine().ordonnee() - this.dimension.hauteur() + 1;
    }

    private int ordonneeLaPlusHaute() {
	   return this.getOrigine().ordonnee();
   }

   public int abscisseLaPlusADroite() {
	   return this.getOrigine().abscisse() + this.dimension.longueur() - 1;
   }

   public int abscisseLaPlusAGauche() {
	   return this.getOrigine().abscisse();
   }

   public void seDeplacerVersLaDroite() {
	   this.getOrigine().changerAbscisse(this.getOrigine().abscisse() + 1);
   }

   public void seDeplacerVersLaGauche() {
	   this.getOrigine().changerAbscisse(this.getOrigine().abscisse() - 1);
   }

   public void positionner(int x, int y) {
	   this.getOrigine().changerAbscisse(x);
	   this.getOrigine().changerOrdonnee(y);
   }

public Position getOrigine() {
	return origine;
}

}