package fr.iutvalence.tp1a.binome4.morpion.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutvalence.tp1a.binome4.morpion.TacheDAffichageDeFrame;;

public class BoutonNouvellePartie implements ActionListener
{
	/** Une vue graphique. */
	private TacheDAffichageDeFrame vue;
	
	/**
	 * Modélisation du bouton.
	 * 
	 * @param vueGraphique
	 *            Une vue graphique.
	 */
	public BoutonNouvellePartie(VueGraphique vueGraphique) {
		this.vue = vueGraphique;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.vue.mettreAZeroLesCases();
		this.vue.remettreAZeroLeControleur();
	}
}
