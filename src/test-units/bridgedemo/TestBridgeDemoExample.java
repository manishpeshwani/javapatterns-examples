package bridgedemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBridgeDemoExample {

	@Test
	public void test() {
		FormatterI<String> formatter = new StandarFormatter();
		Book book = new Book("Head First in Patterns","ABC0001",formatter);
		book.print();
		
		Document doc = new Document("12",formatter);
		doc.print();
	}

}
