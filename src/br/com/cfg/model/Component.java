package br.com.cfg.model;

public interface Component {

	public long getInstanceId();

	public void setInstanceId(long instId);

	public String getAttributeValue(String mnemonico);
	
	public void setAttributeValue(String mnemonico, String value);

	public void insertSubComponent(Component comp);
	
	public void removeSubComponent(Component comp);

	public Component getSubComponent(String aSubComponentObjectTypeName);

	public void setFatherInstanceId(long aFatherInstanceId);
	
	public long getFatherInstanceId();

	public Component getFatherComponent(ComponentsTree aTree);

	public String getMetadataId();
}
