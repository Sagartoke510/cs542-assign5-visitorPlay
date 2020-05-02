package spellCheckerVisitorPlay.visitor;

import java.io.IOException;

/**
* Visitor defines an interface .
*/
public interface Visitor {

	/**
	 * Method which performs operation required by the visitor
	 * @param myElement element
	 * @throws IOException exception
	 */
	public void visit(MyElement myElement) throws IOException;
}
