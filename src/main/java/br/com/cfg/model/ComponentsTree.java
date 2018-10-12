package br.com.cfg.model;

import java.util.HashMap;
import java.util.Map;

public class ComponentsTree {
	
	private Map<Long,Component> componentReferenceMap;
	
	public ComponentsTree() {
		componentReferenceMap = new HashMap<>();
	}
	
	public void insertComponentReference( Component aComponent )
    {
		componentReferenceMap.put(aComponent.getInstanceId(), aComponent);
    }
	
	public Component getComponentReference(long aInstanceId) {
		return componentReferenceMap.get(aInstanceId);
	}
	
}

