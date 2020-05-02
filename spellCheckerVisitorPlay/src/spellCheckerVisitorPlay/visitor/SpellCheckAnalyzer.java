package spellCheckerVisitorPlay.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import spellCheckerVisitorPlay.util.FileProcessor;
import spellCheckerVisitorPlay.util.Results;

public class SpellCheckAnalyzer implements Visitor {

	private String acceptableWordsFilename;
	private Results spellCheckResults;
	FileProcessor fp;

	public SpellCheckAnalyzer(String acceptableWordsFilenameIn, Results spellCheckResultsIn) throws IOException {
		acceptableWordsFilename = acceptableWordsFilenameIn;
		spellCheckResults = spellCheckResultsIn;
		List<String> acceptableWords = new ArrayList<String>();
		while (fp.getLine() != null) {
			String lineFromFile = fp.poll();
			acceptableWords.add(lineFromFile);

		}
	}

	@Override
	public void visit(MyElement myElement) {
		String[] wordList = myElement.getSentence().split("\\s");
		

	}

}
