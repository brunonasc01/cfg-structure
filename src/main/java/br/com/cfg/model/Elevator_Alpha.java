package br.com.cfg.model;

import java.util.Map;

public class Elevator_Alpha extends Elevator {

	public Elevator_Alpha(){
		super("Elevator_Alpha");
	}
	
	public Elevator_Alpha(Map<String, String> dataMap){
		super("Elevator_Alpha", dataMap);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

