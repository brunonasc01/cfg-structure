package br.com.cfg.model;

import java.util.List;

public interface Component {

	public long getInstanceId();

	public void setInstanceId(long instId);

	public AttributeData getAttributeData(String mnemonico);
	
	public String getAttributeValue(String mnemonico);
	
	public void setAttributeValue(String mnemonico, String value);

	public void insertSubComponent(Component comp);
	
	public void removeSubComponent(Component comp);

	public Component getSubComponent(String aSubComponentObjectTypeName);
	
	public List<Component> getSubComponentList();

	public void setFatherInstanceId(long aFatherInstanceId);
	
	public long getFatherInstanceId();

	public Component getFatherComponent(ComponentsTree aTree);

	public String getMetadataId();
}
