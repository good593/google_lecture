package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		// 초기화 파라미터를 이용하여 Properties 불러오기 
		String contextconfigFile = this.getInitParameter("handlerProperties"); // web.xml에 정의된 이름 사용!!
		System.out.println("properties 파일의 상대경로: "+contextconfigFile);
		Properties properties = new Properties();
		FileInputStream fis = null;
		
		try {
			
			// 파일 절대경로 
			String contextConfigFilePath = this.getServletContext().getRealPath(contextconfigFile);
			System.out.println("properties 파일의 절대경로: "+contextConfigFilePath);
			fis = new FileInputStream(contextConfigFilePath);
			properties.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 핸들러 객체 생성 및 Map에 등록 
		Iterator<Object> propIt = properties.keySet().iterator();
		while(propIt.hasNext()) {
			String command = (String)propIt.next();
			String handlerClassName = properties.getProperty(command);
			
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				commandHandlerMap.put(command, (CommandHandler)handlerClass.getDeclaredConstructor().newInstance());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Controller가 요청 분석 ");
		String requestURI = req.getRequestURI().toString();
		System.out.println("요청 URI: "+requestURI);
		
		String command = requestURI.substring(req.getContextPath().length());
		System.out.println("command: "+command);
		
		CommandHandler handler = null; 
		String viewPage = null; 
		
		if (requestURI.indexOf(req.getContextPath()) == 0) {
			handler = commandHandlerMap.get(command);
			viewPage = handler.handlerAction(req,  resp);
			System.out.println("Model관련 로직 동작 ");
		}
		
		System.out.println("View관련 로직 동작 ");
		req.getRequestDispatcher(viewPage).forward(req, resp);
	}


}
