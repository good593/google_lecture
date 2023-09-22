package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MinService;

public class MinHandler implements CommandHandler {
	
	private MinService service = new MinService();

	@Override
	public String handlerAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		int result = service.min(n1, n2);
		
		req.setAttribute("result", result);
		
		return "jsp/min.jsp";
	}

}
