package bridgedemo;

public interface FormatterI<T> {
	
	public T format(String format, T value);

}
