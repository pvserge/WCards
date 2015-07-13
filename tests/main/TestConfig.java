package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConfig {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Config config;

	@Before
	public void setUp() throws Exception {
		config = new Config();
		assertNotNull(config);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_getDataFile() {
		assertNull(config.getDataFile());
	}

	@Test
	public void test_readConfig() {
		config.readConfig();
		assertEquals("data/vocab.txt", config.getDataFile());
	}

}
