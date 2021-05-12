package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.*;

public class SpaceInvaders {
      private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	int longueur;
      int hauteur;
      Vaisseau vaisseau;

      public SpaceInvaders(int longueur, int hauteur) {
           this.longueur = longueur;
           this.hauteur = hauteur;
       }

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
		    for (int x = 0; x < longueur; x++) {
		        espaceDeJeu.append(recupererMarqueDeLaPosition(x,y));
		    }
		    espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}
      
      

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
        return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
    }

    private boolean aUnVaisseau() {
        return vaisseau!=null;
    }
    
    private char recupererMarqueDeLaPosition(int x,int y) {
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
            return MARQUE_VAISSEAU;
        else
            return MARQUE_VIDE;
    }


	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}
    
	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1))
			vaisseau.seDeplacerVersLaDroite();
	}
   	
   	public void deplacerVaisseauVersLaGauche() {
        if (vaisseau.abscisseLaPlusAGauche() > 0) vaisseau.seDeplacerVersLaGauche();
	}
    

	public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		if ( !estDansEspaceJeu(x+longueur-1,y))
			throw new DebordementEspaceJeuException("Le vaisseau d�borde de l'espace jeu vers la droite � cause de sa longueur");
		if (!estDansEspaceJeu(x,y-hauteur+1))
			throw new DebordementEspaceJeuException("Le vaisseau d�borde de l'espace jeu vers le bas � cause de sa hauteur");

		vaisseau = new Vaisseau(longueur, hauteur);
		vaisseau.positionner(x, y);
	}
	
    
}