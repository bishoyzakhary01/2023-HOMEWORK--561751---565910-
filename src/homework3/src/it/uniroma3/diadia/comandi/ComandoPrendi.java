package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	public ComandoPrendi(IO io) {
		super();
		this.io = io;
	}

	private String nomeAttrezzo;
	private String nomeComando = "prendi" ;
	public IO io;
	
	@Override
	public void esegui(Partita partita) {
		if(this.nomeAttrezzo!=null) {
			Attrezzo a= partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);	
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("ho preso l'attrezzo:  "+ a);
			io.mostraMessaggio("Inserisci un altro commando \n");
		
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
		
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
		
	}

	@Override
	public String getNome() {
		return this.nomeComando;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io=io;
	}


}
