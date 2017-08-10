package crawler.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.twitter.penguin.korean.KoreanTokenJava;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;

import scala.collection.Seq;

public class TwitterNLP implements NLP {

	private boolean filter(KoreanTokenJava text){
		switch (text.getPos()) {
		case Adjective:		//형용사	(감성어)
		case Verb:			//동사		(감성어)
	    	return true;
		default:
			return false;
		}
	}
	
	// comprehensive
	private boolean filterPlus(KoreanTokenJava text){
		switch (text.getPos()) {
		case Adjective:		//형용사	(감성어)
		case Verb:			//동사		(감성어)
		case KoreanParticle://요소		예) ㅋㅋㅋ
		case Noun:			//명사		
	    	return true;
		default:
			return false;
		}
	}

	@Override
	public List<String> process(String text) {
		// 정규화 Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        
        // 어근화 stemming
        List<KoreanTokenJava> phrases = TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens);
        Iterator<KoreanTokenJava> it = phrases.iterator();
        
        List<String> outputList = new ArrayList<String>();
        while(it.hasNext()){
        	KoreanTokenJava kp = it.next();
        	if(filter(kp)){
        		outputList.add(kp.getText());
        	}
        }
        return outputList;
	}
}
