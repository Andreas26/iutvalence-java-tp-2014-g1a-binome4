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
						+ "\nLe but est de cr�er un alignement de 3 pions."
						+ "\nLe morpion se joue en g�n�ral sur une grille de 3 cases sur 3. "
						+ "\nLa grille est trac�e puis chaque joueur joue � tour de r�le. Le premier qui a align� 3 pions a gagn�."
						+ "\nDans cette application il suffit de cliquer sur la case voulue pour y placer un pion",
						"Comment Jouer", JOptionPane.INFORMATION_MESSAGE);
	}
}
