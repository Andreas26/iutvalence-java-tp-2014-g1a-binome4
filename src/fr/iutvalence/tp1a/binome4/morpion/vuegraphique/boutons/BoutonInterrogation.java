package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonInterrogation implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane
				.showMessageDialog(
						null,
						"Adresses mail des membres de ce groupe de projet :"
						+ "\n\nRomain Gorce : romain.gorce@iut-valence.fr"
						+ "\nAndréas Godicheau : andreas.godicheau@iut-valence.fr",
						"?", JOptionPane.INFORMATION_MESSAGE);
	}
}
