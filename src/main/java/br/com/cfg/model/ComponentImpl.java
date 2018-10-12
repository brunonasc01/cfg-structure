package br.com.cfg.model;

import java.util.Map;

public class ComponentImpl implements Component {

	private long mInstanceId;
	private String mCompleteMetadataId;
	private long mFatherInstanceId;
	private DataTable dataTable;
	private Map<Long,Component> subComponentMap;
	
	public ComponentImpl() {
		dataTable = new DataTable();
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
	public String getAttributeValue(String mnemonico) {
		return dataTable.getAttributeValue(mnemonico);
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
		return mCompleteMetadataId;
	}

}
