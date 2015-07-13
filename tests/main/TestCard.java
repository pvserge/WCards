package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCard {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Card card;

	@Before
	public void setUp() throws Exception {
		card = new Card("key", "ключ", 0, 0);
		assertNotNull(card);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_getWord() {
		assertEquals("key", card.getWord());
	}

	@Test
	public void test_setWord() {
		card.setWord("new");
		assertEquals("new", card.getWord());
	}

	@Test
	public void test_getTranslation() {
		assertEquals("ключ", card.getTranslation());
	}

	@Test
	public void test_setTranslation() {
		card.setTranslation("новый");
		assertEquals("новый", card.getTranslation());
	}
	
	@Test
	public void test_getState() {
		assertEquals(0, card.getState());
	}

	@Test
	public void test_setState() {
		card.setState(1);
		assertEquals(1, card.getState());
	}
	
	@Test
	public void test_checkState_True() {
		assertTrue(card.checkState(0));
	}
	
	@Test
	public void test_checkState_False() {
		assertFalse(card.checkState(1));
	}

	@Test
	public void test_checkState_TrueAfterSet() {
		card.setState(1);
		assertFalse(card.checkState(0));
	}

	@Test
	public void test_checkState_FalseAfterSet() {
		card.setState(1);
		assertFalse(card.checkState(0));
	}

	@Test
	public void test_reverseCard() {
		card.reverseCard();
		assertEquals(1, card.getState());
	}

	@Test
	public void test_reverseCard_AfterSet() {
		card.setState(1);
		card.reverseCard();
		assertEquals(0, card.getState());
	}

	@Test
	public void test_getPosition() {
		assertEquals(0, card.getPosition());
	}

	@Test
	public void test_setPosition() {
		card.setPosition(50);
		assertEquals(50, card.getPosition());
	}

}
