package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;

public class NoneAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String uri = request.getRequestURI();
		return uri.substring(1, uri.lastIndexOf('.'))+".jsp";
	}
}
