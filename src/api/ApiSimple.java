package api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import common.model.CrawlerDAO;
import common.model.WordDAO;
import crawler.util.NLP;
import crawler.util.TwitterNLP;

public class ApiSimple {
	
	String id = null;
	String secret = null;
	String text = null;
	
	public void setValue(String id, String secret, String text) {
		this.id = id;
		this.secret = secret;
		this.text = text;
	}
	
	public String process(){
		NLP nlp = new TwitterNLP();
		
		List<String> textList = nlp.process(text);
		
		WordDAO wordDao = WordDAO.getInstance();
		double score = wordDao.selectText(textList);
		return createJSON(score);
	}
	
	public String errorJson(int errorCode){
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("name", "Emotion processing rest api");
		obj.put("version", "1.0");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errorCode", errorCode);
		obj.put("result", result);
		obj.put("description", "github.com/lunab 나영채의 고등학교 2학년 1학기 프로젝트");
	
		JSONObject json = new JSONObject(obj);
		
		return json.toString();
	}
	
	private String createJSON(double score){
		
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("name", "Emotion processing rest api");
		obj.put("version", "1.0");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("text", text);
		result.put("emotion_score", score);
		
		obj.put("result", result);
		obj.put("description", "github.com/lunab 나영채의 고등학교 2학년 1학기 프로젝트");
	
		JSONObject json = new JSONObject(obj);
		return json.toString();
		
	}
}
