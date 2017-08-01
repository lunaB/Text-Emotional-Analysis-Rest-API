package common.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.ApiSimple;
import common.controller.CommandAction;

public class ApiAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println(request.getMethod());
		
		if(request.getMethod().equals("GET")){
			ApiSimple ju = new ApiSimple();
			request.setAttribute("data", ju.createJsonData());
			return "api/data.jsp";
		}else if(request.getMethod().equals("POST")){
			
			Enumeration<String> headers = request.getHeaderNames();
			
			// db select id & secret
			System.out.println(request.getHeader("client-id"));
			System.out.println(request.getHeader("client-secret"));
			
//			while(headers.hasMoreElements()){
//				String headerName = headers.nextElement();
//				String value = request.getHeader(headerName);
//				System.out.println(headerName+" : "+ value);
//			}
			return "json/data.jsp";
		}
		return "error/no.jsp";
	}
}
