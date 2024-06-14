package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends Personaggio{
	private String cibo;
	private Attrezzo regalo;
	public Cane(String nome, String presentaz, String cibo, Attrezzo regalo) {
		super(nome, presentaz);
		this.cibo  = cibo;
		this.regalo = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg  = ("Wof Wof...\n(Controlla i tuoi CFU)");
		int nuovo = partita.giocatore.getCfu()-3;
		partita.giocatore.setCfu(nuovo);
		return msg;
	}
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = null;
		if(attrezzo.getNome().equals(cibo)) {
			partita.getStanzaCorrente().addAttrezzo(this.regalo);
			msg = ("Ha apprezzato molto il tuo regalo\n(Controlla dentro la stanza)");
		}
		else {
			msg = ("Non sembra aver apprezzato");
		}
		return msg;
	}
	
}
