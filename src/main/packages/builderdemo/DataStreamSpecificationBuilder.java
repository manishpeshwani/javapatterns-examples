package builderdemo;

import java.util.Objects;

public class DataStreamSpecificationBuilder {
	
	private DataStreamSpecification dataStreamSpecification;
	
	public DataStreamSpecificationBuilder(){
		this.dataStreamSpecification = new DataStreamSpecification();
	}
	
	public DataStreamSpecificationBuilder withDataStreamSource(DataStreamSource source){		
		dataStreamSpecification.setDataStreamSource(source);		
		return this;
	}
	
	public DataStreamSpecificationBuilder withDataTarget(DataStreamTarget target){
		dataStreamSpecification.setDataStreamTarget(target);
		return this;
	}
	
	public DataStreamSpecification build(){
		Objects.nonNull(dataStreamSpecification.getDataStreamSource());
		Objects.nonNull(dataStreamSpecification.getDataStreamTarget());
		
		return this.dataStreamSpecification;
	}

}
