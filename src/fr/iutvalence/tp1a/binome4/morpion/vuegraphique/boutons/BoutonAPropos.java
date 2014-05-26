package fr.iutvalence.tp1a.binome4.morpion.vuegraphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class BoutonAPropos implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Membres de l'�quipe de d�veloppement : \n\n- BASSON Julien \n- DELORME Loïc \n\n Merci à Anthony Gelibert !",
									 "Auteurs", JOptionPane.INFORMATION_MESSAGE);
	}
}
