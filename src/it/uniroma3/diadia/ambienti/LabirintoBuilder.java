/*package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {
	
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

}*/
