package bridgedemo;

public class Book extends Manuscript{
	
	private String name;
	private String isbn;
	
	public Book(String name, String isbn, FormatterI formatter){
		super.formatter =formatter;
		this.name = name;
		this.isbn = isbn;
	}

	@Override
	public void print() {
		System.out.println(formatter.format("Name:{0}", this.name));
		System.out.println(formatter.format("ISBN:{0}", this.isbn));
	}
	
	

}
