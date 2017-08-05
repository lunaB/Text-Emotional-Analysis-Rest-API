package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.ApiUtil;
import common.controller.CommandAction;
import common.model.UserDAO;

public class SignUpAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			return "signUp.jsp";
		}else if(request.getMethod().equals("POST")){
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			ApiUtil apiUtil = new ApiUtil();
			String clientId = apiUtil.createClientId(id);
			String clientSecret = apiUtil.createClientSecret();
			int defaultRating = 1;
			
			UserDAO userDAO = new UserDAO();
			boolean insertOK = userDAO.insert(id, pw, clientId, clientSecret, defaultRating);
			
			if(insertOK){
				return "index.jsp";
			}else{
				request.setAttribute("signUpFail", true);
				return "signUp.jsp";
			}
		}
		return null;
	}
	
}
