package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

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
        
      @Override
        public String toString() {
            return recupererEspaceJeuDansChaineASCII();
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

	public void positionnerUnNouveauVaisseau(int x, int y) {
		
		if (  !estDansEspaceJeu(x, y) )
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 

	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}
    
   	public void deplacerVaisseauVersLaDroite() {
        if (vaisseau.getX() < (longueur-1)) vaisseau.seDeplacerVersLaDroite();
	}
    
    
}