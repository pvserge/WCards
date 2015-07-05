package main;

import java.util.ArrayList;

public class Loader {

	private Config conf = new Config();
	private String dataFile;
	private Deck wordsDeck = new Deck();
	private ArrayList<Card> cards;
	
	public void init(){
		
		getConf().readConfig();
		setDataFile(getConf().get_dataFile());
		getWordsDeck().initDeck(getDataFile());
		setCards(getWordsDeck().getCards());

	}

	public Config getConf() {
		return conf;
	}

	public void setConf(Config conf) {
		this.conf = conf;
	}

	public String getDataFile() {
		return dataFile;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	public Deck getWordsDeck() {
		return wordsDeck;
	}

	public void setWordsDeck(Deck wordsDeck) {
		this.wordsDeck = wordsDeck;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	

}
