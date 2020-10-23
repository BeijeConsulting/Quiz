package it.beije.quiz;

public class Pair<T,V> {
	private T first;
	private V last;
	
	public Pair(T first, V last) {
		this.first = first;
		this.last = last;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public V getLast() {
		return last;
	}

	public void setLast(V last) {
		this.last = last;
	}
	
	@Override
	public String toString() {
		return this.first + " ::: " + this.last;
	}
	
}
