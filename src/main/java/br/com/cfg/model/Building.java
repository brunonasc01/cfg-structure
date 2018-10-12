package br.com.cfg.model;

import java.util.Map;

public class Building extends ComponentImpl {

	public Building() {
		super();
		setMetadataId("Building");
	}
	
	public Building(Map<String, String> dataMap) {
		super(dataMap);
		setMetadataId("Building");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}


