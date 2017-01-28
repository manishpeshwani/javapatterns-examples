package iteratordemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;


public class StaxXMLParser {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		
		
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
        factory.createXMLEventReader(
           new FileReader("C:\\Users\\manishpeshwani\\git\\javapatterns-examples\\src\\main\\packages\\iteratordemo\\Employees.xml"));
        
		Iterator<String> xmlIterator = new XMLIterator(eventReader, "Employee","Employees");
		
		while(xmlIterator.hasNext()){
			System.out.println(xmlIterator.next());
			System.out.println();
		}
		
		eventReader.close();
	}

}
