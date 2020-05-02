package spellCheckerVisitorPlay.visitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import spellCheckerVisitorPlay.util.Results;

public class SpellCheckAnalyzer implements Visitor {

	private String acceptableWordsFilename;
	private Results spellCheckResults;
	private static Boolean fileRead = false;
	private static List<String> acceptableWords = new ArrayList<String>();

	public SpellCheckAnalyzer(String acceptableWordsFilenameIn, Results spellCheckResultsIn) {
		acceptableWordsFilename = acceptableWordsFilenameIn;
		spellCheckResults = spellCheckResultsIn;
	}

	@Override
	public void visit(MyElement myElement) throws IOException {
		String[] wordList = myElement.getSentence().split("\\s");
		if (!fileRead) {
			readAccetableFile();
		}

		for (String word : wordList) {
			if (!acceptableWords.contains(word)) {

				char[] words = word.toLowerCase().toCharArray();
				List<String> possibleAcceptableWords = new ArrayList<String>();
				Integer noMatch = 0;
				int match = 0;
				int flag = 0;
				for (String wordAccept : acceptableWords) {
					char[] acceptableWordsChar = wordAccept.toLowerCase().toCharArray();
					Character[] matchWord = new Character[wordAccept.length()];
					if (acceptableWordsChar.length != words.length) {
						noMatch++;
					} else {
						for (int i = 0; i < acceptableWordsChar.length; i++) {
							if (acceptableWordsChar[i] == words[i]) {
								matchWord[i] = words[i];
								match++;
							}
							flag = matchWord.length;

						}
						for (int j = 0; j < matchWord.length; j++) {
							if (matchWord[j] == null) {
								flag--;
							}
						}

						if (flag == acceptableWordsChar.length - 1) {
							possibleAcceptableWords.add(wordAccept);
						}

					}

				}

				if (!possibleAcceptableWords.isEmpty())
					spellCheckResults.setResult(word + "::" + possibleAcceptableWords);

			}

		}

	}

	protected void readAccetableFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(acceptableWordsFilename)));
		String line = "";
		while ((line = reader.readLine()) != null) {
			acceptableWords.add(line);
		}
		fileRead = true;
		reader.close();
	}

}
