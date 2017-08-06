package common.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.action.NotFoundAction;

public class ControllerAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
	private String viewPath = "/WEB-INF/views/";
	
	public void init(ServletConfig config) throws ServletException{
		loadProperties("common/properties/command");
	}
	
	private void loadProperties(String path){
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while (actionEnumHome.hasMoreElements()){
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				continue;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String view = null;
        CommandAction com = null;
        try {
        	String command = request.getRequestURI();
        	
            if (command.indexOf(request.getContextPath()) == 0) {
                command = command.substring(request.getContextPath().length());
            }
        	
            com = (CommandAction) commandMap.get(command);
            System.out.println(command);
            if (com == null) { //404
            	com = new NotFoundAction();
            }
            view = com.requestPro(request, response);	
            if(view == null){
            	view = "error/error.jsp";
            }
        } catch (Throwable e) {
        	throw new ServletException(e); 
        }
        
        // https://stackoverflow.com/questions/2123514/java-lang-illegalstateexception-cannot-forward-sendredirect-create-session
        if(!response.isCommitted()){
        	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath+view);
			dispatcher.forward(request, response);
        }
    }
	
	
}
