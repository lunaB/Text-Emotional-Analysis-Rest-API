package api;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiSimple {
	
	public String createJsonData(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", "Emotion processing rest api");
			obj.put("version", "1.0");
			JSONObject result = new JSONObject();
			result.put("text", "이 영화 더럽게 재미없다.");
			obj.put("result", result);
			obj.put("description", "github.com/lunab 나영채의 고등학교 2학년 1학기 프로젝트");
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return obj.toString();
	}
}
