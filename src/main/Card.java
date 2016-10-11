package main;

public class Card {
	
	// string class field to keep word from dictionary
	private String Word;
	// string class field to keep translation of word from dictionary
	private String Translation;
	// int class filed to keep card state (front(word) = 0, cover(translation) = 1) 
	private int State;
	// int class filed to keep card position in Deck
	private int Position;

	// class constructor
	// get string word, string translation, int position and int state 
	public Card(String word, String trans, int pos, int state){
		setWord(word);
		setTranslation(trans);
		setPosition(pos);
		setState(state);
	}

	// getter for Word
	// gets nothing
	// returns String Word
	public String getWord() {
		return Word;
	}
	
	// setter for Word
	// gets string and puts it to Word class field
	// returns nothing
	public void setWord(String word) {
		Word = word;
	}
	
	// getter for Translation
	// gets nothing
	// returns String Translation
	public String getTranslation() {
		return Translation;
	}
	
	// setter for Translation
	// gets string and puts it to Translation class field
	// returns nothing
	public void setTranslation(String translation) {
		Translation = translation;
	}

	// getter for State
	// gets nothing
	// returns int State class field
	public int getState() {
		return State;
	}

	// setter for State
	// gets int and puts it to State class field
	// returns nothing
	public void setState(int state) {
		State = state;
	}
	
	// check state methods
	// gets int as value
	// return true if State equals value and false otherwise
	public boolean checkState(int state) {
		int current_state = getState();
		if (current_state == state){
			return true;
		} else {
			return false;
		}
	}
	
	// reverse card methods
	// gets nothing
	// set State to 0 if it was 1 and vice versa (1 if 0)
	public void reverseCard(){
		if (checkState(0)) {
			setState(1);
		} 
		else {
			setState(0);
		}
	}

	// getter for Position
	// gets nothing
	// returns int Position class field
	public int getPosition() {
		return Position;
	}

	// setter for Position
	// gets int and puts it to Position class field
	// returns nothing
	public void setPosition(int position) {
		Position = position;
	}

}
