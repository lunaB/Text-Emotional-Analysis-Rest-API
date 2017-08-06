package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;

public class MyPageAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			request.setAttribute("remain", 100);
			request.setAttribute("per", 20);
			return "userPage.jsp";
		}
		return null;
	}
	
}
