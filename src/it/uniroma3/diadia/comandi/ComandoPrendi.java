package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	
	
	@Override
	public void esegui(Partita partita, IO io) {
		if(parametro==null) {
			io.mostraMessaggio("Quale oggetto vuoi raccogliere?");
			parametro = io.leggiRiga();
		}
		if(partita.stanzaCorrente.hasAttrezzo(parametro)==false) {
			partita.giocatore.Raccogli(null);
		}
		else {
			Attrezzo attrezzo = partita.stanzaCorrente.getAttrezzo(parametro);
			if (partita.giocatore.Raccogli(attrezzo) == true) {
				partita.stanzaCorrente.removeAttrezzo(attrezzo.nome);
			}
		}
		
	}

	

}

