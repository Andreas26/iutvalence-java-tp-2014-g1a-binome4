package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BoutonAPropos implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane
				.showMessageDialog(
						null,
						"Jeu r�alis� par \n\n*Romain Gorce \n*Andr�as Godicheau",
						"A Propos", JOptionPane.INFORMATION_MESSAGE);
	}
}
