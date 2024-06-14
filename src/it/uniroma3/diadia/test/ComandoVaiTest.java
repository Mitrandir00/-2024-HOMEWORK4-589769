package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	@Test
	public void testEsegui_null() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		ComandoVai comando = new ComandoVai();
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_direzione() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		ComandoVai comando = new ComandoVai();
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_nonEsistente() {
		Labirinto lab = new Labirinto();
		Partita partita = new Partita(lab);
		IOConsole io = new IOConsole();
		partita.getStanzaCorrente().impostaStanzaAdiacente("sud", null);
		ComandoVai comando = new ComandoVai();
		comando.esegui(partita, io);
	}

}
