package it.uniroma3.diadia;

import java.util.List;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Fixture {
	public static IOSimulator creaSimulazionePartitaEGiocaEasy(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto =  new Labirinto.LabirintoBuilder()
				//.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3, "Atrio")
				//.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca(io);
		return io;
	}

	public static IOSimulator creaSimulazionePartitaEGiocaHard(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = new Labirinto.LabirintoBuilder()
				//.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3, "Atrio")
				//.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.addStanza("Bagno")
				.addAdiacenza("Bagno", "Atrio", "sud")
				.addAdiacenza("Atrio", "Bagno", "nord")
				.addStanza("Studio")
				.addAdiacenza("Studio", "Atrio", "est")
				.addAdiacenza("Atrio", "Studio", "ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca(io);
		return io;
	}

	public static IOSimulator creaSimulazionePartitaEGiocaMonolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto monolocale = new Labirinto.LabirintoBuilder()
				//.addStanzaIniziale("salotto") 
				//.addStanzaVincente("salotto") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca(io);
		return io;
	}
	
	
	public static IOSimulator creaSimulazionePartitaEGiocaBilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto bilocale = new Labirinto.LabirintoBuilder()
				//.addStanzaIniziale("salotto")
				//.addStanzaVincente("camera")
				.addAttrezzo("letto",10, "camera") 
				.addAdiacenza("salotto", "camera", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		gioco.gioca(io);
		return io;
	}
	
	public static IOSimulator creaSimulazionePartitaEGiocaTrilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto trilocale = new Labirinto.LabirintoBuilder()
				//.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1, "cucina") 
				//.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, trilocale);
		gioco.gioca(io);
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
