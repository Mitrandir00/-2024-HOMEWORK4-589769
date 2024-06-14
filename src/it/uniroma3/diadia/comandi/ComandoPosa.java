package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {

	

	@Override
	public void esegui(Partita partita, IO io) {
		if(parametro==null) {
			io.mostraMessaggio("Quale oggetto vuoi posare?");
			parametro = io.leggiRiga();
		}
		if(partita.giocatore.borsa.hasAttrezzo(parametro)== false) {
			io.mostraMessaggio("Non hai questo attrezzo nella borsa");
		}
		else {
			Attrezzo attrezzo = partita.giocatore.borsa.getAttrezzo(parametro);
			partita.giocatore.borsa.removeAttrezzo(this.parametro);
			partita.stanzaCorrente.addAttrezzo(attrezzo);
			io.mostraMessaggio("Hai lasciato "+parametro);
		}
	}
}
