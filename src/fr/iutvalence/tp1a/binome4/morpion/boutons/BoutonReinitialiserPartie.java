package fr.iutvalence.tp1a.binome4.morpion.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonReinitialiserPartie implements ActionListener
{
	/** Une vue graphique. */
	private VueGraphique vue;
	
	/**
	 * Modélisation du bouton.
	 * 
	 * @param vueGraphique
	 *            Une vue graphique.
	 */
	public BoutonJouer(VueGraphique vueGraphique) {
		this.vue = vueGraphique;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.vue.mettreAZeroLesCases();
		this.vue.remettreAZeroLeControleur();
	}
}
