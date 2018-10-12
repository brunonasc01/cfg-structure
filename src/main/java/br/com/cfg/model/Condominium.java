package br.com.cfg.model;

import java.util.Map;

public class Condominium extends ComponentImpl {

	public Condominium(){
		super();
		setMetadataId("Condominium");
	}
	
	public Condominium(Map<String, String> dataMap) {
		super(dataMap);
		setMetadataId("Condominium");
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
