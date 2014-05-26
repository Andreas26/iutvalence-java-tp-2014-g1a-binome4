package fr.iutvalence.tp1a.binome4.morpion.vuegraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JComponent;

import fr.iutvalence.java.morpion.controleurs.ControleurGraphique;
import fr.iutvalence.java.morpion.vues.graphique.boutons.Case;
import fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons.*;

/**
 * Tï¿½che gï¿½rant l'IHM (crï¿½ation, affichage)
 * 
 * @author Gorce & Godicheau
 * 
 */
public class TacheDAffichageDeFrame implements Runnable, ActionListener {

	// La fenï¿½tre
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

	// Le bouton de remise ï¿½ zï¿½ro
	private JButton boutonRemiseAZero;

	public enum symboles {
		X, O;
	}

	private JLabel labelDesPseudos;

	private boolean saisieDesSymbolesCommencee;

	/**
	 * Méthode qui crée la fenêtre, et la barre de menu
	 */
	public void run() {
		this.fenetre = new JFrame();

		fenetre.setTitle("Morpion");
		fenetre.setSize(450, 400);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

		
		
		
		this.boutonRemiseAZero = new JButton("Remise à zero");
		this.boutonRemiseAZero.setFocusable(false);
		this.boutonRemiseAZero.addActionListener(this);

		 //On ajoute les évènements relatifs aux différents boutons
		 this.menuItemJouerNouvellePartie.addActionListener(new BoutonNouvellePartie(this));
		 this.menuItemJouerReinitialiserPartie.addActionListener(new BoutonNouvellePartie());
		 this.menuItemJouerEditerNomJoueurs.addActionListener(new BoutonNomJoueurs());
		 this.menuItemJouerQuitter.addActionListener(new BoutonQuitter());
		 
		 this.menuItemAideCommentJouer.addActionListener(new BoutonCommentJouer());
		 this.menuItemAideAPropos.addActionListener(new BoutonAPropos());
		 this.menuItemAideInterrogation.addActionListener(new BoutonInterrogation());

		// Ajout des rubriques à la barre de menu
		barreDeMenu.add(menuJouer);
		barreDeMenu.add(menuAide);
		
		this.unTableau.setLayout(new GridLayout(3,3));
		viderLesCases();
		this.unTableau.setBackground(Color.WHITE);
		
		JLabel premierJoueur = new JLabel("Joueur 1");
		premierJoueur.setIcon(new ImageIcon("images/croix.png"));
		premierJoueur.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JLabel deuxiemeJoueur = new JLabel("Joueur 2");
		deuxiemeJoueur.setIcon(new ImageIcon("images/rond.png"));
		deuxiemeJoueur.setHorizontalTextPosition(SwingConstants.LEFT);

		
		
		
		
		// CrÃ©ation des items de rubrique
		this.menuItemJouerNouvellePartie = new JMenuItem("Nouvelle Partie");
		this.menuItemJouerReinitialiserPartie = new JMenuItem(
				"Reinitialiser Partie");
		this.menuItemJouerEditerNomJoueurs = new JMenuItem("Editer Nom Joueurs");
		this.menuItemAideCommentJouer = new JMenuItem("Comment Jouer?");
		this.menuItemAideAPropos = new JMenuItem("A propos");
		this.menuItemAideInterrogation = new JMenuItem("?");

		// Association de la tÃ¢che comme auditeur d'Ã©vÃ¨nement
		this.menuItemJouerNouvellePartie.addActionListener(this);
		this.menuItemJouerReinitialiserPartie.addActionListener(this);
		this.menuItemJouerEditerNomJoueurs.addActionListener(this);
		this.menuItemAideAPropos.addActionListener(this);
		this.menuItemAideCommentJouer.addActionListener(this);
		this.menuItemAideInterrogation.addActionListener(this);

		

		// Ajout des items aux diffÃ©rentes rubriques
		menuJouer.add(this.menuItemAideAPropos);
		this.menuItemJouerQuitter = new JMenuItem("Quitter");
		this.menuItemJouerQuitter.addActionListener(this);
		menuJouer.add(this.menuItemJouerQuitter);

		menuAide.add(this.menuItemAideCommentJouer);
		menuAide.add(this.menuItemAideInterrogation);

		// Affectation de la barre de menu Ã  la fenÃªtre
		
		
		this.fenetre.setVisible(true);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.initialiserGrille();
	}
	
	public void viderLesCases()
	{
		this.unTableau.removeAll();
		for(int nombreDeCaseParLigne = 1 ; nombreDeCaseParLigne < 4 ; nombreDeCaseParLigne++)
			for(int nombreDeCaseParColonne = 1 ; nombreDeCaseParColonne < 4 ; nombreDeCaseParColonne++)
				this.unTableau.add(new Case("",nombreDeCaseParLigne,nombreDeCaseParColonne, this.unControleur));
		this.unTableau.updateUI();
	}
	
	/** Bloquer les cases. */
	public void desactiverCases()
	{
		for (Component bouton : this.unTableau.getComponents())
		{
			bouton.setEnabled(false);
		}
		this.unTableau.updateUI();
	}
	
	public void remettreAZeroControleur()
	{
		this.unControleur = new ControleurGraphique(this);
	}
	
	public ControleurGraphique obtenirControleurGraphique()
	{
		return this.unControleur;
	}
	
	{
		String resultat = "Joueur courant" + joueur.obtenirNom();
		this.unJLabel.setName(resultat);
		this.unTableau.updateUI();
	}

	public void initialiserGrille() {
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