package bridgedemo;

import java.text.MessageFormat;

public class StandarFormatter implements FormatterI<String>{

	@Override
	public String format(String format, String value) {
		
		return MessageFormat.format(format, value);
	}

	

	

}
