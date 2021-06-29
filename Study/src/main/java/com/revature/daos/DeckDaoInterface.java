package com.revature.daos;

import java.util.List;

import com.revature.models.Deck;

public interface DeckDaoInterface {
	
	public List<Deck> getAllDecks();
	
	public void addDeck(Deck dk);
	
	public void removeDeck(int dkId);
	

}
