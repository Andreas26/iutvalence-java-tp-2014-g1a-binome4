package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton permettant de quitter le jeu
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class BoutonQuitter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Merci d'avoir jou� ! ;)",
										  "Remerciements", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
