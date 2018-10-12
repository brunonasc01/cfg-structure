package br.com.cfg.model;

import java.util.List;

public class AttributeData {
	private String value;
	
	private String mnemonico;
	
	private boolean enable = true;
	
	private boolean visible = true;
	
	private List<String> domain;

	public AttributeData(String mnemonico, String value) {
		this.mnemonico = mnemonico;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMnemonico() {
		return mnemonico;
	}

	public void setMnemonico(String mnemonico) {
		this.mnemonico = mnemonico;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<String> getDomain() {
		return domain;
	}

	public void setDomain(List<String> domain) {
		this.domain = domain;
	}
	
	@Override
	public String toString() {
		return "Mnemonico: "+getMnemonico()+", Value: "+getValue()+", Enable: "+isEnable()+", Visible: "+isVisible();
	}
}
