package br.com.cfg.rule;

import br.com.cfg.model.AttributeData;
import br.com.cfg.model.Component;
import br.com.cfg.model.ComponentsTree;

public class ElevatorAlphaRulesManager {
	
	public void applyRules(Component component, ComponentsTree tree){
		
		System.out.println("Running Rules: "+component.getMetadataId());
		
		applyCODEQUIPRule(component, tree);
		
		applyZKERule(component, tree);
	}
	
	private void applyCODEQUIPRule(Component component, ComponentsTree tree){
		AttributeData attData = component.getAttributeData("CODEQUIP");
		
		System.out.println(attData);
	}
	
	private void applyZKERule(Component component, ComponentsTree tree){
		AttributeData attData = component.getAttributeData("ZKE");
		
		Component elevatorGroup = component.getFatherComponent(tree);
		String zag = elevatorGroup.getAttributeValue("ZAG");
		
		if(zag.equals("1")){
			attData.setValue("1");
			attData.setEnable(false);
		}
		
		System.out.println(attData);
	}
	
}
