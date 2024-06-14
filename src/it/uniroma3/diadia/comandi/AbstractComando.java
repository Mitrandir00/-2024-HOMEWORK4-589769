package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{
	protected String parametro;
	
	abstract public void esegui (Partita partita, IO io);
	
	@Override
	public void setParametro (String parametro, IO io) {
		this.parametro = parametro;
	}
	
}
