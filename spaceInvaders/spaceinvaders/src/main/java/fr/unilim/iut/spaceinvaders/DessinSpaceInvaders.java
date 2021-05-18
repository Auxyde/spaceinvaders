package fr.unilim.iut.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.unilim.iut.spaceinvaders.moteurjeu.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {
	private SpaceInvaders spaceInvaders;
	
	private int x = spaceInvaders.vaisseau.abscisseLaPlusAGauche();
	private int y = spaceInvaders.vaisseau.abscisseLaPlusADroite();
	
	
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "V":
			crayon.setColor(Color.blue);
			crayon.fillRect(spaceInvaders.vaisseau.abscisseLaPlusAGauche(), spaceInvaders.vaisseau.abscisseLaPlusADroite(), 1, 1);
			break;
		case ".":
			crayon.setColor(Color.gray);
			crayon.fillRect(x, y, 1, 1);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	public void dessiner(BufferedImage im) {
		// no sait que c'est un jeuTest
		SpaceInvaders sp = (SpaceInvaders) spaceInvaders;
		Vaisseau vaisseau = sp.vaisseau;
		this.dessinerObjet("V", vaisseau.abscisseLaPlusAGauche(),1, im);
	}

	
}
