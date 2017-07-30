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
		workflow.appendPlainTextProcessor(new SentenceSegmentor(), null); 		// 문장필터
		workflow.appendPlainTextProcessor(new InformalSentenceFilter(), null);  // 비형식 문장 필터
		return null;
	}
	
}
