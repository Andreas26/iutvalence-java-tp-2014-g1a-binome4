package fr.iutvalence.tp1a.binome4.morpion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

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

    // Les items des menus
    private JMenuItem menuItemAPropos;
    private JMenuItem menuItemNouvellePartie;
    private JMenuItem menuItemQuitter;
    private JMenuItem menuItemReinitialiserPartie;
    private JMenuItem menuItemEditerNomJoueurs;
    private JMenuItem menuItemCommentJouer;
    private JMenuItem menuItemInterrogation;

    public void run()
    {
	this.fenetre = new JFrame();

	this.fenetre.setTitle("Morpion");
	this.fenetre.setSize(400, 400);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	// Création du composant associé à la barre de menu
	JMenuBar barreDeMenu = new JMenuBar();

	// Création des rubriques
	JMenu Menu = new JMenu("Menu");
	JMenu Partie = new JMenu("Partie");
	JMenu Aide = new JMenu("Aide");

	// Création des items de rubrique
	this.menuItemAPropos = new JMenuItem("A propos");
	this.menuItemNouvellePartie = new JMenuItem("Nouvelle Partie");
	this.menuItemReinitialiserPartie = new JMenuItem("Réinitialiser Partie");
	this.menuItemEditerNomJoueurs = new JMenuItem("Editer Nom Joueurs");
	this.menuItemCommentJouer = new JMenuItem("Comment Jouer?");
	this.menuItemInterrogation = new JMenuItem("?");

	// Association de la tâche comme auditeur d'évènement
	this.menuItemAPropos.addActionListener(this);

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
	    // Affichage d'un boite de dialogue proposant 2 options
	    // (confirmer/annuler)
	    if (JOptionPane.showConfirmDialog(this.fenetre,
		    "Souhaitez-vous vraiment quitter le jeu ?", "Confirmation",
		    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		// destruction de la fenêtre en cas de confirmation de fermeture
		this.fenetre.dispose();
	}

	if (itemSelectionne == this.menuItemNouvellePartie)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemReinitialiserPartie)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemEditerNomJoueurs)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemCommentJouer)
	{
	    JOptionPane
		    .showMessageDialog(this.fenetre,
			    "Règles du Jeu : Le jeu de Morpion se joue à 2 joueurs. Chaque joueur possède un type de pion (X ou O). Le but est d'aligner 3 pions, à la verticale, horizontale, ou diagonale.",
			    "Comment Jouer?", JOptionPane.INFORMATION_MESSAGE);
	    return;
	}

	if (itemSelectionne == this.menuItemInterrogation)
	{
	    JOptionPane.showMessageDialog(this.fenetre,
		    "Ceci est un jeu de Morpion", "A propos",
		    JOptionPane.INFORMATION_MESSAGE);
	    return;
	}
    }
}
