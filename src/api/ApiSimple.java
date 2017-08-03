package api;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiSimple {
	
	String id;
	String secret;
	String text;
	
	public void setValue(String id, String secret, String text) {
		this.id = id;
		this.secret = secret;
		this.text = text;
	}
	
	public String process(){
		
		double score = 10.0;
		return createJSON(score);
	}
	
	private String createJSON(double score){
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", "Emotion processing rest api");
			obj.put("version", "1.0");
			JSONObject result = new JSONObject();
			result.put("text", text);
			result.put("emotion_score", score);
			obj.put("result", result);
			obj.put("description", "github.com/lunab 나영채의 고등학교 2학년 1학기 프로젝트");
		}catch(JSONException e){
			e.printStackTrace();
		}
		return obj.toString();
	}
}
