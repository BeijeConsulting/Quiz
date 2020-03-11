package it.beije.quiz.model;

public class Risposta {
	
	private String value;
	private String text;
	
	public String getValue() {
		return value;
	}
	public String getText() {
		return text;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Risposta [value=" + value + ", text=" + text + "]";
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Risposta() {
		
	}
}
