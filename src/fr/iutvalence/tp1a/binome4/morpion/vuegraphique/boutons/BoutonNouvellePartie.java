package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutvalence.tp1a.binome4.morpion.vuegraphique.*;

public class BoutonNouvellePartie implements ActionListener
{
	private VueGraphiqueDuJeu vue;
	
	/** Modélisation du bouton Nouvelle Partie*/
	public BoutonNouvellePartie(VueGraphiqueDuJeu vueGraphique)
	{
		this.vue = vueGraphique;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.vue.initialiserLesCasesDuPlateau();
		this.vue.reinitialiserLeControleurGraphique();
	}
}
