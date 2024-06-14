package it.uniroma3.diadia.test;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {

	@Test
	public void testIsFinita_CFU0() {
		Labirinto lab = new Labirinto();
		 Partita gioco = new Partita(lab);
		 gioco.finita = false;
		 gioco.stanzaCorrente = gioco.labirinto.getStanzaIniziale();
		 gioco.giocatore.cfu = 0;
		 gioco.isFinita();
	}
	
	@Test
	public void testIsFinita_Vittoria() {
		Labirinto lab = new Labirinto();
		 Partita gioco = new Partita(lab);
		 gioco.finita = false;
		 gioco.stanzaCorrente = gioco.labirinto.getStanzaVincente();
		 gioco.giocatore.cfu = 5;
		 gioco.isFinita();
	}
	
	@Test
	public void testIsFinita_Finita() {
		Labirinto lab = new Labirinto();
		 Partita gioco = new Partita(lab);
		 gioco.finita = true;
		 gioco.stanzaCorrente = gioco.labirinto.getStanzaIniziale();
		 gioco.giocatore.cfu = 5;
		 gioco.isFinita();
	}
}
