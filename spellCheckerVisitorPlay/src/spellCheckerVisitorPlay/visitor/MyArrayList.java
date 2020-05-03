package spellCheckerVisitorPlay.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import spellCheckerVisitorPlay.util.FileProcessor;
/**
 * 
 * @author Sagar Toke
 * 
 *         This {@code MyArrayList} class implements {@code Element}
 *         interface which stores the sentences into the MyElement
 *
 */
public class MyArrayList implements Element {
	private ArrayList<Element> internalArraylist = new ArrayList<Element>();
	static FileProcessor fp;
	static int statementCount = 0;
	
	

	private MyArrayList() {
		super();
	}

	public static class Builder {
		private MyArrayList ma = new MyArrayList();

		public Builder withFileProcessor(FileProcessor fileProcessorIn) {
			fp = fileProcessorIn;
			return this;
		}

		public Element build() throws IOException {

			while (fp.getLine() != null) {
				

				String lineFromFile = fp.poll();
				String lineWithoutDots = lineFromFile.replaceAll("\\.", "");
				int sentenceCount = lineFromFile.length() - lineWithoutDots.length();
				for (String sentence : lineFromFile.trim().split("\\.")) {
					Element myElement = new MyElement();
					

					statementCount++;

					((MyElement) myElement).storeSentence(sentence.trim());
					
					ma.internalArraylist.add(myElement);
				}

			}
			return ma;

		}
	}

	@Override
	public void accept(Visitor visitor) {
		Iterator<Element> itr = getIterator();
		while (itr.hasNext()) {
			((Element) itr.next()).accept(visitor);
		}

	}

	/**
	 * method to iterator over internal arraylist
	 * @return element iterator
	 */
	public Iterator<Element> getIterator() {
		return internalArraylist.iterator();
	}

	
}
