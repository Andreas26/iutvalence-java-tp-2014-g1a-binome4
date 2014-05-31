package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import fr.iutvalence.tp1a.binome4.morpion.controleur.*;
import fr.iutvalence.tp1a.binome4.morpion.exceptions.*;
import fr.iutvalence.tp1a.binome4.morpion.interfaces.*;
import fr.iutvalence.tp1a.binome4.morpion.vuegraphique.*;


/** Modèle d'une case sous forme de bouton */ 
public class BoutonCase extends JButton implements ActionListener, MettreAJourBoutonChoisi
{
	private final int x;
	private final int y;
	private ControleurGraphique unControleurGraphique;
	private VueGraphiqueDuJeu uneVueGraphique;

	/** Modélisation d'une case */
	
	public BoutonCase(String nom, int x, int y, ControleurGraphique unControleurGraphique, VueGraphiqueDuJeu uneVueGraphique)
	{
		this.setText(nom);
		this.x = x;
		this.y = y;
		this.unControleurGraphique = unControleurGraphique;
		this.uneVueGraphique = uneVueGraphique;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			this.unControleurGraphique.placerPion(this.x, this.y);
			this.mettreAJourBoutonClique(this.unControleurGraphique.obtenirIconeCourante());
			this.unControleurGraphique.obtenirJoueurSuivant();
			this.uneVueGraphique.notifierChangementJoueurCourant(this.unControleurGraphique.obtenirJoueurCourant());
		}
		catch (CaseDejaOccupee e1)
		{
		}
	}

	@Override
	public void mettreAJourBoutonClique(String imageJoueurCourant)
	{
		this.setIcon(new ImageIcon(imageJoueurCourant));
	}
}
