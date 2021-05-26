package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

import org.junit.Before;

public class SpaceInvadersTest {

    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
	    spaceinvaders = new SpaceInvaders(15, 10);
    }
    
    
    @Test
    public void test_MissileBienTireDepuisVaisseau_VaisseauLongueurImpaireMissileLongueurImpaire() {

	   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
	   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

      assertEquals("" + 
      "...............\n" + 
      "...............\n" +
      "...............\n" + 
      "...............\n" + 
      "...............\n" + 
      "...............\n" + 
      ".......^^.....\n" + 
      ".......^^.....\n" + 
      ".....VVVVVV...\n" + 
      ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
   }
    
    @Test(expected = MissileException.class)
	public void test_LongueurMissileSuperieureALongueurVaisseau_UneExceptionEstLevee() throws Exception {
		Vaisseau vaisseau = new Vaisseau(new Dimension(5,2),new Position(5,9), 1);
		vaisseau.tirerUnMissile(new Dimension(7,2),1);
	}
    
    @Test(expected = MissileException.class)
	public void test_PasAssezDePlacePourTirerUnMissile_UneExceptionEstLevee() throws Exception { 
	   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
	   spaceinvaders.tirerUnMissile(new Dimension(7,9),1);
	}
    
    @SuppressWarnings("serial")
    public class MissileException extends RuntimeException {
	
	    public MissileException(String message) {
		   super(message);
	    }
    }
    
    
    
     @Test
       public void test_AuDebut_JeuSpaceInvaderEstVide() {
            assertEquals("" + 
            "...............\n" + 
            "...............\n" +
            "...............\n" + 
            "...............\n" + 
            "...............\n" + 
            "...............\n" + 
            "...............\n" + 
            "...............\n" + 
            "...............\n" + 
            "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
            }
     
     @Test
 		public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
 			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2), new Position(7,9));
 			assertEquals("" + 
 			"...............\n" + 
 			"...............\n" +
 			"...............\n" + 
 			"...............\n" + 
 			"...............\n" + 
 			"...............\n" + 
 			"...............\n" + 
 			"...............\n" + 
 			".......VVV.....\n" + 
 			".......VVV.....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
 		}
     
     
     @Test
     public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
    	 
    	 spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(12,9), 1);
    	 spaceinvaders.deplacerVaisseauVersLaDroite();
    	 assertEquals("" + 
    			 "...............\n" + 
    			 "...............\n" +
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "............VVV\n" + 
    			 "............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }

     public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
    	 
    	 spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9),1);
    	 spaceinvaders.deplacerVaisseauVersLaDroite();
    	 assertEquals("" + 
    			 "...............\n" + 
    			 "...............\n" +
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "...............\n" + 
    			 "..........VVV..\n" + 
    			 "..........VVV..\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }

     
     @Test
     public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaDroite() {

        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(10,9),3);
        spaceinvaders.deplacerVaisseauVersLaDroite();
        assertEquals("" + 
        "...............\n" + 
        "...............\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "............VVV\n" + 
        "............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }
     
     
     @Test
     public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {

        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 3);
        spaceinvaders.deplacerVaisseauVersLaGauche();

        assertEquals("" + 
        "...............\n" + 
        "...............\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "....VVV........\n" + 
        "....VVV........\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }
     
     @Test
     public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {

 	   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(0,9), 3);
        spaceinvaders.deplacerVaisseauVersLaGauche();

        assertEquals("" + 
        "...............\n" + 
        "...............\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "VVV............\n" + 
        "VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
      }
 	
     
	@Test
	public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(9,2),new Position(7,9));
			fail("DÈpassement du vaisseau ‡ droite en raison de sa longueur trop importante : devrait dÈclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
			
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,4),new Position(7,1));
			fail("DÈpassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait dÈclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
			
	}
	

 	
     @Test(expected = HorsEspaceJeuException.class)
 	public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
 		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
 		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,10));
 	}
     
     
 	@Test
 	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
 		
 		try {
 			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(15,9));
 			fail("Position trop √† droite : devrait d√©clencher une exception HorsEspaceJeuException");
 		} catch (final HorsEspaceJeuException e) {
 		}
 		
 		
 		try {
 			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(-1,9));
 			fail("Position trop √† gauche : devrait d√©clencher une exception HorsEspaceJeuException");
 		} catch (final HorsEspaceJeuException e) {
 		}
 		
 		
 		try {
 			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(14,10));
 			fail("Position trop en bas : devrait d√©clencher une exception HorsEspaceJeuException");
 		} catch (final HorsEspaceJeuException e) {
 		}
 		
 		
 		try {
 			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1), new Position(14,-1));
 			fail("Position trop √† haut : devrait d√©clencher une exception HorsEspaceJeuException");
 		} catch (final HorsEspaceJeuException e) {
 		}
 			
 	}
 	
}