package fr.iutvalence.tp1a.binome4.morpion.modele;

/** Cr�ation d'un joueur */
public final class Joueur {

	private final String nom;
	private final int signature;
	private final String cheminIcone;

	/** Cr�ation d'un joueur (nom, signature, chemin icone) */
	public Joueur(final String nom, final int signature, final String icone)
	{
		this.nom = nom;
		this.signature = signature;
		this.cheminIcone = icone;
	}

	/** Obtenir le nom du joueur */
	public String obtenirNomJoueur()
	{
		return this.nom;
	}

	/** Obtenir la signature du joueur */
	public int obtenirSignatureJoueur()
	{
		return this.signature;
	}

	/** Obtenir l'icone du joueur */
	public String obtenirCheminIcone()
	{
		return this.cheminIcone;
	}

	/** Red�finition de la m�thode toString() pour afficher les param�tres d'un joueur */
	@Override
	public String toString()
	{
		return String.format("Joueur{m_nom='%s', m_signature=%d}", this.nom,
				this.signature);
	}
}
