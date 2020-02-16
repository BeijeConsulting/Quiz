package it.beije.quiz.model;

public class LiveForm {

	private int numeroRisposte;

	private boolean primoGiro = true;

	public boolean isPrimoGiro() {
		return primoGiro;
	}

	public void setPrimoGiro(boolean primoGiro) {
		this.primoGiro = primoGiro;
	}

	public int getNumeroRisposte() {
		return numeroRisposte;
	}

	public void setNumeroRisposte(int numeroRisposte) {
		this.numeroRisposte = numeroRisposte;
	}

	public String textBoxToJsp() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < getNumeroRisposte(); i++) {
			sb.append("Risposta "+(i+1)+"&nbsp;&nbsp;<input type=\"text\" name=\"risposta"+(i+1)+"\"><br><br>");
		}
		if (primoGiro==false) {
			sb.append("<br><input type=\"submit\" value=\"Conferma risposte\">");
			
		} else{
			sb.append("<br><input type=\"submit\" value=\"Inserisci risposte\">");
		}

		return sb.toString();
	}
}
