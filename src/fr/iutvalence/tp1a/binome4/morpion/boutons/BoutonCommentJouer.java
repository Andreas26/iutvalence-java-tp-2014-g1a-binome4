package fr.iutvalence.tp1a.binome4.morpion.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton "Règle du jeu" de l'application.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class BoutonCommentJouer implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Le jeu du morpion est un jeu de réflexion qui se pratique à deux."
										  + "\nChaque joueur possède un symbole différent ('X' ou 'O') et le but est de créer un alignement de 3 symboles."
										  + "\nLe premier joueur qui a aligné 3 symboles a gagné."
										  , "Règle du jeu", JOptionPane.INFORMATION_MESSAGE);
	}
}
