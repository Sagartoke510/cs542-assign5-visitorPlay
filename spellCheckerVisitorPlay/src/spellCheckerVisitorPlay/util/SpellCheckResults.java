package spellCheckerVisitorPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SpellCheckResults implements Results {
	private String spellCheckOutputFilename;
	private File outputFile;
	private FileWriter outputFileWriter;
	private static List<List<String>> result;

	public SpellCheckResults(String spellCheckOutputFilenameIn) {
		spellCheckOutputFilename=spellCheckOutputFilenameIn;
		try {
			outputFile = new File(spellCheckOutputFilename);
			outputFileWriter = new FileWriter(spellCheckOutputFilename,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void writeToFile() {
		try {

			if (!Files.exists(Paths.get(spellCheckOutputFilename))) {
				
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
