package spellCheckerVisitorPlay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Sagar Toke
 * 
 *         This {@code SpellCheckResults} class implements {@code Results}
 *         interface which store results and write file logic is performed by
 *         the driver class
 *
 */
public class SpellCheckResults implements Results {
	private String spellCheckOutputFilename;
	private File outputFile;
	private FileWriter outputFileWriter;
	private static String result = "";

	public SpellCheckResults(String spellCheckOutputFilenameIn) {
		spellCheckOutputFilename = spellCheckOutputFilenameIn;
		try {
			outputFile = new File(spellCheckOutputFilename);
			outputFileWriter = new FileWriter(spellCheckOutputFilename, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeToFile() {
		try {

			if (!Files.exists(Paths.get(spellCheckOutputFilename))) {

				outputFile.createNewFile();

				outputFileWriter.write(result + "\n");

			} else {

				outputFileWriter.write(result.toString());
				outputFileWriter.flush();

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
	public void setResult(String resultIn) {
		result = result + resultIn + "\n";
	}
}
