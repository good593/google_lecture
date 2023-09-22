package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddService;

public class AddHandler implements CommandHandler {
	
	private AddService service = new AddService();

	@Override
	public String handlerAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		int result = service.add(n1, n2);
		
		req.setAttribute("result", result);
		
		return "jsp/add.jsp";
	}

}