package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;
import common.model.UserDAO;

public class SignInAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getSession().getAttribute("signIn") != null){
			return null;
		}if(request.getMethod().equals("GET")){
			return "signIn.jsp";
		}else if(request.getMethod().equals("POST")){
			UserDAO dao = UserDAO.getInstance();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			if(dao.select(id, pw)){
				request.getSession().setAttribute("signIn", id);
				response.sendRedirect("/");
			}else {
				request.setAttribute("signInFail", true);
				return "signIn.jsp";
			}
		}
		return null;
	}
	
}
