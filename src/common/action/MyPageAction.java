package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;
import common.model.UsageVO;
import common.model.UserDAO;
import common.model.UserVO;

public class MyPageAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			String id = (String) request.getSession().getAttribute("signIn");
			if(id == null){
				return null;
			}else{
				UserDAO userDAO = UserDAO.getInstance();
				UserVO userVO = userDAO.userSelect(id);
				UsageVO usageVO = userDAO.usageSelect(id);
				
				request.setAttribute("total", usageVO.getTotal());
				request.setAttribute("usage", usageVO.getUsage());
				request.setAttribute("clientId", userVO.getClient_id());
				request.setAttribute("clientSecret", userVO.getClient_secret());
				
				return "userPage.jsp";
			}
		}
		return null;
	}
}
