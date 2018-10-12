package br.com.cfg.model;

import java.util.HashMap;
import java.util.Map;

public class DataTable {
	private Map<String,String> data;
	
	public DataTable() {
		data = new HashMap<>();
	}

	public String getAttributeValue(String mnemonico) {
		return data.get(mnemonico);
	}
	
	public void setAttributeValue(String mnemonico, String value) {
		data.put(mnemonico, value);
	}
}
