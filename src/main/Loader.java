package main;

import java.util.ArrayList;

public class Loader {

	// create new Config object
	private Config conf = new Config();
	// String class field to store full path to dictionary
	private String dataFile;
	// create new Deck object
	private Deck wordsDeck = new Deck();
	// create new array list of Card objects
	private ArrayList<Card> cards;
	
	// methods to initialize fields
	// gets nothing
	// reads config, set dataFile, initializes Desk, fills Cards array 
	// return nothing
	public void init(){	
		getConf().readConfig();
		setDataFile(getConf().getDataFile());
		getWordsDeck().initDeck(getDataFile());
		setCards(getWordsDeck().getCards());

	}

	// methods to get configuration
	// gets nothing
	// returns config
	public Config getConf() {
		return conf;
	}

	// methods to set Config
	// gets config object
	// returns nothing
	public void setConf(Config conf) {
		this.conf = conf;
	}

	// methods to get data file
	// gets nothing
	// returns dataFile class field
	public String getDataFile() {
		return dataFile;
	}

	// methods to set DataFile
	// gets string as dataFile
	// returns nothing
	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	// methods to get Deck of word's cards
	// gets nothing
	// returns Deck object
	public Deck getWordsDeck() {
		return wordsDeck;
	}

	// methods to set Deck of word's cards
	// gets Deck object
	// returns nothing
	public void setWordsDeck(Deck wordsDeck) {
		this.wordsDeck = wordsDeck;
	}

	// methods to get array list of Card's objects
	// gets nothing
	// returns array list of Card's objects
	public ArrayList<Card> getCards() {
		return cards;
	}

	// methods to set array list of Card's objects
	// gets array list of cards
	// returns nothing
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}	

}
