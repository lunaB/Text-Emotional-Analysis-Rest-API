package api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class ApiUtil {
	
	// 한번만 초기화 되는 id (계정 생성할때) unique sha1 에 - 붙임
	public String createClientId(String id){
		MessageDigest digest;
		StringBuffer buf = new StringBuffer();
		StringBuffer hexString = new StringBuffer();
        
		try {
			digest = MessageDigest.getInstance("SHA-1");
	        digest.update(id.getBytes());
	        byte messageDigest[] = digest.digest();
	
	        for(int i = 0; i < messageDigest.length; i++){
	        	if(i!=0 && i%5==0){
	        		hexString.append("-");
	        	}
	        	hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}
	
	// 재발급 가능 key
	public String createClientSecret(){
		Random rand  = new Random();
		StringBuffer buf = new StringBuffer();
		
		for(int i=0;i<25;i++){
			if(i!=0&&i%5==0){
				buf.append("-");
			}
			if(rand.nextBoolean()){
				buf.append((char)((int)(rand.nextInt(26))+97));
			}else{
				buf.append(rand.nextInt(10));
			}
		}
		return buf.toString();
	}
}
