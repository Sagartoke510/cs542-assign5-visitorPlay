package spellCheckerVisitorPlay.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import spellCheckerVisitorPlay.util.FileProcessor;
import spellCheckerVisitorPlay.util.Results;

public class TopKMostFreqAnalyzer implements Visitor {
	private int k;
	private Results topKFreqWordsResults;

	public TopKMostFreqAnalyzer(String kIn, Results topKFreqWordsResultsIn) {
		k = Integer.parseInt(kIn);
		topKFreqWordsResults = topKFreqWordsResultsIn;
	}

	@Override
	public void visit(MyElement element) {
		int i = 1;
		String[] wordList = element.getSentence().split("\\s");
		Map<String, Integer> mostFrequentWord = new HashMap<String, Integer>();
		List<String> topK = new ArrayList<String>();
		Queue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int o1String = mostFrequentWord.get(o1);
				int o2String = mostFrequentWord.get(o2);
				if (o1String == o2String)
					return 0;
				if (o1String < o2String)
					return 1;
				return -1;

			}

		});

		for (String words : wordList) {
			if (mostFrequentWord.containsKey(words))
				mostFrequentWord.replace(words.toLowerCase(), mostFrequentWord.get(words) + 1);

			else
				mostFrequentWord.put(words.toLowerCase(), i);

		}

		pq.addAll(mostFrequentWord.keySet());

		while (!pq.isEmpty()) {

			if (topK.size() != k)
				topK.add(pq.poll());
			else
				pq.poll();

		}

		System.out.println(topK);
		
		topKFreqWordsResults.setResult(topK);
		
		
		

	}

}
