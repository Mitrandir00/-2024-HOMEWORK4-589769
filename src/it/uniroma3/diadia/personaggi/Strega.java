package it.uniroma3.diadia.personaggi;

import java.util.Iterator;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends Personaggio{
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}
	
	
	@Override
	public String agisci(Partita partita) {
		Stanza temp = null;
		int moment = 0;
		String msg;
		String dir;
		Iterator<String> iteratore = partita.getStanzaCorrente().getDirezioni().iterator();
		if(this.haSalutato()==true) {
			while(iteratore.hasNext()) {
				dir = iteratore.next();
				if(partita.getStanzaCorrente().getStanzaAdiacente(dir).getNumeroAttrezzi()>moment) {
					moment  = partita.getStanzaCorrente().getStanzaAdiacente(dir).getNumeroAttrezzi();
					temp = partita.getStanzaCorrente().getStanzaAdiacente(dir);
				}
			}
			msg = ("Sei stato gentile con me\nti darò un piccolo aiuto");
		}
		else {
			moment = 10;
			while(iteratore.hasNext()) {
				dir = iteratore.next();
				if(partita.getStanzaCorrente().getStanzaAdiacente(dir).getNumeroAttrezzi()<moment) {
					moment = partita.getStanzaCorrente().getStanzaAdiacente(dir).getNumeroAttrezzi();
					temp = partita.getStanzaCorrente().getStanzaAdiacente(dir);
				}
			}
			msg = ("Non va più di moda essere educati?\nprendi questo");
		}
		partita.setStanzaCorrente(temp);
		return msg+(" (Controlla un po' dove sei ora...)");
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = ("HIHIHIHIHI, ora è mio");
		return msg;
	}

}
