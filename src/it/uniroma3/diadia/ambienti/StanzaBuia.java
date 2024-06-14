package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{

	private String utile;
	private boolean buia;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.buia = true;
		this.utile = attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo.getNome().equals (this.utile)) {
			this.buia = false;
		}
		return super.addAttrezzo(attrezzo);
	}
	
	@Override
	public String getDescrizione() {
		if(this.buia == true) {
			return ("E' tutto buio qua dentro, non si vede nulla");
		}
		return super.getDescrizione();	}

	@Override
	public String toString() {
		if(this.buia == true) {
			return ("E' tutto buio qua dentro, non si vede nulla");
		}
		return super.toString();	}
	}
