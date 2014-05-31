package fr.iutvalence.tp1a.binome4.morpion.modele;

import fr.iutvalence.tp1a.binome4.morpion.exceptions.*;

/** Création d'un plateau du jeu. */
public class PlateauJeu
{

	public static final int SIGNATURE_JOUEUR_1 = 5;
	public static final int SIGNATURE_JOUEUR_2 = -SIGNATURE_JOUEUR_1;
	
	public static final String SYMBOLE_JOUEUR_1 = "X";
	public static final String SYMBOLE_JOUEUR_2 = "O";
	
	private static final int NOMBRE_DE_COLONNES = 5;
	private static final int NOMBRE_DE_LIGNES = 5;
	private static final int NOMBRE_MAX_DE_TOUR = 9;
	
	private final int[][] plateauDeJeu;
	
	private int nombreDeTours;

	public PlateauJeu()
	{
		this.plateauDeJeu = new int[PlateauJeu.NOMBRE_DE_LIGNES][PlateauJeu.NOMBRE_DE_COLONNES];
		this.nombreDeTours = 0;
		
		for (int nombreDeLigne = 0; nombreDeLigne < NOMBRE_DE_LIGNES; nombreDeLigne++)
			for (int nombreDeColonne = 0; nombreDeColonne < NOMBRE_DE_COLONNES; nombreDeColonne++)
				this.plateauDeJeu[nombreDeLigne][nombreDeColonne] = 0;
	}
	/** Indique si la grille est pleine */
	public boolean coupPossible()
	{
		return this.nombreDeTours < NOMBRE_MAX_DE_TOUR;
	}

	/** Indique si la case est occupée (ou non) et si les coordonnées sont bonnes (ou non) */
	public void estCoupValide(int x, int y) throws CaseDejaOccupee, CoordonneesInvalides
	{
		// Exception si les coordonnees choisies sont invalides
		if ((x > 3) || (x < 1) || (y > 3) || (y < 1))
			throw new CoordonneesInvalides();

		// Exception si la case selectionnée est déjà occupée
		if (this.plateauDeJeu[x][y] != 0)
			throw new CaseDejaOccupee();
	}
	
	public boolean placerPion(int pion, int x, int y)
	{
		
		this.nombreDeTours++;

		int victoire = 3 * pion;

		this.plateauDeJeu[x][y] = pion;

		
		this.plateauDeJeu[x][0] += pion;
		this.plateauDeJeu[0][y] += pion;

		// Calcul de la première diagonale
		if (x == y)
			this.plateauDeJeu[0][0] += pion;

		// Calcul de l'autre diagonale
		if ((x + y) == 4)
			this.plateauDeJeu[4][0] += pion;

		// Test de l'éventuelle victoire
		return (this.plateauDeJeu[x][0] == victoire) || (this.plateauDeJeu[0][y] == victoire) || (this.plateauDeJeu[0][0] == victoire)
				|| (this.plateauDeJeu[4][0] == victoire);
	}

	/** Affichage du plateau de jeu par redéfinition d'une méthode existante */
	@Override
	public String toString()
	{
		StringBuilder plateauAsciiArt = new StringBuilder(30);

		for (int nombreDeLignes = 1; nombreDeLignes < 4; nombreDeLignes++)
		{
			for (int nombreDeColonnes = 1; nombreDeColonnes < 4; nombreDeColonnes++)
			{
				switch (this.plateauDeJeu[nombreDeLignes][nombreDeColonnes])
				{
				case SIGNATURE_JOUEUR_1:
					plateauAsciiArt.append(PlateauJeu.SYMBOLE_JOUEUR_1).append(' ');
					break;
				case SIGNATURE_JOUEUR_2:
					plateauAsciiArt.append(PlateauJeu.SYMBOLE_JOUEUR_2).append(' ');
					break;
				default:
					plateauAsciiArt.append('.').append(' ');
					break;
				}
			}
			plateauAsciiArt.append('\n');
		}
		return plateauAsciiArt.toString();
	}
}
