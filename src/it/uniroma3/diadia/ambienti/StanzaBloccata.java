package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzione;
	private String chiave;

	public StanzaBloccata(String nome, String direzione, String chiave) {
		super(nome);
		this.direzione = direzione;
		this.chiave = chiave;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione == this.direzione) {
			if(super.hasAttrezzo(chiave)) {
				return super.getStanzaAdiacente(direzione);
			}
		}
		System.out.println("Questa posrta è chiusa");
		return super.getStanzaAdiacente(null);
	}

	@Override
	public String getDescrizione() {
		return this.toString()+"\nLa porta in direzione "+this.direzione+" è bloccata :(";
	}

}
