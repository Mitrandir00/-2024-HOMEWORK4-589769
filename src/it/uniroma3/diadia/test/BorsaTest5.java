package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest5 {

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo a = new Attrezzo("Ascia",3);
		Attrezzo b = new Attrezzo("Bastone", 5);
		Attrezzo c = new Attrezzo("Clava", 2);
		Attrezzo d = new Attrezzo("Dente", 7);
		Attrezzo e = new Attrezzo("Elfo", 4);
		Attrezzo f = new Attrezzo("Fungo", 5);
		Attrezzo g = new Attrezzo("Dado", 5);
		Borsa y = new Borsa();
		y.addAttrezzo(a);
		y.addAttrezzo(b);
		y.addAttrezzo(c);
		y.addAttrezzo(d);
		y.addAttrezzo(e);
		y.addAttrezzo(f);
		y.addAttrezzo(g);
		y.getContenutoRaggruppatoPerPeso();
	}

}
