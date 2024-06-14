package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{


	@Override
	public void esegui(Partita partita, IO io) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else
			io.mostraMessaggio("Chi dovrei salutare?...Non c'è nessuno qui");
	}

}
