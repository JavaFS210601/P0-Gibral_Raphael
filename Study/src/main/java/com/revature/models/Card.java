package com.revature.models;

public class Card {
	
	private int card_id;
	private String card_q;
	private String card_a;
	private boolean is_correct;
	private int deck_id_fk;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(int card_id, String card_q, String card_a, boolean is_correct, int deck_id_fk) {
		super();
		this.card_id = card_id;
		this.card_q = card_q;
		this.card_a = card_a;
		this.is_correct = is_correct;
		this.deck_id_fk = deck_id_fk;
	}

	public Card(String card_q, String card_a, boolean is_correct, int deck_id_fk) {
		super();
		this.card_q = card_q;
		this.card_a = card_a;
		this.is_correct = is_correct;
		this.deck_id_fk = deck_id_fk;
	}

	@Override
	public String toString() {
		return "Card [card_id=" + card_id + ", card_q=" + card_q + ", card_a=" + card_a + ", is_correct=" + is_correct
				+ ", deck_id_fk=" + deck_id_fk + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card_a == null) ? 0 : card_a.hashCode());
		result = prime * result + card_id;
		result = prime * result + ((card_q == null) ? 0 : card_q.hashCode());
		result = prime * result + deck_id_fk;
		result = prime * result + (is_correct ? 1231 : 1237);
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
		Card other = (Card) obj;
		if (card_a == null) {
			if (other.card_a != null)
				return false;
		} else if (!card_a.equals(other.card_a))
			return false;
		if (card_id != other.card_id)
			return false;
		if (card_q == null) {
			if (other.card_q != null)
				return false;
		} else if (!card_q.equals(other.card_q))
			return false;
		if (deck_id_fk != other.deck_id_fk)
			return false;
		if (is_correct != other.is_correct)
			return false;
		return true;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getCard_q() {
		return card_q;
	}

	public void setCard_q(String card_q) {
		this.card_q = card_q;
	}

	public String getCard_a() {
		return card_a;
	}

	public void setCard_a(String card_a) {
		this.card_a = card_a;
	}

	public boolean isIs_correct() {
		return is_correct;
	}

	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}

	public int getDeck_id_fk() {
		return deck_id_fk;
	}

	public void setDeck_id_fk(int deck_id_fk) {
		this.deck_id_fk = deck_id_fk;
	}
	
	
	
	

}
