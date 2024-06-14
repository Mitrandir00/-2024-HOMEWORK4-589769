package it.uniroma3.diadia.test;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	@Test
	public void testRaccogli_OggettoNullo() {
		Attrezzo ascia = new Attrezzo("ascia", 4);
		ascia=null;
		Giocatore persona = new Giocatore();
		persona.Raccogli(ascia);
		
	}
	
	@Test
	public void testRaccogli_Riesce() {
		Attrezzo ascia = new Attrezzo("ascia", 4);
		Giocatore persona = new Giocatore();
		persona.Raccogli(ascia);
		
	}
	
	@Test
	public void testRaccogli_NonRiesce() {
		Attrezzo ascia = new Attrezzo("ascia", 4);
		Attrezzo mazza = new Attrezzo("mazza", 8);
		Giocatore persona = new Giocatore();
		persona.Raccogli(ascia);
		persona.Raccogli(mazza);
		
	}

}
