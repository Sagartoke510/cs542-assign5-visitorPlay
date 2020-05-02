package spellCheckerVisitorPlay.visitor;

/**
 * {@code Element} defines an interface to be implemented by classes that intend
 * to store the sentence and accept the visitor and delegate it to respective
 * visitors.
 */
public interface Element {

	/**
	 * method to accept the visitor.
	 * @param visitor each visitor
	 */
	public void accept(Visitor visitor);

}
