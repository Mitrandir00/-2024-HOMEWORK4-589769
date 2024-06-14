package it.uniroma3.diadia.ambienti;

import java.io.*;
import java.util.*;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze: ";  

	private static final String STANZEBUIE_MARKER = "Buie: ";
	
	private static final String STANZEBLOCCATE_MARKER = "Bloccate: ";
	
	private static final String STANZEMAGICHE_MARKER = "Magiche: ";
	
	private static final String CANI_MARKER = "Cani: ";
	
	private static final String MAGHI_MARKER = "Maghi: ";
	
	private static final String STREGHE_MARKER = "Streghe: ";

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio: ";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente: ";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi: ";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";

	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Labirinto.LabirintoBuilder labirinto;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader("C://Users//182935//Desktop//"+nomeFile+".txt"));
		this.labirinto = new Labirinto.LabirintoBuilder();
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiECreaStanzeBuie();
			this.leggiECreaStanzeBloccate();
			this.leggiECreaStanzeMagiche();
			this.leggiECreaCani();
			this.leggiECreaMaghi();
			this.leggiECreaStreghe();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
		} finally {
			try {
				this.reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = specificaStanza; 
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				nomeStanza = scannerLinea.next();
				Stanza stanza = new Stanza(nomeStanza);
				this.nome2stanza.put(nomeStanza, stanza);
				this.labirinto.addStanza(nomeStanza);
			}				
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		ArrayList<String> result = new ArrayList<String>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(", ");
		while(scanner.hasNext()) {
			String i =scanner.next();
			result.add(i);
		}
		scanner.close();
		return result;
	}

	private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZEBUIE_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String oggetto = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza."));
					nomeStanza = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo "+oggetto+"."));
					oggetto = scannerLinea.next();
				}
				StanzaBuia stanza = new StanzaBuia(nomeStanza, oggetto);
				this.nome2stanza.put(nomeStanza, stanza);
				this.labirinto.addStanzaBuia(nomeStanza, oggetto);
			}				
		}
	}
	
	
	private void leggiECreaStanzeBloccate() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZEBLOCCATE_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String oggetto = null;
			String direzione = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza."));
					nomeStanza = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("la direzione."));
					direzione = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo "+oggetto+"."));
					oggetto = scannerLinea.next();
				}
				StanzaBloccata stanza = new StanzaBloccata(nomeStanza, direzione, oggetto);
				this.nome2stanza.put(nomeStanza, stanza);
				this.labirinto.addStanzaBloccata(nomeStanza, direzione, oggetto);
			}				
		}
	}
	
	private void leggiECreaStanzeMagiche() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZEMAGICHE_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStanza = null;
			String oggetto = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza."));
					nomeStanza = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome dell'attrezzo "+oggetto+"."));
					oggetto = scannerLinea.next();
				}
				int contatore;
				contatore = Integer.parseInt(oggetto);
				StanzaMagica stanza = new StanzaMagica(nomeStanza, contatore);
				this.nome2stanza.put(nomeStanza, stanza);
				this.labirinto.addStanzaMagica(nomeStanza, contatore);
			}				
		}
	}
	
	private void leggiECreaCani() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(CANI_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeCane = null;
			String presentazione= null;
			String cibo = null;
			String nomeRegalo = null;
			String pesoRegalo = null;
			String stanza = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome del cane."));
					nomeCane = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("la presentazione (una parola)."));
					presentazione = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome del cibo."));
					cibo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome del regalo."));
					nomeRegalo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso del regalo."));
					pesoRegalo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("dove va il cane."));
					stanza = scannerLinea.next();
				}
				int peso;
				peso = Integer.parseInt(pesoRegalo);
				Attrezzo attrezzo = new Attrezzo(nomeRegalo, peso);
				Cane cane = new Cane(nomeCane, presentazione, cibo, attrezzo);
				this.labirinto.getLabirinto().lab.get(stanza).addPersonaggio(cane);
			}				
		}
	}
	
	private void leggiECreaMaghi() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(MAGHI_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeMago = null;
			String presentazione= null;
			String nomeRegalo = null;
			String pesoRegalo = null;
			String stanza = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome del mago."));
					nomeMago = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("la presentazione (una parola)."));
					presentazione = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome del regalo."));
					nomeRegalo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso del regalo."));
					pesoRegalo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("dove va il mago."));
					stanza = scannerLinea.next();
				}
				int peso;
				peso = Integer.parseInt(pesoRegalo);
				Attrezzo attrezzo = new Attrezzo(nomeRegalo, peso);
				Mago mago = new Mago(nomeMago, presentazione, attrezzo);
				this.labirinto.getLabirinto().lab.get(stanza).addPersonaggio(mago);
			}				
		}
	}
	
	
	private void leggiECreaStreghe() throws FormatoFileNonValidoException{
		String nomiStanze = this.leggiRigaCheCominciaPer(STREGHE_MARKER);
		for(String specificaStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nomeStrega = null;
			String presentazione= null;
			String stanza = null;
			try (Scanner scannerLinea = new Scanner(specificaStanza)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della strega."));
					nomeStrega = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("la presentazione (una parola)."));
					presentazione = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("dove va la strega."));
					stanza = scannerLinea.next();
				}
				Strega strega = new Strega(nomeStrega, presentazione);
				this.labirinto.getLabirinto().lab.get(stanza).addPersonaggio(strega);
			}				
		}
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
		this.labirinto.addStanzaIniziale(this.stanzaIniziale);
		this.labirinto.addStanzaVincente(this.stanzaVincente);
	}


	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				while(scannerLinea.hasNext()) {
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
					nomeAttrezzo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
					pesoAttrezzo = scannerLinea.next();
					check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
					nomeStanza = scannerLinea.next();
				}				
				posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
			}

		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			//this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
			this.labirinto.addAttrezzo(nomeAttrezzo, peso, nomeStanza);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);

		for(String specificaUscita : separaStringheAlleVirgole(specificheUscite)) {
			String stanzaPartenza = null;
			String dir = null;
			String stanzaDestinazione = null; 
			try (Scanner scannerDiLinea = new Scanner(specificaUscita)) {			

				while (scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
					stanzaPartenza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
					dir = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
					stanzaDestinazione = scannerDiLinea.next();
					impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
				}
			} 
		}

	}

	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		//Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		//Stanza arrivoA = this.nome2stanza.get(nomeA);
		//partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
		this.labirinto.addAdiacenza(stanzaDa, nomeA, dir);
	}





	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	public Labirinto getLabirinto() {
		return this.labirinto.getLabirinto();
	}
}


