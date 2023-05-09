package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	private IO io;
	public FabbricaDiComandiFisarmonica (IO io) {
		this.io=io;
	}

	public Comando costruisciComando(String istruzione) {
		
		Scanner scannerDiParole = new Scanner(istruzione);
        String nomeComando=null;
        String parametro=null;
        Comando comando=null;
		
		
			
		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		
		//inizio comandi 
		if(nomeComando==null) 
			comando= new ComandoNonValido(io);
		
		else if (nomeComando.equals("fine")) 
			comando = new ComandoFine(io); 

		else if (nomeComando.equals("vai"))
        comando = new ComandoVai(io);
		
		else if(nomeComando.equals("prendi"))
			comando = new ComandoPrendi(io);
		
		else if(nomeComando.equals("posa"))
			comando = new ComandoPosa(io);
		
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(io);
		
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(io);
		
		else
			comando= new ComandoNonValido(io);
		comando.setParametro(parametro);
		return comando;
	}

}
