package crawler.util;

import java.util.Iterator;
import java.util.List;

import com.twitter.penguin.korean.KoreanPosJava;
import com.twitter.penguin.korean.KoreanTokenJava;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;

import scala.collection.Seq;

public class TwitterNLP implements NLP {

	@Override
	public List<String> getWordList(String text) {
		// 정규화 Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        
        // 어근화 stemming
        List<KoreanTokenJava> phrases = TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens);
        Iterator<KoreanTokenJava> it = phrases.iterator();
        
        while(it.hasNext()){
        	KoreanTokenJava kp = it.next();
        	if( kp.getPos().compareTo(KoreanPosJava.Adjective)==0 ||	//형용사
        		kp.getPos().compareTo(KoreanPosJava.Adverb)==0 ||		//부사
        		kp.getPos().compareTo(KoreanPosJava.Noun)==0 ||			//명사
        		kp.getPos().compareTo(KoreanPosJava.Verb)==0       		//동사 		
        		){
        		System.out.println(kp.getText());
            	System.out.println(kp.getPos());
        	}
//        	System.out.println(kp.getText());
//        	System.out.println(kp.getPos());
        }
		return null;
	}
	
}
