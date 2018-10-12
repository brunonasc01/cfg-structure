package br.com.cfg.console;

import java.io.IOException;
import java.util.Map;

import br.com.cfg.infra.CsvFileReader;
import br.com.cfg.model.Building;
import br.com.cfg.model.ComponentsTree;
import br.com.cfg.model.Condominium;
import br.com.cfg.model.CondominiumAlternative;
import br.com.cfg.model.Elevator;
import br.com.cfg.model.ElevatorGroup;
import br.com.cfg.model.ElevatorGroup_Alpha;
import br.com.cfg.model.Elevator_Alpha;
import br.com.cfg.rule.ElevatorAlphaRulesManager;

public class CfgTest {

	public static void main(String[] args) throws IOException {
		
		CsvFileReader csvReader = new CsvFileReader();
		
		ComponentsTree tree = new ComponentsTree();

		Map<String,String> condData = csvReader.readCSV("condominium.csv");
		Condominium condominium = new Condominium(condData);
		tree.insertComponentReference(condominium);
		
		Map<String,String> alternativeData = csvReader.readCSV("alternative.csv");
		CondominiumAlternative alternative = new CondominiumAlternative(alternativeData);
		condominium.insertSubComponent(alternative);
		tree.insertComponentReference(alternative);
		
		Map<String,String> buildingData = csvReader.readCSV("building.csv");
		Building building = new Building(buildingData);
		alternative.insertSubComponent(building);
		tree.insertComponentReference(building);
		
		Map<String,String> elevatorGroupData = csvReader.readCSV("elevatorGroup.csv");
		ElevatorGroup elevatorGroup = new ElevatorGroup_Alpha(elevatorGroupData);
		building.insertSubComponent(elevatorGroup);
		tree.insertComponentReference(elevatorGroup);
		
		Map<String,String> elevatorData = csvReader.readCSV("elevator.csv");
		Elevator elevator = new Elevator_Alpha(elevatorData);
		elevatorGroup.insertSubComponent(elevator);
		tree.insertComponentReference(elevator);
		
		System.out.println(condominium);
		
		ElevatorAlphaRulesManager elevatorRules = new ElevatorAlphaRulesManager();
		elevatorRules.applyRules(elevator, tree);
	}
}
