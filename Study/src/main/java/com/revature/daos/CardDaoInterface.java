package com.revature.daos;

import java.util.List;

import com.revature.models.Card;
import com.revature.models.Deck;

public interface CardDaoInterface {
	
	public List<Card> getAllCards();
	
	public List<Card> getCards(int dkId);
	
	public void addCard(Card cd);
	
	public void removeCard(int cdId);
	
	public void changeIsCorrect(int cardId);
	
	public void resetIsCorrect();

}
