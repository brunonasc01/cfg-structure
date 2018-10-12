package br.com.cfg.model;

import java.util.Map;

public abstract class Elevator extends ComponentImpl {

	public Elevator(String metadataId){
		super();
		setMetadataId(metadataId);
	}
	
	public Elevator(String metadataId, Map<String, String> dataMap) {
		super(dataMap);
		setMetadataId(metadataId);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
