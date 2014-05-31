package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonCommentJouer implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane
				.showMessageDialog(
						null,
						"Chaque joueur choisit un symbole, par exemple une croix ou un cercle."
						+ "\nLe but est de créer un alignement de 3 pions."
						+ "\nLe morpion se joue en général sur une grille de 3 cases sur 3. "
						+ "\nLa grille est tracée puis chaque joueur joue à tour de rôle. Le premier qui a aligné 3 pions a gagné."
						+ "\nDans cette application il suffit de cliquer sur la case voulue pour y placer un pion",
						"Comment Jouer", JOptionPane.INFORMATION_MESSAGE);
	}
}
