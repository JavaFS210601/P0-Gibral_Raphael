package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.CardDao;
import com.revature.daos.DeckDao;

public class Menu {
	
	DeckDao deckD = new DeckDao();
	CardDao cardD = new CardDao();
	
	public void display() {
		boolean displayMenu = true;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Gibral's Flashcards ");
		System.out.println("==========================================");
		
		
		while(displayMenu) {
			System.out.println("---------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("---------------");
			
			System.out.println("decks -> Show all decks");
			System.out.println("cards -> Show all cards");
			System.out.println("adddeck -> add a deck");
			System.out.println("addcard -> add a card");
			System.out.println("deletedeck -> delete a deck");
			System.out.println("deletecard -> delete a card");
			System.out.println("test -> test yourself on a deck");
			System.out.println("exit -> exit the program");
			
			
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
			
			case "decks": {
				System.out.println("Here are the Decks: ");
				List<Deck> decks = deckD.getAllDecks();
				
				for (Deck d : decks) {
					System.out.println(d);
				}
				
				break;
			}
			case "cards": {
				System.out.println("Here are the Cards: ");
				List<Card> cards = cardD.getAllCards();
				
				for (Card c : cards) {
					System.out.println(c);
				}
				break;
			}
			case "adddeck": {
				System.out.println("Enter the deck name: ");
				String deck_name = scan.nextLine();
				
				Deck newDeck = new Deck(deck_name);
				deckD.addDeck(newDeck);
;				break;
			}
			case "addcard": {
				System.out.println("Enter the Question for the card: ");
				String card_q = scan.nextLine();
				System.out.println("Enter the Answer for the card: ");
				String card_a = scan.nextLine();
				System.out.println("Enter the Deck Id you want the cards to go into: ");
				int deck_id_fk = scan.nextInt();
				scan.nextLine();
				
				Card newCard = new Card(card_q,card_a, false, deck_id_fk);
				
				cardD.addCard(newCard);
				break;
			}
			case "deletedeck": {
				System.out.println("These are the available decks: ");
				List<Deck> decks = deckD.getAllDecks();
				
				for (Deck d : decks) {
					System.out.println(d);
				}
				
				System.out.println("Enter the ID of the deck you would like to delete: ");
				int deckIdInput = scan.nextInt();
				scan.nextLine();
				
				deckD.removeDeck(deckIdInput);
				break;
			}
			case "deletecard": {
				System.out.println("Here are the Cards: ");
				List<Card> cards = cardD.getAllCards();
				
				for (Card c : cards) {
					System.out.println(c);
				}
				
				System.out.println("Enter the ID of the card you would like to delete: ");
				int cardIdInput = scan.nextInt();
				scan.nextLine();
				
				cardD.removeCard(cardIdInput);
				break;
			}
			case "test": {

				List<Deck> decks = deckD.getAllDecks();
				
				for (Deck d : decks) {
					System.out.println(d);
				}
				
				System.out.println("Enter the ID of the deck you would like to test on: ");
				int deckIdInput = scan.nextInt();
				scan.nextLine();
				
				List<Card> cards = cardD.getCards(deckIdInput);
				
				for (Card c : cards) {
					System.out.println(c.getCard_q());
					System.out.println("type enter to see the answer");
					scan.nextLine();
					System.out.println(c.getCard_a());
					System.out.println("Did you get it correct enter y for yes and n for no");
					String answer = scan.nextLine();
					if (answer.equals("y")) {
						cardD.changeIsCorrect(c.getCard_id());
					}
				}
				
				System.out.println("Below are the Cards you got right and wrong: ");
				List<Card> cards1 = cardD.getCards(deckIdInput);
				
				for (Card c : cards1) {
					System.out.println(c);
				}
				
				break;
			}
			case "exit":{
				displayMenu = false;
				System.out.println("Byeeeeeeeeeee");
				break;
				
			}
			default:{
				System.out.println("Didn't catch that.... try again");
			}
			
			}
			
			
			
		}
		
		
		
		
	}

}
