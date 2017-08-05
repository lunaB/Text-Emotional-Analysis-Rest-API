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
		
		if(request.getMethod().equals("POST")){
			String text = request.getParameter("text");
			ju.setValue(request.getHeader("client-id"), request.getHeader("client-secret"), text);
			request.setAttribute("data", ju.process());
			return "api/data.jsp";
		}else{
			request.setAttribute("data", ju.errorJson(1));
			return "api/data.jsp";
		}
	}
}
