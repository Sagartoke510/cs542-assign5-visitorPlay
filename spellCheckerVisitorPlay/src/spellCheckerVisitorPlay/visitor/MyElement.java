package spellCheckerVisitorPlay.visitor;

import java.io.IOException;

public class MyElement implements Element {
	private String sentence;

	@Override
	public void accept(Visitor visitor) {
		try {
			visitor.visit(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * method to store sentence
	 * @param sentenceIn the sentence from the line.
	 */
	public void storeSentence(String sentenceIn) {

		sentence = sentenceIn;
	}
	
	/**
	 * Method to get each sentence
	 * @return String sentence of the line
	 */
	public String getSentence() {
		return sentence;
	}

}
