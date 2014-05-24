package fr.iutvalence.java.morpion.vues.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class BoutonAPropos implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Membres de l'équipe de développement : \n\n- BASSON Julien \n- DELORME LoÃ¯c \n\n Merci Ã  Anthony Gelibert !",
									 "Auteurs", JOptionPane.INFORMATION_MESSAGE);
	}
}
