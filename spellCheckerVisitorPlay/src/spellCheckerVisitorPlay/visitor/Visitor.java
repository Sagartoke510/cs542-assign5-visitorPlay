package spellCheckerVisitorPlay.visitor;

import java.io.IOException;

public interface Visitor {

	public void visit(MyElement myElement) throws IOException;
}
