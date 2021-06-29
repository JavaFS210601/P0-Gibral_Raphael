package com.revature.models;

public class Deck {
	
	private int deck_id;
	private String deck_name;
	
	
	public Deck(String deck_name) {
		super();
		this.deck_name = deck_name;
	}


	public Deck(int deck_id, String deck_name) {
		super();
		this.deck_id = deck_id;
		this.deck_name = deck_name;
	}


	public Deck() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Deck [deck_id=" + deck_id + ", deck_name=" + deck_name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deck_id;
		result = prime * result + ((deck_name == null) ? 0 : deck_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (deck_id != other.deck_id)
			return false;
		if (deck_name == null) {
			if (other.deck_name != null)
				return false;
		} else if (!deck_name.equals(other.deck_name))
			return false;
		return true;
	}


	public int getDeck_id() {
		return deck_id;
	}


	public void setDeck_id(int deck_id) {
		this.deck_id = deck_id;
	}


	public String getDeck_name() {
		return deck_name;
	}


	public void setDeck_name(String deck_name) {
		this.deck_name = deck_name;
	}
	
	
	
	

}
