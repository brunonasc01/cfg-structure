package br.com.cfg.model;

import java.util.HashMap;
import java.util.Map;

public class ComponentsTree {
	
	private Map<Long,Component> componentReferenceMap;
	
	private Component root;
	
	public ComponentsTree() {
		componentReferenceMap = new HashMap<>();
	}
	
	public void insertComponentReference( Component aComponent )
    {
		if(aComponent.getMetadataId().equals("Condominium")) {
			root = aComponent;
		}
		
		componentReferenceMap.put(aComponent.getInstanceId(), aComponent);
    }
	
	public Component getComponentReference(long aInstanceId) {
		return componentReferenceMap.get(aInstanceId);
	}
	
	public Component getRoot() {
		return root;
	}
	
}

