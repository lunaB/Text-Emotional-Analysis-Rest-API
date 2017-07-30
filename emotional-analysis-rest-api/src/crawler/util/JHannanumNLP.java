package crawler.util;

import java.util.List;

import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PlainTextProcessor.InformalSentenceFilter.InformalSentenceFilter;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PlainTextProcessor.SentenceSegmentor.SentenceSegmentor;

public class JHannanumNLP implements NLP {

	private Workflow workflow;
	
	public JHannanumNLP() {
		workflow = new Workflow();
	}
	
	@Override
	public List<String> getWordList(String text) {
		// 준비중
		return null;
	}
	
}
