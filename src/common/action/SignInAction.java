package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;

public class SignInAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			return "signIn.jsp";
		}else if(request.getMethod().equals("POST")){
			System.out.println("p");
		}
		return null;
	}
	
}
