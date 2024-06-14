package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	private Attrezzo oggetto;

	@Override
	public void esegui(Partita partita, IO io) {
		if(partita.getStanzaCorrente().getPersonaggio()==null) {
			io.mostraMessaggio("Ma non c'è nessuno qui...");
		}
		else {
			io.mostraMessaggio("Quale oggetto vorresti regalare?");
			this.parametro = io.leggiRiga();
			if(partita.giocatore.borsa.hasAttrezzo(this.parametro)) {
				this.oggetto = partita.giocatore.borsa.getAttrezzo(this.parametro);
				partita.giocatore.borsa.removeAttrezzo(this.parametro);
				io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(this.oggetto, partita));
			}
			else { 
				io.mostraMessaggio("Mi spiace ma non possiedi questo oggetto");
			}
		}

	}

}
