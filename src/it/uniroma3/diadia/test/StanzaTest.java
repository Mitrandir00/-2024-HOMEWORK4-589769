package it.uniroma3.diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testGetAttrezzo_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_stanzaNonVuota_assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("non presente"));
	}
}
