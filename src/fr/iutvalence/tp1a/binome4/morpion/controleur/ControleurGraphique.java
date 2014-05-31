package fr.iutvalence.tp1a.binome4.morpion.controleur;

import javax.swing.JOptionPane;

import fr.iutvalence.tp1a.binome4.morpion.modele.*;
import fr.iutvalence.tp1a.binome4.morpion.exceptions.*;
import fr.iutvalence.tp1a.binome4.morpion.interfaces.BloquerCase;

/** Modélisation du fonctionnement d'une partie. */
public class ControleurGraphique
{
    private final PlateauJeu plateau;
    private final GestionDesJoueurs joueurs;
    private BloquerCase uneDesactivationDesCasesDuPlateauDeJeu;
	private static final String[] JOUEURS_PAR_DEFAUT = { "Joueur 1", "Joueur 2" };

	/**Créer le controleur de la partie */
	public ControleurGraphique(BloquerCase uneDesactivation)
	{
		this.plateau = new PlateauJeu();
		this.joueurs = new GestionDesJoueurs(JOUEURS_PAR_DEFAUT);
		this.uneDesactivationDesCasesDuPlateauDeJeu = uneDesactivation;
	}

    /** Placer un pion sur le plateau */
    public void placerPion(int x, int y) throws CaseDejaOccupee
    {
    	try
        {
            this.plateau.estCoupValide(x, y);
            
            if (this.plateau.placerPion(this.joueurs.obtenirSignatureCourante(), x, y))
            {
            	this.uneDesactivationDesCasesDuPlateauDeJeu.BloquerCasesPlateau();
            	JOptionPane.showMessageDialog(null, "Le joueur a remporté la partie", "Fin de la partie.", JOptionPane.INFORMATION_MESSAGE);
            	return;
            }
            
            if (!(this.plateau.coupPossible()))
            {
            	this.uneDesactivationDesCasesDuPlateauDeJeu.BloquerCasesPlateau();
            	JOptionPane.showMessageDialog(null, "Partie nulle", "Fin de la partie.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (CoordonneesInvalides ignored)
        {
        }
    }
    
    /** Obtenir le joueur courant */
	public Joueur obtenirJoueurCourant()
	{
		return this.joueurs.obtenirJoueurCourant();
	}
    
    /** Obtenir l'icone du joueur courant */
	public String obtenirIconeCourante()
	{
		return this.joueurs.obtenirIconeCourant();
	}
	
	/** Identifier le joueur suivant */
	public void obtenirJoueurSuivant()
	{
		this.joueurs.joueurSuivant();
	}
}
