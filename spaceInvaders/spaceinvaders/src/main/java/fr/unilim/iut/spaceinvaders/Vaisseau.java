package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	private Position origine;
	private Dimension dimension;
	private int vitesse;
    

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
		this.dimension = dimension;
		this.origine = positionOrigine;
		this.vitesse = vitesse;
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