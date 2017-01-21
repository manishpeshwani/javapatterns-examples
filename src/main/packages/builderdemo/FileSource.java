package builderdemo;

public class FileSource implements DataStreamSource{
	
	private String inputFolder;
	
	private String filePattern;

	public String getInputFolder() {
		return inputFolder;
	}

	public void setInputFolder(String inputFolder) {
		this.inputFolder = inputFolder;
	}

	public String getFilePattern() {
		return filePattern;
	}

	public void setFilePattern(String filePattern) {
		this.filePattern = filePattern;
	}
	
	

}
