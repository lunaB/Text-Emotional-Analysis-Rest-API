package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.ApiSimple;
import common.controller.CommandAction;

public class ApiAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ApiSimple api = new ApiSimple();
		
		if(request.getMethod().equals("POST")){
			String text = request.getParameter("text");
			api.setValue(request.getHeader("client-id"), request.getHeader("client-secret"), text);
			request.setAttribute("data", api.process());
			return "api/data.jsp";
		}else{
			request.setAttribute("data", api.errorJson(1));
			return "api/data.jsp";
		}
	}
}
