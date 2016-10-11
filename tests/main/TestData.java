package main;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestData {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Data test_data;
	private Map<String, String> test_vocab;
	private String test_data_in;
	private String test_data_out;

	@Before
	public void setUp() throws Exception {
		test_data = new Data();
		test_vocab = new LinkedHashMap<>();

		test_vocab.put("key", "ключ");
		test_vocab.put("hello", "привет");
		test_vocab.put("bye", "пока");
		
		test_data_in = "test_data/test_vocab.txt";
		test_data_out = "test_data/test_dict.txt";
		
		assertNotNull(test_data);
		assertNotNull(test_vocab);
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
	public void test_getVocab() {
		assertNotNull(test_data.getVocab());
	}

	@Test
	public void test_setVocab() {
		test_data.setVocab("key", "ключ");
		test_data.setVocab("hello", "привет");
		test_data.setVocab("bye", "пока");
		assertEquals(test_vocab, test_data.getVocab());
	}

	@Test
	public void test_initDict() {
		assertEquals(test_vocab, test_data.initDict(test_data_in));
	}

	@Test
	public void test_fileToDict() {
		test_data.fileToDict(test_data_in);
		assertEquals(test_vocab, test_data.getVocab());
	}

	@Test
	public void test_dictToFile() {
		test_vocab.put("mother", "мама");
		test_data.dictToFile(test_data_out, test_vocab);
		test_data.fileToDict(test_data_out);
		assertEquals(test_vocab, test_data.getVocab());
	}

}
