package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {


	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	public Map<String, Stanza> lab;



	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public void setStanzaInizaile(String nome, Stanza stanzaInizaile) {
		this.stanzaIniziale = stanzaInizaile;
		this.lab.put(nome, stanzaInizaile);
	}

	public void setStanzaFinale(String nome, Stanza fin) {
		this.stanzaVincente = fin;
		this.lab.put(nome, fin);
	}


	public Labirinto() {
		//creaStanze();
		lab = new HashMap<String, Stanza>();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	/*private void creaStanze() {

		// crea gli attrezzi 
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		lab.add(atrio);
		Stanza aulaN11 = new Stanza("Aula N11");
		lab.add(aulaN11);
		Stanza aulaN10 = new Stanza("Aula N10");
		lab.add(aulaN10);
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		lab.add(laboratorio);
		Stanza biblioteca = new Stanza("Biblioteca");
		lab.add(biblioteca);

		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		  //pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}*/

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	
	public static class LabirintoBuilder extends Labirinto {
		
		private Labirinto Labirinto;
		public LabirintoBuilder () {
			Labirinto = new Labirinto();
		}

		public LabirintoBuilder addStanza(String a) {
			Stanza c = new Stanza(a);
			this.Labirinto.lab.put(c.getNome(), c);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String chiave) {
			Stanza c = new StanzaBloccata(stanza, direzione, chiave);
			this.Labirinto.lab.put(c.getNome(), c);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String stanza, String chiave) {
			Stanza c = new StanzaBuia(stanza, chiave);
			this.Labirinto.lab.put(c.getNome(), c);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String stanza, int a) {
			Stanza c = new StanzaMagica(stanza, a);
			this.Labirinto.lab.put(c.getNome(), c);
			return this;
		}

		public LabirintoBuilder addStanzaIniziale(Stanza a) {
			this.Labirinto.setStanzaInizaile(a.getNome(), a);
			//this.Labirinto.lab.add(a);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(Stanza a) {
			this.Labirinto.setStanzaFinale(a.getNome(), a);
			//this.Labirinto.lab.add(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String inizio, String aggiungi, String direzione) {
			Stanza a = this.Labirinto.lab.get(inizio);
			Stanza b = this.Labirinto.lab.get(aggiungi);
			a.impostaStanzaAdiacente(direzione, b);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome, int a, String stanza) {
			Attrezzo attrezzo = new Attrezzo(nome,a);
			Stanza temp = this.Labirinto.lab.get(stanza);
			temp.addAttrezzo(attrezzo);
			return this;
		}

		public Labirinto getLabirinto() {
			return this.Labirinto;
		}

	}



	
}

