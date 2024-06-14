package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test
	public void testAddAttrezzo_giusto() {
		Stanza stanza = new StanzaBuia("N10", "chiave");
		Attrezzo chiave = new Attrezzo("chiave", 2);
		stanza.addAttrezzo(chiave);
	}
	
	@Test
	public void testAddAttrezzo_sbagliato() {
		Stanza stanza = new StanzaBuia("N10", "tessera");
		Attrezzo chiave = new Attrezzo("chiave", 2);
		stanza.addAttrezzo(chiave);
	}

}
