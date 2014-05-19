package fr.iutvalence.tp1a.binome4.morpion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComponent;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 * @author Gorce & Godicheau
 * 
 */
public class TacheDAffichageDeFrame implements Runnable, ActionListener
{

    // La fenêtre
    private JFrame fenetre;

    /**
     * Les items des différents sous-menus
     */
    private JMenuItem menuItemAPropos;
    private JMenuItem menuItemNouvellePartie;
    private JMenuItem menuItemQuitter;
    private JMenuItem menuItemReinitialiserPartie;
    private JMenuItem menuItemEditerNomJoueurs;
    private JMenuItem menuItemCommentJouer;
    private JMenuItem menuItemInterrogation;

    /**
     * Les Boutons de la grille
     */

    // Ligne 1
    private JButton b11;
    private JButton b12;
    private JButton b13;
    
    // Ligne 2
    private JButton b21;
    private JButton b22;
    private JButton b23;
    
    // Ligne 3
    private JButton b31;
    private JButton b32;
    private JButton b33;

    // Le bouton de remise à zéro
    private JButton boutonRemiseAZero;

    public enum symboles
    {
	X,
	O;
    }

    private JLabel labelDesPseudos;

    private boolean saisieDesSymbolesCommencee;

    /**
     * Méthode qui crée la fenêtre, et la barre de menu
     */
    public void run()
    {
	this.fenetre = new JFrame();

	this.fenetre.setTitle("Morpion");
	this.fenetre.setSize(600, 600);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	this.labelDesPseudos = new JLabel();
	this.labelDesPseudos.setOpaque(true);

	this.boutonRemiseAZero = new JButton("Remise à zero");
	this.boutonRemiseAZero.setFocusable(false);
	this.boutonRemiseAZero.addActionListener(this);

	this.saisieDesSymbolesCommencee = false;

	// Création du composant associé à la barre de menu
	JMenuBar barreDeMenu = new JMenuBar();

	// Création des rubriques
	JMenu Menu = new JMenu("Menu");
	JMenu Partie = new JMenu("Partie");
	JMenu Aide = new JMenu("Aide");

	// Création des items de rubrique
	this.menuItemNouvellePartie = new JMenuItem("Nouvelle Partie");
	this.menuItemReinitialiserPartie = new JMenuItem("Réinitialiser Partie");
	this.menuItemEditerNomJoueurs = new JMenuItem("Editer Nom Joueurs");
	this.menuItemCommentJouer = new JMenuItem("Comment Jouer?");
	this.menuItemAPropos = new JMenuItem("A propos");
	this.menuItemInterrogation = new JMenuItem("?");

	// Association de la tâche comme auditeur d'évènement
	this.menuItemNouvellePartie.addActionListener(this);
	this.menuItemReinitialiserPartie.addActionListener(this);
	this.menuItemEditerNomJoueurs.addActionListener(this);
	this.menuItemAPropos.addActionListener(this);
	this.menuItemCommentJouer.addActionListener(this);
	this.menuItemInterrogation.addActionListener(this);

	// Ajout des rubriques à la barre de menu
	barreDeMenu.add(Menu);
	barreDeMenu.add(Partie);
	barreDeMenu.add(Aide);

	// Ajout des items aux différentes rubriques
	Menu.add(this.menuItemAPropos);
	this.menuItemQuitter = new JMenuItem("Quitter");
	this.menuItemQuitter.addActionListener(this);
	Menu.add(this.menuItemQuitter);

	Partie.add(this.menuItemNouvellePartie);
	Partie.add(this.menuItemReinitialiserPartie);
	Partie.add(this.menuItemEditerNomJoueurs);

	Aide.add(this.menuItemCommentJouer);
	Aide.add(this.menuItemInterrogation);

	// Affectation de la barre de menu à la fenêtre
	this.fenetre.setJMenuBar(barreDeMenu);
	this.fenetre.setVisible(true);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
	this.initialiserGrille();
    }

    /**
     * Traitement des évènements associés aux items de rubriques
     * 
     * @param event
     *            l'événement survenu
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
	// Identification de l'item sélectionné, source de l'événement
	JComponent source = (JComponent) event.getSource();

//	if (source == this.boutonRemiseAZero)
//	{
//	    traiterRemiseAZero();
//	    return;
//	}
	
	// Identification de l'item sélectionné, source de l'événement
	JMenuItem itemSelectionne = (JMenuItem) event.getSource();

	if (itemSelectionne == this.menuItemAPropos)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemQuitter)
	{
	    // Affichage d'une boite de dialogue proposant 2 options
	    if (JOptionPane.showConfirmDialog(this.fenetre, "Souhaitez-vous vraiment quitter le jeu ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		this.fenetre.dispose();
	}

//	if (itemSelectionne == this.menuItemNouvellePartie)
//	{
//	    return;
//	}

//	if (itemSelectionne == this.menuItemReinitialiserPartie)
//	{
//	   return;
//	}

//	if (itemSelectionne == this.menuItemEditerNomJoueurs)
//	{
//	    return;
//	}

	if (itemSelectionne == this.menuItemCommentJouer)
	{
	    JOptionPane.showMessageDialog(this.fenetre, "Règles du Jeu : Le jeu de Morpion se joue à 2 joueurs. Chaque joueur possède un type de pion (X ou O). Le but est d'aligner 3 pions, à la verticale, horizontale, ou diagonale.", "Comment Jouer?", JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemInterrogation)
	{
	    JOptionPane.showMessageDialog(this.fenetre, "Coordonnées des codeurs", "?", JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

    }

    public void initialiserGrille()
    {
	fenetre.getContentPane().setLayout(new GridLayout(3, 3));

	// Ligne 1
	b11 = new JButton("");
	fenetre.getContentPane().add(b11);
	b12 = new JButton("");
	fenetre.getContentPane().add(b12);
	b13 = new JButton("");
	fenetre.getContentPane().add(b13);
	
	// Ligne 2
	b21 = new JButton("");
	fenetre.getContentPane().add(b21);
	b22 = new JButton("");
	fenetre.getContentPane().add(b22);
	b23 = new JButton("");
	fenetre.getContentPane().add(b23);
	
	// Ligne 3
	b31 = new JButton("");
	fenetre.getContentPane().add(b31);
	b32 = new JButton("");
	fenetre.getContentPane().add(b32);
	b33 = new JButton("");
	fenetre.getContentPane().add(b33);
    }

    // public void traiterRemiseAZero(){
    // this.controleur.remettreAZeroLesSymboles();
    // this.saisieDesSymbolesCommencee = false;
    // }

}