package spellCheckerVisitorPlay.driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import spellCheckerVisitorPlay.util.FileProcessor;
import spellCheckerVisitorPlay.util.Results;
import spellCheckerVisitorPlay.util.SpellCheckResults;
import spellCheckerVisitorPlay.util.TopKFreqWordsResults;
import spellCheckerVisitorPlay.validator.ValidatorFetcher;
import spellCheckerVisitorPlay.validator.ValidatorUtil;
import spellCheckerVisitorPlay.visitor.Element;
import spellCheckerVisitorPlay.visitor.MyArrayList;
import spellCheckerVisitorPlay.visitor.SpellCheckAnalyzer;
import spellCheckerVisitorPlay.visitor.TopKMostFreqAnalyzer;
import spellCheckerVisitorPlay.visitor.Visitor;

/**
 * @author Sagar Toke
 * 
 */
public class SpellCheckerVisitorDriver {

	private static void runAnalysis(FileProcessor fileProcessor, Visitor... visitors) throws IOException {
		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (Visitor visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(Results... analysisResults) {
		for (Results results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		// TODO command-line args validation.
		// TODO command-line parsing and initialization of following variables.
		// 1. inputFilename.
		// 2. acceptableWordsFilename.
		// 3. k.
		// 4. topKOutputFilename.
		// 5. spellCheckOutputFilename.
		System.out.println("I am in Driver");
		final int REQUIRED_NUMBER_OF_ARGS = 5;

		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${input}"))
				|| (args[1].equals("${acceptableWordsFile}")) || (args[2].equals("${k}"))
				|| (args[3].equals("${topKOutputFile}")) || (args[4].equals("${spellCheckOutputFile}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.\n",
					REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}

		File file = new File(args[0]);
		String inputFilename = file.getAbsolutePath();
		file = new File(args[1]);
		String acceptableWordsFilename = file.getAbsolutePath();
		String k = args[2];
		file = new File(args[3]);
		String topKOutputFilename = file.getAbsolutePath();
		file = new File(args[4]);
		String spellCheckOutputFilename = file.getAbsolutePath();

		try {
			ValidatorUtil.validate("failed", ValidatorFetcher.missingFileValidator(inputFilename),
					ValidatorFetcher.missingFileValidator(acceptableWordsFilename),
					ValidatorFetcher.emptyFileValidator(inputFilename),
					ValidatorFetcher.emptyFileValidator(acceptableWordsFilename),
					ValidatorFetcher.fileContentValidator(inputFilename), ValidatorFetcher.kValueValidator(k));

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FileProcessor fileProcessor = new FileProcessor(inputFilename);

			Results topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
			Visitor topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

			Results spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
			Visitor spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);

			runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

			persistResults(topKFreqWordsResults, spellCheckResults);
		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
