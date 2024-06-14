package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Test
	public void testGetStanzaAdiacente_bloccta() {
		Stanza stanza = new StanzaBloccata("N10","sud","chiave");
		Attrezzo tessera = new Attrezzo ("tessera", 2);
		stanza.addAttrezzo(tessera);
		stanza.getStanzaAdiacente("sud");
	}
	
	@Test
	public void testGetStanzaAdiacente_sbloccta() {
		Stanza stanza = new StanzaBloccata("N10","sud","tessera");
		Attrezzo tessera = new Attrezzo ("tessera", 2);
		stanza.addAttrezzo(tessera);
		stanza.getStanzaAdiacente("sud");
	}
	
	@Test
	public void testGetStanzaAdiacente_direzioneLibera() {
		Stanza stanza = new StanzaBloccata("N10","sud","chiave");
		Attrezzo tessera = new Attrezzo ("tessera", 2);
		stanza.addAttrezzo(tessera);
		stanza.getStanzaAdiacente("nord");
	}

}
