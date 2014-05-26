package fr.iutvalence.tp1a.binome4.modele;

import java.security.SecureRandom;

/**
 *  Classe gérant les joueurs
 */
public final class GestionDesJoueurs
{
	private final Joueur joueur1;
	private final Joueur joueur2;
	private Joueur joueurCourant;

	/** 
	 * Initialiser les 2 joueurs
	 */
	public GestionDesJoueurs(final String[] joueurs)
	{
		assert joueurs.length == 2 : "Tentative de création d'un gestionnaire avec moins de deux joueurs";

		this.joueur1 = new Joueur(joueurs[0], PlateauJeu.SIGNATURE_JOUEUR_1, "images/croix.png");
		this.joueur2 = new Joueur(joueurs[1], PlateauJeu.SIGNATURE_JOUEUR_2, "images/rond.png");
		this.joueurCourant = new SecureRandom().nextBoolean() ? this.joueur1 : this.joueur2;
	}

	/**
	 * Identifier le joueur suivant
	 */
	public void joueurSuivant()
	{
		this.joueurCourant = (this.joueurCourant.equals(this.joueur1)) ? this.joueur2 : this.joueur1;
	}

	/**
	 *  Obtenir la signature du joueur courant.
	 */
	public int obtenirSignatureCourante()
	{
		return this.joueurCourant.obtenirSignatureJoueur();
	}

	/** 
	 * Obtenir le nom d'un joueur courant.
	 */
	public String obtenirNomCourant()
	{
		return this.joueurCourant.obtenirNomJoueur();
	}
	
	/** 
	 * Obtenir l'icone du joueur courant.
	 */
	public String obtenirIconeCourant()
	{
		return this.joueurCourant.obtenirCheminIcone();
	}

	/** 
	 * Obtenir le symbole du joueur courant.
	 */
	public String obtenirSymboleJoueur()
	{
		return (this.joueurCourant.equals(this.joueur1)) ? PlateauJeu.SYMBOLE_JOUEUR_1 : PlateauJeu.SYMBOLE_JOUEUR_2;
	}
	
	/** 
	 * Obtenir le joueur courant.
	 */
	public Joueur obtenirJoueurCourant()
	{
		return this.joueurCourant;
	}
}
