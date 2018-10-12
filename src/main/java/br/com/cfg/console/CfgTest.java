package br.com.cfg.console;

import java.io.IOException;
import java.util.Map;

import br.com.cfg.infra.CsvFileReader;
import br.com.cfg.model.ComponentsTree;
import br.com.cfg.model.Condominium;

public class CfgTest {

	public static void main(String[] args) throws IOException {
		
		ComponentsTree tree = new ComponentsTree();

		Condominium condominium = new Condominium();

		CsvFileReader csvReader = new CsvFileReader();
		
		Map<String,String> condData = csvReader.readCSV("condominium.csv");
		
		System.out.println(condData);
		
	}
}
