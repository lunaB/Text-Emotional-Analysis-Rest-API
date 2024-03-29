package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;

public class SignOutAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			request.getSession().invalidate();
			response.sendRedirect("/");
		}
		return null;
	}

}
