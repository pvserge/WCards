package main;
import java.util.*;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deck wordsDeck = new Deck();
		
		wordsDeck.initDeck();
		
		System.out.println("Hi there!");
		ArrayList<Card> cards = wordsDeck.getCards();
		for(int i = 0; i < cards.size(); i++){
			System.out.println(cards.get(i).getWord());
			System.out.println(cards.get(i).getTranslation());
		}

	}

}