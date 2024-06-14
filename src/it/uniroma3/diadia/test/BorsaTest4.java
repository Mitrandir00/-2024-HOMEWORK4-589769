package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest4 {

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo d = new Attrezzo("Dente", 7);
		Attrezzo a = new Attrezzo("Ascia",3);
		Attrezzo g = new Attrezzo("Dado", 5);
		Borsa y = new Borsa();
		y.addAttrezzo(d);
		y.addAttrezzo(a);
		y.addAttrezzo(g);
		y.getContenutoOrdinatoPerNome();
	}

}
