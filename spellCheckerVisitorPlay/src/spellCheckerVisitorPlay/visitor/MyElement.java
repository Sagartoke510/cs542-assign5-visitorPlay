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

	public void storeSentence(String sentenceIn) {

		sentence = sentenceIn;
	}
	
	public String getSentence() {
		return sentence;
	}

}
