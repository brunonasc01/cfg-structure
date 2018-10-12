package br.com.cfg.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTable {
	private Map<String,AttributeData> data;
	
	public DataTable() {
		data = new HashMap<>();
	}

	public AttributeData getAttributeValue(String mnemonico) {
		return data.get(mnemonico);
	}
	
	public void setAttributeValue(String mnemonico, String value) {
		data.put(mnemonico, new AttributeData(mnemonico, value));
	}
	
	public void fillData(Map<String, String> dataMap){
		for(String mnemonico : dataMap.keySet()){
			setAttributeValue(mnemonico, dataMap.get(mnemonico));
		}
	}
	
	public List<AttributeData> getAttributeList(){
		return new ArrayList<>(data.values());
	}
}
