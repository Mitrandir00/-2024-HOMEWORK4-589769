package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	@Test
	public void testCostruisciComando_nomeGiustoParametroAssente() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		fabbrica.costruisciComando("vai");
	}
	
	@Test
	public void testCostruisciComando_nomeGiustoParametroPresente() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		fabbrica.costruisciComando("vai nord");
	}
	
	@Test
	public void testCostruisciComando_nomeSbagliatoParametroAssente() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		fabbrica.costruisciComando("leggi");
	}
	
	@Test
	public void testCostruisciComando_null() {
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
		fabbrica.costruisciComando("");
	}

}
