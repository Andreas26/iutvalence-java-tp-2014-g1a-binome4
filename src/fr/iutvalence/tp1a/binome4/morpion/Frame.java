package fr.iutvalence.tp1a.binome4.morpion;

import javax.swing.SwingUtilities;

import fr.iutvalence.tp1a.binome4.morpion.vuegraphique.VueGraphiqueDuJeu;
     
/** Une application affichant la fenêtre de jeu */
    public class Frame
    {
    	/** Main de l'application */
    	public static void main(String[] args)
    	{
    		SwingUtilities.invokeLater(new VueGraphiqueDuJeu());
    		System.out.println("fin du main !");
    	}
    }
