package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonQuitter implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "L'application va se fermer",
				"Quitter", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
