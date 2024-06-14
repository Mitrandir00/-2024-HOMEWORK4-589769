package it.uniroma3.diadia.giocatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;


	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo bastino...
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}


	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			peso +=iteratore.next().getPeso();
		}
		return peso;
	}


	public boolean isEmpty() {
		return this.attrezzi == null;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public boolean removeAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		Attrezzo a;
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return true;
			}
		}
		return false;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			while(iteratore.hasNext()) {
				s.append(iteratore.next().toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> temp = new ArrayList<Attrezzo>();
		temp.addAll(this.attrezzi);
		Collections.sort(temp, new ComparaPeso());
		return temp;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> temp = new TreeSet<Attrezzo>();
		temp.addAll(this.attrezzi);
		return temp;
	}
	
	public Map<Integer,SortedSet<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,SortedSet<Attrezzo>> temp = new HashMap<Integer,SortedSet<Attrezzo>>();
		getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		Attrezzo a;
		while(iteratore.hasNext()) {
			SortedSet<Attrezzo> p = new TreeSet<Attrezzo>();
			a = iteratore.next();
			if(temp.containsKey(a.getPeso()) == true) {
				p.addAll(temp.get(a.getPeso()));
				p.add(a);
				temp.put(a.getPeso(),p);
			}
			else {
				p.add(a);
				temp.put(a.getPeso(), p);
			}
		}
		return temp;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		List<Attrezzo> temp = new ArrayList<Attrezzo>();
		temp.addAll(this.attrezzi);
		Collections.sort(temp, new ComparaPeso());
		this.attrezzi = temp;
		SortedSet<Attrezzo> tempo = new TreeSet<Attrezzo>();
		tempo.addAll(temp);
		return tempo;
	}
}
