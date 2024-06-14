package it.uniroma3.diadia.test;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	@Test
	public void testAddAttrezzo_PesoOggettoEccessivo() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("ascia", 12);
		borsa.addAttrezzo(attrezzo);
	}
	
	@Test
	public void testAddAttrezzo_PesoBorsaEccessivo() {
		Borsa borsa = new Borsa();
		Attrezzo ascia = new Attrezzo("ascia", 3);
		Attrezzo martello = new Attrezzo("m", 8);
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(ascia);
	}
	
	@Test
	public void testAddAttrezzo_TuttoFunziona() {
		Borsa borsa = new Borsa();
		Attrezzo ascia = new Attrezzo("ascia", 4);
		borsa.addAttrezzo(ascia);
	}

}
