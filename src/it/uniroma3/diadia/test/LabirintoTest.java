package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	@Test
	public void testSetStanzaInizaile_giusta() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza iniziale");
		labirinto.setStanzaInizaile(stanza.getNome(), stanza);
	}
	
	@Test
	public void testSetStanzaInizaile_sbagliata() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza(null);
		labirinto.setStanzaInizaile(stanza.getNome(), stanza);
	}
	
	@Test
	public void testSetStanzaInizaile_giàFinito() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza finale");
		labirinto.setStanzaInizaile(stanza.getNome(), stanza);
		labirinto.setStanzaInizaile(stanza.getNome(), stanza);
	}

}
