package spellCheckerVisitorPlay.visitor;

public class MyElement implements Element {
	private String sentence;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public void storeSentence(String sentenceIn) {

		sentence = sentenceIn;
	}
	
	public String getSentence() {
		return sentence;
	}

}
