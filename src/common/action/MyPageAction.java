package common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.CommandAction;
import common.model.UsageVO;
import common.model.UserDAO;

public class MyPageAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		if(request.getMethod().equals("GET")){
			String id = (String) request.getSession().getAttribute("signIn");
			if(id == null){
				return null;
			}else{
				UserDAO userDAO = UserDAO.getInstance();
				UsageVO useVO = userDAO.usageSelect(id);
				request.setAttribute("total", useVO.getTotal());
				double per = useVO.getUsage()/useVO.getTotal()*100;
				request.setAttribute("per", per);
				return "userPage.jsp";
			}
		}
		return null;
	}
	
}
