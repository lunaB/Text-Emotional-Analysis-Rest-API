package common.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.ApiSimple;
import common.controller.CommandAction;

public class ApiAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ApiSimple ju = new ApiSimple();
		
		if(request.getMethod().equals("GET")){
			ju.setValue(request.getHeader("client-id"), request.getHeader("client-secret"), "text");
			request.setAttribute("data", ju.process());
			return "api/data.jsp";
		}else if(request.getMethod().equals("POST")){
			
			ju.setValue(request.getHeader("client-id"), request.getHeader("client-secret"), "text");
			request.setAttribute("data", ju.process());
			return "api/data.jsp";
		}
		return "error/404.jsp";
	}
}
