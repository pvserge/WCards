package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLoader {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Loader test_loader;

	@Before
	public void setUp() throws Exception {
		test_loader = new Loader();
		assertNotNull(test_loader);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_init() {
		test_loader.init();
		assertNotNull(test_loader.getConf());
		assertNotNull(test_loader.getDataFile());
		assertNotNull(test_loader.getWordsDeck());
		assertNotNull(test_loader.getCards()); 
	}

	@Test
	public void test_getConf() {
		test_loader.init();
		Config cnf = test_loader.getConf();
		assertNotNull(cnf);
	}

	@Test
	public void test_setConf() {
		Config cnf = new Config();
		test_loader.setConf(cnf);
		assertEquals(cnf, test_loader.getConf());
	}

	@Test
	public void test_getDataFile() {
		Config conf = new Config();
		conf.readConfig();
		String data = conf.getDataFile();
		test_loader.init();
		assertEquals(data, test_loader.getDataFile());
	}

	@Test
	public void test_setDataFile() {
		String data = "test/test.txt";
		test_loader.setDataFile(data);
		assertEquals(data, test_loader.getDataFile());
	}

	@Test
	public void test_getWordsDeck() {
		test_loader.init();
		Deck dk = test_loader.getWordsDeck();
		assertNotNull(dk);
	}

	@Test
	public void test_setWordsDeck() {
		Deck dk = new Deck();
		test_loader.setWordsDeck(dk);
		assertEquals(dk, test_loader.getWordsDeck());
	}

	@Test
	public void test_getCards() {
		test_loader.init();
		ArrayList<Card> crds = test_loader.getCards();
		assertNotNull(crds);		
	}

	@Test
	public void test_setCards() {
		test_loader.init();
		ArrayList<Card> crds = test_loader.getCards();
		crds.add(new Card("test", "тест", 0, 0));
		test_loader.setCards(crds);
		assertEquals(crds, test_loader.getCards());
	}

}
