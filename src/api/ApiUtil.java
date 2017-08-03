package api;

public class ApiUtil {
	
	// 한번만 초기화 되는 id (계정 생성할때)
	public String createClientId(){
		
		return "1234";
	}
	
	// 재발급 가능 key
	public String createClientSecret(){
		
		return "5678";
	}
}
