package br.com.cfg.model;

import java.util.Map;

public abstract class ElevatorGroup extends ComponentImpl {

	public ElevatorGroup(String metadataId){
		super();
		setMetadataId(metadataId);
	}
	
	public ElevatorGroup(String metadataId, Map<String, String> dataMap) {
		super(dataMap);
		setMetadataId(metadataId);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
