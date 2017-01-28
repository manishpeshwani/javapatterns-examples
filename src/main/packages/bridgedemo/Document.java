package bridgedemo;

public class Document extends Manuscript{
	
	private String documentId;
	
	public Document(String documentId, FormatterI formatter){
		this.documentId = documentId;
		super.formatter = formatter;
	}

	@Override
	public void print() {
		System.out.println(formatter.format("DocumentId:{0}", this.documentId));
		
	}

}
