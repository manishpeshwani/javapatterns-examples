package builderdemo;

public class MongoTargetDB implements DataStreamTarget{
	
	private String mongoDatabase;
	
	private String mongoCollection;

	public String getMongoDatabase() {
		return mongoDatabase;
	}

	public void setMongoDatabase(String mongoDatabase) {
		this.mongoDatabase = mongoDatabase;
	}

	public String getMongoCollection() {
		return mongoCollection;
	}

	public void setMongoCollection(String mongoCollection) {
		this.mongoCollection = mongoCollection;
	}
	
	

}
