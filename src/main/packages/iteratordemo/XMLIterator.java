package iteratordemo;

import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;

public class XMLIterator implements Iterator<String>{
	
	private XMLEventReader reader;
	private String rootElementLocalName;
	private String documentElementLocalName;
	private static final String START_TAG = "<";
	private static final String END_TAG = ">";

	public XMLIterator(XMLEventReader reader, String rootElementLocalName, String documentElementLocalName){
		this.reader = reader;
		this.rootElementLocalName = rootElementLocalName;
		this.documentElementLocalName = documentElementLocalName;
	}
	
	@Override
	public boolean hasNext() {
		try {
			XMLEvent event = reader.peek();
			
			
			while(event !=null && event.getEventType() == XMLStreamConstants.CHARACTERS 
					&& (event.asCharacters().getData().equals("\n\t") || event.asCharacters().getData().equals("\n") || event.asCharacters().getData().equals("\t"))){
				reader.nextEvent();
				event = reader.peek();
			}
			
			if(event == null || (event.getEventType() == XMLStreamConstants.END_ELEMENT 
					&& event.asEndElement().getName().getLocalPart().equals(documentElementLocalName))){
				return false;
			}else {
				return true;
			}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public String next() {
		StringBuilder nextElementBuilder = null; 
		try {
			while(reader.hasNext()){
				
				XMLEvent event = reader.nextEvent();
				if(event.getEventType() == XMLStreamConstants.START_ELEMENT){
					StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    
                    if(qName.equals(rootElementLocalName)){
                    	nextElementBuilder = new StringBuilder();
                    	handleStartElement(startElement, nextElementBuilder);
                    }else {
                    	handleStartElement(startElement, nextElementBuilder);
                    }
				}
				
				if(event.getEventType() == XMLStreamConstants.END_ELEMENT){
					EndElement endElement = event.asEndElement();
					handleEndElement(endElement, nextElementBuilder);
					
					if(endElement.getName().getLocalPart().equals(rootElementLocalName)){
						return nextElementBuilder.toString();
					}
				}
				
				if(event.getEventType() == XMLStreamConstants.CHARACTERS){
					Characters characters = event.asCharacters();
					handleCharacters(characters, nextElementBuilder);
				}
				
				
			}
		
		} catch (XMLStreamException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
		
		return null;
	}

	private void handleCharacters(Characters characters, StringBuilder nextElementBuilder) {
		if(nextElementBuilder == null){
			return;
		}
		
		nextElementBuilder.append(characters.getData());
		
	}

	private void handleEndElement(EndElement endElement, StringBuilder nextElementBuilder) {
		
		if(nextElementBuilder == null){
			return;
		}
		
		nextElementBuilder.append(START_TAG).append("/").append(endElement.getName().getLocalPart()).append(END_TAG);
	}

	private void handleStartElement(StartElement startElement, StringBuilder nextElementBuilder) {
		
		if(nextElementBuilder == null){
			return;
		}
		
		nextElementBuilder.append(START_TAG).append(startElement.getName().getLocalPart());
		
		Iterator<Attribute> attributes = startElement.getAttributes();
		
		while(attributes.hasNext()){
			Attribute attribute = attributes.next();
			String attrName = attribute.getName().getLocalPart();
			String attrValue = attribute.getValue();
			
			nextElementBuilder.append(" ").append(attrName).append("='").append(attrValue).append("'");
		}
		
		nextElementBuilder.append(END_TAG);
		
	}
	
	

}
