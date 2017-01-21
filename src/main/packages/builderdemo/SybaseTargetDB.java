package builderdemo;

public class SybaseTargetDB implements DataStreamTarget{
	
	private String database;
	
	private String tableName;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}
