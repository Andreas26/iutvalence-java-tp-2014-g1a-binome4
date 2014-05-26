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
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComponent;

import fr.iutvalence.tp1a.binome4.morpion.boutons.*;

/**
 * T�che g�rant l'IHM (cr�ation, affichage)
 * 
 * @author Gorce & Godicheau
 * 
 */
public class TacheDAffichageDeFrame implements Runnable, ActionListener
{

    // La fen�tre
    private JFrame fenetre;

    public static final JPanel unTableau = new JPanel();

    private JMenuBar barreDeMenu = new JMenuBar();

    JMenu menuJouer = new JMenu("Jouer");
    private JMenuItem menuItemJouerNouvellePartie;
    private JMenuItem menuItemJouerReinitialiserPartie;
    private JMenuItem menuItemJouerEditerNomJoueurs;
    private JMenuItem menuItemJouerQuitter;

    JMenu menuAide = new JMenu("Aide");
    private JMenuItem menuItemAideCommentJouer;
    private JMenuItem menuItemAideAPropos;
    private JMenuItem menuItemAideInterrogation;

    private JSplitPane splitPaneDroit;

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

    // Le bouton de remise � z�ro
    private JButton boutonRemiseAZero;

    public enum symboles
    {
    X, O;
    }

    private JLabel labelDesPseudos;

    private boolean saisieDesSymbolesCommencee;

    /**
     * Méthode qui crée la fenêtre, et la barre de menu
     */
    public void run()
    {

	this.fenetre = new JFrame();

	fenetre.setTitle("Morpion");
	fenetre.setSize(450, 400);
	fenetre.setResizable(false);
	fenetre.setLocationRelativeTo(null);
	fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	this.boutonRemiseAZero = new JButton("Remise à zero");
	this.boutonRemiseAZero.setFocusable(false);
	this.boutonRemiseAZero.addActionListener(this);

	this.saisieDesSymbolesCommencee = false;

	// Ajout des actions possibles dans le menu "Partie"
	this.menuJouer.add(this.menuItemJouerNouvellePartie);
	this.menuJouer.add(this.menuItemJouerReinitialiserPartie);
	this.menuJouer.addSeparator();
	this.menuJouer.add(this.menuItemJouerEditerNomJoueurs);
	this.menuJouer.addSeparator();
	this.menuJouer.add(this.menuItemJouerQuitter);

	// Ajout des actions possibles dans le menu "Aide"
	this.menuAide.add(menuItemAideCommentJouer);
	this.menuAide.add(menuItemAideAPropos);
	this.menuAide.add(menuItemAideInterrogation);

	// On ajoute les événements relatifs aux différents boutons
	this.menuItemJouerNouvellePartie.addActionListener(new BoutonNouvellePartie(this));
	this.menuItemJouerReinitialiserPartie.addActionListener(new BoutonNouvellePartie());
	this.menuItemJouerEditerNomJoueurs.addActionListener(new BoutonNomJoueurs());
	this.menuItemJouerQuitter.addActionListener(new BoutonQuitter());
	this.menuItemAideCommentJouer.addActionListener(new BoutonCommentJouer());
	this.menuItemAideAPropos.addActionListener(new BoutonAPropos());
	this.menuItemAideInterrogation.addActionListener(new BoutonInterrogation());

	// Création des rubriques

	// Création des items de rubrique
	this.menuItemJouerNouvellePartie = new JMenuItem("Nouvelle Partie");
	this.menuItemJouerReinitialiserPartie = new JMenuItem(
		"R�initialiser Partie");
	this.menuItemJouerEditerNomJoueurs = new JMenuItem("Editer Nom Joueurs");
	this.menuItemAideCommentJouer = new JMenuItem("Comment Jouer?");
	this.menuItemAideAPropos = new JMenuItem("A propos");
	this.menuItemAideInterrogation = new JMenuItem("?");

	// Association de la tâche comme auditeur d'évènement
	this.menuItemJouerNouvellePartie.addActionListener(this);
	this.menuItemJouerReinitialiserPartie.addActionListener(this);
	this.menuItemJouerEditerNomJoueurs.addActionListener(this);
	this.menuItemAideAPropos.addActionListener(this);
	this.menuItemAideCommentJouer.addActionListener(this);
	this.menuItemAideInterrogation.addActionListener(this);

	// Ajout des rubriques à la barre de menu
	barreDeMenu.add(menuJouer);
	barreDeMenu.add(Partie);
	barreDeMenu.add(menuAide);

	// Ajout des items aux différentes rubriques
	menuJouer.add(this.menuItemAideAPropos);
	this.menuItemJouerQuitter = new JMenuItem("Quitter");
	this.menuItemJouerQuitter.addActionListener(this);
	menuJouer.add(this.menuItemJouerQuitter);

	Partie.add(this.menuItemJouerNouvellePartie);
	Partie.add(this.menuItemJouerReinitialiserPartie);
	Partie.add(this.menuItemJouerEditerNomJoueurs);

	menuAide.add(this.menuItemAideCommentJouer);
	menuAide.add(this.menuItemAideInterrogation);

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

	// if (source == this.boutonRemiseAZero)
	// {
	// traiterRemiseAZero();
	// return;
	// }

	// Identification de l'item sélectionné, source de l'événement
	JMenuItem itemSelectionne = (JMenuItem) event.getSource();

	if (itemSelectionne == this.menuItemAideAPropos)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemJouerQuitter)
	{
	    // Affichage d'une boite de dialogue proposant 2 options
	    if (JOptionPane.showConfirmDialog(this.fenetre,
		    "Souhaitez-vous vraiment quitter le jeu ?", "Confirmation",
		    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		this.fenetre.dispose();
	}

	// if (itemSelectionne == this.menuItemNouvellePartie)
	// {
	// return;
	// }

	// if (itemSelectionne == this.menuItemReinitialiserPartie)
	// {
	// return;
	// }

	// if (itemSelectionne == this.menuItemEditerNomJoueurs)
	// {
	// return;
	// }

	if (itemSelectionne == this.menuItemAideCommentJouer)
	{
	    JOptionPane
		    .showMessageDialog(
			    this.fenetre,
			    "Règles du Jeu : Le jeu de Morpion se joue à 2 joueurs. Chaque joueur possède un type de pion (X ou O). Le but est d'aligner 3 pions, à la verticale, horizontale, ou diagonale.",
			    "Comment Jouer?", JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemAideInterrogation)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Coordonnées des codeurs", "?",
		    JOptionPane.INFORMATION_MESSAGE);
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