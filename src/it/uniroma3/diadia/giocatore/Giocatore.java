package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	
	public int cfu;
	public Borsa borsa;
	public IO IO;
	
	
	//crea un giocatore e gli da i cfu
	public Giocatore () {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
		this.IO = new IOConsole();
	}
	
	//per raccogliere un oggetto
	public boolean Raccogli(Attrezzo attrezzo) {
		if(attrezzo==null) {
			IO.mostraMessaggio("Questo attrezzo non è presente qui dentro");
		}
		else if (this.borsa.addAttrezzo(attrezzo) == true) {
			IO.mostraMessaggio(attrezzo.nome + " è stato aggiunto alla borsa");
			return true;
		}
		else if(this.borsa.addAttrezzo(attrezzo) == false) {
			IO.mostraMessaggio("Non è stato possibile aggiungere alla borsa " + attrezzo.nome);
		}
		return false;
	}
	
	public void Posa (Attrezzo attrezzo) {
		if(this.borsa.hasAttrezzo(attrezzo.nome) == true) {
			IO.mostraMessaggio("Hai posato "+ attrezzo.nome);
			this.borsa.removeAttrezzo(attrezzo.nome);
			/*Stanza.addAttrezzo(attrezzo);  AGGIUNGI NEL COMANDO POSA*/
		}
		else { 
			IO.mostraMessaggio("Non hai questo oggetto nella tua borsa");
		}
	}
	
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
