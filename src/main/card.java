package main;

public class Card {
	
	private String Word;
	private String Translation;
	private int State;
	private int Position;

	Card(String word, String trans, int pos, int state){
		setWord(word);
		setTranslation(trans);
		setPosition(pos);
		setState(state);
	}

	public String getWord() {
		return Word;
	}
	
	public void setWord(String word) {
		Word = word;
	}
	
	public String getTranslation() {
		return Translation;
	}
	
	public void setTranslation(String translation) {
		Translation = translation;
	}

	public int getState() {
		return State;
	}

	public void setState(int state) {
		State = state;
	}
	
	public boolean checkState(int state) {
		int current_state = getState();
		if (current_state == state){
			return true;
		} else {
			return false;
		}
	}
	
	public void reverseCard(){
		if (checkState(0)) {
			setState(1);
		} 
		else {
			setState(0);
		}
	}

	public int getPosition() {
		return Position;
	}

	public void setPosition(int position) {
		Position = position;
	}

}
