package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{

	static final private String[] elencoComandi = {".vai        .guarda\n.prendi     .posa\n.saluta    "
												+ " .interagisci\n.regala     .aiuto\n.fine\n"};
	@Override
	public void esegui(Partita partita, IO io) {
		IO IO = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}
}
