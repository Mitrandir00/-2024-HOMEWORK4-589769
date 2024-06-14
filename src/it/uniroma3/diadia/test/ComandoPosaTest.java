package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	@Test
	public void testEsegui_null() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		ComandoPosa comando = new ComandoPosa();
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_Presente() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		ComandoPosa posa = new ComandoPosa();
		Attrezzo osso = new Attrezzo("osso", 3);
		partita.getGiocatore().borsa.addAttrezzo(osso);
		posa.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_assente() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		ComandoPosa posa = new ComandoPosa();
		Attrezzo osso = new Attrezzo("osso", 3);
		partita.getGiocatore().borsa.addAttrezzo(osso);
		posa.esegui(partita, io);
	}

}
