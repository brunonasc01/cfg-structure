package br.com.cfg.infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CsvFileReader {
	
	private static final String VALUE_SEPARATOR = ";";
	
	/**
	 * Le um arquivo CSV com 02 colunas e coloca os valores num mapa do tipo <String,String>
	 * @param filePath o caminho completo ate o arquivo
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> readCSV(String resourceFileName) {
		Map<String,String> result = new HashMap<String, String>();
		
		try {
			File file = getResourceFile(resourceFileName);

			FileReader fileData = new FileReader(file);
			BufferedReader bf = new BufferedReader(fileData);
			String currentLine;

			while((currentLine = bf.readLine()) != null){
				String[] line = currentLine.split(VALUE_SEPARATOR);

				if(line != null && line.length == 2){
					result.put(line[0], line[1]);
				}
			}
			
			bf.close();

		} catch ( Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private File getResourceFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		return file;
	}
}
