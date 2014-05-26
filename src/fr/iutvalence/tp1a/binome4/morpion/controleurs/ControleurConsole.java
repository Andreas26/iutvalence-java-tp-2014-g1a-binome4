package fr.iutvalence.tp1a.binome4.morpion.controleurs;

import fr.iutvalence.tp1a.binome4.modele.*;
import fr.iutvalence.tp1a.binome4.morpion.exceptions.*;
import fr.iutvalence.tp1a.binome4.morpion.vuesconsole.*;

public class ControleurConsole
{
    private final PlateauJeu plateau;
    
    /** La vue de la partie. */
    private final VueConsole vue;
    
    /** Les joueurs de la partie. */
    private final GestionDesJoueurs joueurs;

    /**
     *  Création du controleur de la partie.
     */
    public ControleurConsole(boolean choixVue)
    {
        this.plateau = new PlateauJeu();
        
        if (choixVue)
        	this.vue = new VueConsoleANSI();
        else
        	this.vue = new VueConsoleSimple();
        
        this.joueurs = new GestionDesJoueurs(this.vue.demanderNomsJoueurs());
    }

    /**
     * Jouer une partie.
     */
    public boolean nouvellePartie()
    {
        if (this.partie(this.plateau))
        	this.vue.afficherVainqueur(this.joueurs.obtenirNomCourant());
        else
        	this.vue.afficherPartieNulle();
        
        return this.vue.choixRejouer();
    }

    /**
     * Permet de controler le déroulement d'une partie.
     */
    private boolean partie(PlateauJeu plateau) 
    {
        while (plateau.coupPossible())
        {
        	this.vue.debuterUnTour(this.joueurs.obtenirNomCourant(), this.joueurs.obtenirSymboleJoueur());
            this.vue.afficherPlateauCourant(this.plateau.toString());
            final int[] tableauDesChoix = this.vue.demanderCoordonnees();

            try
            {
                plateau.estCoupValide(tableauDesChoix[0], tableauDesChoix[1]);
                if (plateau.placerPion(this.joueurs.obtenirSignatureCourante(), tableauDesChoix[0], tableauDesChoix[1]))
                {
                	this.vue.afficherPlateauCourant(this.plateau.toString());
                    return true;
                }
                this.joueurs.joueurSuivant();
            }
            catch (final CaseDejaOccupee ignored)
            {
                this.vue.coordonneesDejaPrise();
            }
            catch (final CoordonneesInvalides ignored)
            {
                this.vue.mauvaisesCoordonnees();
            }
        }
        return false;
    }
}
