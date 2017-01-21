package builderdemo;

import org.junit.Assert;
import org.junit.Test;

public class TestDataStreamSpecificationBuilderTest {
	
	@Test
	public void testBuilder(){
		
		
		DataStreamSpecification spec = new DataStreamSpecificationBuilder().
				withDataStreamSource(getFileDataSource("C:/temp","*.csv")).
				withDataTarget(getMongoTargetDB("datalake","datastream1")).
				build();
		
		Assert.assertNotNull(spec);
		Assert.assertNotNull(spec.getDataStreamSource());
		Assert.assertNotNull(spec.getDataStreamTarget());
	}
	
	public DataStreamSource getFileDataSource(String inputFolder, String filePattern){
		FileSource fileSource = new FileSource();
		fileSource.setFilePattern(filePattern);
		fileSource.setInputFolder(inputFolder);
		
		return fileSource;
	}
	
	public DataStreamTarget getMongoTargetDB(String database, String collectionName){
		MongoTargetDB target = new MongoTargetDB();
		target.setMongoCollection("datastream1");
		target.setMongoDatabase("datalake");
		
		return target;
	}

}
