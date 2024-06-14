package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{

	@Override
	public void esegui(Partita partita, IO io) {
		partita.giocatore.borsa.getSortedSetOrdinatoPerPeso();
		io.mostraMessaggio(partita.giocatore.borsa.toString());
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Questi sono i tuoi CFU attuali: "+partita.giocatore.getCfu());
		
	}
}
