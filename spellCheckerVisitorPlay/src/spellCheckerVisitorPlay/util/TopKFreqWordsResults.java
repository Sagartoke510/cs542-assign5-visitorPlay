package spellCheckerVisitorPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sagar Toke
 * 
 *         This {@code TopKFreqWordsResults} class implements {@code Results}
 *         interface which store results and write file logic is performed by
 *         the driver class
 *
 */
public class TopKFreqWordsResults implements Results {
	private String topKOutputFilename;
	private static List<String> result;
	private File outputFile;
	private FileWriter outputFileWriter;

	public TopKFreqWordsResults(String topKOutputFilenameIn) {
		topKOutputFilename = topKOutputFilenameIn;
		result = new ArrayList<String>();
		try {
			outputFile = new File(topKOutputFilename);
			outputFileWriter = new FileWriter(topKOutputFilename, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFile() {
		try {

			if (!Files.exists(Paths.get(topKOutputFilename))) {

				outputFile.createNewFile();

				outputFileWriter.write(result + "\n");

			} else {
				for (String res : result) {
					outputFileWriter.write(res.toString() + "\n");
					outputFileWriter.flush();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			outputFileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setResult(String topK) {
		result.add(topK);
	}

}
