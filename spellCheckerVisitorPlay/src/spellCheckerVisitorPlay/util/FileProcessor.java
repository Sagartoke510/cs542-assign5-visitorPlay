package spellCheckerVisitorPlay.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class {@code FileProcessor} processes the input and read contents line by
 * line.
 * 
 * @author Sagar Toke
 *
 */

public class FileProcessor {

	private BufferedReader reader;
	private BufferedReader iReader;
	private String line;
	private Map<String, List<String>> itemsList = null;

	public String getLine() {
		return line;
	}

	public FileProcessor(String inputFilePath)
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("invalid input file or input file in incorrect location");
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
	}

	/**
	 * Method to read input file line by line
	 * 
	 * @return String line read from the input file
	 * @throws IOException throws exception if null
	 */
	public String poll() throws IOException {
		if (null == line)
			return null;

		String newValue = line.trim();
		line = reader.readLine();
		// close();
		return newValue;
	}



	/**
	 * Method to close all the resources open to read the file
	 * 
	 * @throws IOException throws exception if null
	 */
	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException("failed to close file", e);
		}
	}
}
