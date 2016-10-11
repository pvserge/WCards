package main;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDeck {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Deck test_deck;
	private ArrayList<Card> test_cards;
	private Card test_card_1;
	private Card test_card_2;
	private Card test_card_3;
	private String test_data_out;
	private String test_data_in;

	@Before
	public void setUp() throws Exception {
		test_data_in = "test_data/test_vocab.txt";
		test_data_out = "test_data/test_dict.txt";
		test_deck = new Deck();		
		test_cards = new ArrayList<Card>();
		test_card_1 = new Card("key", "ключ", 0, 0);
		test_card_2 = new Card("hello", "привет", 1, 0);
		test_card_3 = new Card("bye", "пока", 2, 0);
		
		test_cards.add(test_card_1);
		test_cards.add(test_card_2);
		test_cards.add(test_card_3);
		
		assertNotNull(test_deck);
		assertNotNull(test_cards);
	}

	@After
	public void tearDown() throws Exception {
		String[] test_file_path = test_data_out.split("/");
		String test_path = test_file_path[0];
		String test_file = test_file_path[1];
		
		Path path = FileSystems.getDefault().getPath(test_path, test_file);
		Files.deleteIfExists(path);
	}

	@Test
	public void test_initDeck_size(){
		test_deck.initDeck(test_data_in);
		assertEquals(test_cards.size(), test_deck.getCards().size());
	}

	@Test
	public void test_initDeck_content(){
		test_deck.initDeck(test_data_in);
		for(int i = 0; i < test_cards.size(); i++){
			assertEquals(test_cards.get(i).getWord(), test_deck.getCards().get(i).getWord());
			assertEquals(test_cards.get(i).getTranslation(), test_deck.getCards().get(i).getTranslation());
			assertEquals(test_cards.get(i).getPosition(), test_deck.getCards().get(i).getPosition());
			assertEquals(test_cards.get(i).getState(), test_deck.getCards().get(i).getState());
		}
	}	
	
	@Test
	public void test_getCards() {
		assertNotNull(test_deck.getCards());
	}

	@Test
	public void test_setCards() {
		test_deck.setCards(test_cards);
		assertEquals(test_cards, test_deck.getCards());
	}

	@Test
	public void test_putCardToBottom() {
		test_deck.setCards(test_cards);
		test_deck.putCardToBottom(test_card_1);
		assertEquals(2, test_card_1.getPosition());
		assertEquals(0, test_card_2.getPosition());
		assertEquals(1, test_card_3.getPosition());
	}

	@Test
	public void test_saveDeckToFile() {
		test_deck.initDeck(test_data_in);
				
		test_deck.putCardToBottom(test_deck.getCards().get(0));
		
		test_deck.saveDeckToFile(test_data_out);
		
		Deck test_deck2 = new Deck();
		test_deck2.initDeck(test_data_out);
		
		assertEquals(test_deck.getCards().get(0).getWord(), test_deck2.getCards().get(2).getWord());
		assertEquals(test_deck.getCards().get(0).getTranslation(), test_deck2.getCards().get(2).getTranslation());

		assertEquals(test_deck.getCards().get(1).getWord(), test_deck2.getCards().get(0).getWord());
		assertEquals(test_deck.getCards().get(1).getTranslation(), test_deck2.getCards().get(0).getTranslation());

		assertEquals(test_deck.getCards().get(2).getWord(), test_deck2.getCards().get(1).getWord());
		assertEquals(test_deck.getCards().get(2).getTranslation(), test_deck2.getCards().get(1).getTranslation());		
	}

}
