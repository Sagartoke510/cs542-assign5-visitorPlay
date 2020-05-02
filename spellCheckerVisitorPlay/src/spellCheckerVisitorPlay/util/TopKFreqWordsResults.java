package spellCheckerVisitorPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TopKFreqWordsResults implements Results {
	private String topKOutputFilename;
	private static List<List<String>> result;
	private File outputFile;
	private FileWriter outputFileWriter;
	public TopKFreqWordsResults(String topKOutputFilenameIn) {
		topKOutputFilename = topKOutputFilenameIn;
		result = new ArrayList<List<String>>();
		try {
			outputFile = new File(topKOutputFilename);
			outputFileWriter = new FileWriter(topKOutputFilename,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFile() {
		try {

			if (!Files.exists(Paths.get(topKOutputFilename))) {
				
				outputFile.createNewFile();

				
				outputFileWriter.write(result + "\n");
				//outputFileWriter.flush();
		
			} else {
				//outputFileWriter = new FileWriter(itemOutputFile,true);
					for(List<String> res: result) {
					outputFileWriter.write(res.toString() + "\n");
					outputFileWriter.flush();
					}
					
			}
			
			//close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			//outputFileWriter.flush();
			outputFileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setResult(List<String> topK) {
		result.add(topK);

		
	}

	

}
