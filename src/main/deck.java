package main;
import java.util.*;

import main.Data;

public class Deck {
	
	// Data class object
	private Data Words = new Data();
	// Array list of Card objects
	private ArrayList<Card> Cards = new ArrayList<Card>();

	// methods to initialize Deck from dictionary file
	// gets full path to dictionary file
	// creates Array list of Card objects
	// returns nothing
	public void initDeck(String filename){
		
		Map<String, String> vocab = Words.initDict(filename);
		int i = 0;
		
		for (Map.Entry<String, String> entry: vocab.entrySet()) { 
			String word = entry.getKey(); 
			String translation = entry.getValue();
			Cards.add(new Card(word, translation, i, 0));
			i += 1;
		} 
		
	}

	// getter for Array list of Card objects
	// gets nothing
	// returns Cards array
	public ArrayList<Card> getCards() {
		return Cards;
	}

	// setter for Array list of Card objects
	// gets Cards array list
	// returns nothing
	public void setCards(ArrayList<Card> cards) {
		this.Cards = cards;
	}
	
	// methods to put appropriate card to bottom of Deck
	// gets Card object
	// re-orders Positions for all cards in Deck
	// returns nothing
	public void putCardToBottom(Card card){
		card.setPosition(Cards.size());
		for(int i = 0; i < Cards.size(); i++){
			Cards.get(i).setPosition(Cards.get(i).getPosition()-1);
		}
	}
	
	// methods to save Deck of Cards in current order to appropriate file
	// gets full path to file
	// creates new array list from Cards
	// created new vocab and puts values from Cards in Position order
	// returns nothing
	public void saveDeckToFile(String filename){
		Map<String, String> vocab = new LinkedHashMap<>();
		ArrayList<Card> crd = Cards;
		for(int i = 0; i < crd.size(); i++){
			for(Card item : crd){
				if(item.getPosition() == i){
					vocab.put(item.getWord(), item.getTranslation());
				}
			}		
		}
		Words.dictToFile(filename, vocab);
	}

}
