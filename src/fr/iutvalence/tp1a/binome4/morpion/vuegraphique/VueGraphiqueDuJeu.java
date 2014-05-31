package fr.iutvalence.tp1a.binome4.morpion.vuegraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import fr.iutvalence.tp1a.binome4.morpion.controleur.*;
import fr.iutvalence.tp1a.binome4.morpion.interfaces.*;
import fr.iutvalence.tp1a.binome4.morpion.modele.*;
import fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons.*;


/** Tâche gérant l'IHM */
public class VueGraphiqueDuJeu implements Runnable, BloquerCase, MettreAJourJoueurCourant
{

	private final JPanel unTableau = new JPanel();
	private ControleurGraphique unControleur;
	private JLabel unJLabel;
	
	public void run()
	{
		/** La fenêtre de jeu */
		JFrame fenetre = new JFrame();
		
		/** *La barre de menu du jeu */
		JMenuBar barreDeMenu = new JMenuBar();
		
		JMenu menuJouer = new JMenu("Jouer");
		JMenuItem itemNouvellePartie = new JMenuItem("Nouvelle Partie");
		JMenuItem itemReinitialiserPartie = new JMenuItem("Reinitialiser Partie");
		JMenuItem itemQuitter = new JMenuItem("Quitter");
		JMenu menuAide = new JMenu("Aide");
		JMenuItem itemCommentJouer = new JMenuItem("Comment Jouer");
		JMenuItem itemAPropos = new JMenuItem("A propos");
		JMenuItem itemInterrogation = new JMenuItem("?");


		this.unControleur = new ControleurGraphique(this);

		fenetre.setTitle("Morpion");
		fenetre.setSize(540, 480);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		/** Ajout des sous-menus dans le menu Jouer */
		menuJouer.add(itemNouvellePartie);
		menuJouer.add(itemReinitialiserPartie);
		menuJouer.add(itemQuitter);
		
		/** Ajout des sous-menus dans le menu Aide */
		menuAide.add(itemCommentJouer);
		menuAide.add(itemAPropos);
		menuAide.addSeparator();
		menuAide.add(itemInterrogation);

		/** On ajoute les évènements relatifs aux différents boutons */
		itemNouvellePartie.addActionListener(new BoutonNouvellePartie(this));
		itemReinitialiserPartie.addActionListener(new BoutonNouvellePartie(this));
		itemQuitter.addActionListener(new BoutonQuitter());
		itemCommentJouer.addActionListener(new BoutonCommentJouer());
		itemAPropos.addActionListener(new BoutonAPropos());
		itemInterrogation.addActionListener(new BoutonInterrogation());

		/** Ajout des 2 menus dans la barre de menu */
		barreDeMenu.add(menuJouer);
		barreDeMenu.add(menuAide);

		/** Ajout de la barre de menu à la fenêtre */
		fenetre.setJMenuBar(barreDeMenu);
		
		this.unTableau.setBackground(Color.WHITE);
		this.unTableau.setLayout(new GridLayout(3,3));
		initialiserLesCasesDuPlateau();
	
		JLabel premierJoueur = new JLabel("Joueur 1");
		premierJoueur.setIcon(new ImageIcon("Images/CroixMorpion.png"));
		premierJoueur.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JLabel deuxiemeJoueur = new JLabel("Joueur 2");
		deuxiemeJoueur.setIcon(new ImageIcon("Images/CercleMorpion.png"));
		deuxiemeJoueur.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JSplitPane splitPaneJoueurs = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneJoueurs.add(premierJoueur);
		splitPaneJoueurs.add(deuxiemeJoueur);
		splitPaneJoueurs.setEnabled(false);
		splitPaneJoueurs.setBorder(null);
		splitPaneJoueurs.setDividerSize(0);
		splitPaneJoueurs.setResizeWeight(0);
		
		JSplitPane splitPaneDroit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneDroit.add(splitPaneJoueurs);
		this.unJLabel = new JLabel("Joueur courant : ");
		splitPaneDroit.add(this.unJLabel);
		splitPaneDroit.setEnabled(false);
		splitPaneDroit.setBorder(null);
		splitPaneDroit.setDividerSize(0);
		splitPaneDroit.setResizeWeight(0.66);
		
		JSplitPane splitPanePrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPanePrincipal.add(this.unTableau);
		splitPanePrincipal.add(splitPaneDroit);
		splitPanePrincipal.setEnabled(false);
		splitPanePrincipal.setDividerSize(0);
		splitPanePrincipal.setResizeWeight(1);
		
		fenetre.getContentPane().add(splitPanePrincipal);
		fenetre.setVisible(true);
		
		notifierChangementJoueurCourant(this.unControleur.obtenirJoueurCourant());
	}
	
	
	/** Vider cases du plateau */
	public void initialiserLesCasesDuPlateau()
	{
		this.unTableau.removeAll();
		
		for(int nombreDeCasesParLigne = 1 ; nombreDeCasesParLigne < 4 ; nombreDeCasesParLigne++)
			for(int nombreDeCasesParColonne = 1 ; nombreDeCasesParColonne < 4 ; nombreDeCasesParColonne++)
				this.unTableau.add(new BoutonCase("",nombreDeCasesParLigne,nombreDeCasesParColonne, this.unControleur, this));
		
		this.unTableau.updateUI();
	}
	
	/** Vider le plateau de jeu. */
	public void reinitialiserLeControleurGraphique()
	{
		this.unControleur = new ControleurGraphique(this);
	}
	
	@Override
	public void notifierChangementJoueurCourant(Joueur joueur)
	{
		String resultat = "Joueur courant : " + joueur.obtenirNomJoueur();
		this.unJLabel.setText(resultat);
		this.unTableau.updateUI();
	}

	/** Bloquer les cases du plateau de jeu. */
	@Override
	public void BloquerCasesPlateau()
	{
		for (Component bouton : this.unTableau.getComponents())
			bouton.setEnabled(false);
		
		this.unTableau.updateUI();
		
	}

}