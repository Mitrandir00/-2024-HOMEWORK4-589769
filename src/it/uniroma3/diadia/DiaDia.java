package it.uniroma3.diadia;



import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private Partita partita;
	public Attrezzo attrezzo;
	public IO io;


	public DiaDia(IO io, Labirinto lab) {
		this.partita = new Partita(lab);
		this.io = io;

	}

	public void gioca(IO io) {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione)) {
			istruzione = io.leggiRiga();
		}
	}   


	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, this.io);
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		}

		if (this.partita.getGiocatore().getCfu()<=0) {
			io.mostraMessaggio("Hai esaurito i CFU...");
			return this.partita.isFinita();
		}
		if (this.partita.finita==true) {
			io.mostraMessaggio("grazie di aver giocato");
		}
		return false;
	}

	public static void main(String[] argc) {
		IO io = new IOConsole();
		CaricatoreLabirinto labirinto = null;
		try {
			labirinto = new CaricatoreLabirinto("labirinto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			labirinto.carica();
		} catch (FormatoFileNonValidoException e) {
			e.printStackTrace();
		}
		/*Labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				//.addAttrezzo("ascia", 5)
				.addStanza("cucina")
				//.addAttrezzo("pentola",1) 
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();*/
		DiaDia gioco = new DiaDia(io, labirinto.getLabirinto());
		gioco.gioca(io);
	}
}