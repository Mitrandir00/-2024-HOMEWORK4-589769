package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest3 {

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo b = new Attrezzo("Bastone", 5);
		Attrezzo c = new Attrezzo("Clava", 2);
		Borsa y = new Borsa();
		y.addAttrezzo(b);
		y.addAttrezzo(c);
		y.getContenutoOrdinatoPerPeso();
		
	}

}
