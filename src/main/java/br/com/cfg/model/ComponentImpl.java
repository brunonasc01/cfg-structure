package br.com.cfg.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ComponentImpl implements Component {

	private final static String LINE_BREAK = "\n";
	private long mInstanceId;
	private String metadataId;
	private long mFatherInstanceId;
	private DataTable dataTable;
	private Map<Long,Component> subComponentMap;
	
	public ComponentImpl() {
		init();
	}
	
	public ComponentImpl(Map<String, String> dataMap) {
		init();
		dataTable.fillData(dataMap);
	}
	
	protected void init(){
		dataTable = new DataTable();
		subComponentMap = new HashMap<>();
//		this.metadataId = metadataId;
		this.mInstanceId = new Random(8).nextLong();
	}
	
	@Override
	public long getInstanceId() {
		return mInstanceId;
	}

	@Override
	public void setInstanceId(long instId) {
		this.mInstanceId = instId;
	}
	
	@Override
	public AttributeData getAttributeData(String mnemonico) {
		return dataTable.getAttributeValue(mnemonico);
	}

	@Override
	public String getAttributeValue(String mnemonico) {
		AttributeData attData = dataTable.getAttributeValue(mnemonico);
		return (attData != null)? attData.getValue() : "";
	}

	@Override
	public void setAttributeValue(String mnemonico, String value) {
		dataTable.setAttributeValue(mnemonico, value);
	}

	@Override
	public void insertSubComponent(Component comp) {
		subComponentMap.put(comp.getInstanceId(), comp);
	}

	@Override
	public void removeSubComponent(Component comp) {
		subComponentMap.remove(comp.getInstanceId());
	}

	@Override
	public Component getSubComponent(String aSubComponentMetadataId) {
		Component subComponent = null;
		
		for(Component component : subComponentMap.values()) {
			if(component.getMetadataId().equals(aSubComponentMetadataId)) {
				subComponent = component;
				break;
			}
		}
		return subComponent;
	}
	
	@Override
	public List<Component> getSubComponentList() {
		return new ArrayList<>(subComponentMap.values());
	}

	@Override
	public long getFatherInstanceId() {
		return mFatherInstanceId;
	}
	
	@Override
	public void setFatherInstanceId(long aFatherInstanceId) {
		this.mFatherInstanceId = aFatherInstanceId;
	}

	@Override
	public Component getFatherComponent(ComponentsTree aTree) {
		return aTree.getComponentReference(mFatherInstanceId);
	}
	
	@Override
	public String getMetadataId() {
		return metadataId;
	}

	public void setMetadataId(String metadataId) {
		this.metadataId = metadataId;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append(getMetadataId());

		for(AttributeData attData : dataTable.getAttributeList()){
			str.append(LINE_BREAK);
			str.append(attData);
		}

		str.append(LINE_BREAK);
		
		for(Component subComponent : getSubComponentList()){
			str.append(LINE_BREAK);
			str.append(subComponent);
		}
		
		return str.toString();
	}
}
