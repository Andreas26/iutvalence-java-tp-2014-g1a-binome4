package fr.iutvalence.tp1a.binome4.morpion;
import javax.swing.SwingUtilities;

     /**
     * Une application affichant la fenêtre de jeu
     * 
     * @author Gorce & Godicheau
     *
     */
    public class Frame
    {
    	/**
    	 * Main de l'application 
    	 * @param args (n/a)
    	 */
    	public static void main(String[] args)
    	{
    		// Exécution de la tâche de gestion de l'IHM dans le thread "event dispatch" de Swing
    		SwingUtilities.invokeLater(new TacheDAffichageDeFrame());
    		System.out.println("fin du main !");
    	}
    }
