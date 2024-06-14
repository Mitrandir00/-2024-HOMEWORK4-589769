package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Personaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
	public int numeroStanzeAdiacenti;    //FAI PRIVATE DOPO
	private List<String> direzioni;
	private Personaggio personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new ArrayList<String>();
		this.stanzeAdiacenti = new HashMap<String,Stanza>();
		this.attrezzi = new ArrayList<Attrezzo>();
		this.personaggio = null;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione in cui sara' posta la stanza adiacente.
	 * @param stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		if(numeroStanzeAdiacenti <= NUMERO_MASSIMO_DIREZIONI) {
			this.stanzeAdiacenti.put(direzione, stanza);
			this.direzioni.add(direzione);
			numeroStanzeAdiacenti++;
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}

	public List<String> getDirezioni() {
		return direzioni;
	}

	public Map<String,Stanza> getStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.add(attrezzo);			
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		Iterator<String> iteratore = this.direzioni.iterator();
		risultato.append("\nUscite: ");
		while(iteratore.hasNext()) {
			risultato.append(iteratore.next()+" ");
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo!=null) {				//AGGIUTNO DA ME
				risultato.append(attrezzo.toString()+" ");
			}
			else {
				continue;
			}
		}
		if(this.personaggio!=null) 
			risultato.append("\nPersonaggi presenti: "+personaggio.getNome());
		
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null && attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		attrezzoCercato = null;
		Attrezzo a;
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo))
				attrezzoCercato = a;
		}

		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
		boolean tolto = false;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			if(iteratore.next().getNome() == attrezzo) {
				iteratore.remove();
				tolto = true;
				this.numeroAttrezzi--;
			}
		}
		return tolto;
	}

	public void addPersonaggio(Personaggio persona) {
		this.personaggio = persona;
	}

	public Personaggio getPersonaggio() {
		return this.personaggio;
	}
}