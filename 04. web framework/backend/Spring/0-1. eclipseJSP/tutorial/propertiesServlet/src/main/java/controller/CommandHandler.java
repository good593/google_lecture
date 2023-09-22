package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {

	public String handlerAction (
		HttpServletRequest req, HttpServletResponse resp		
	) throws ServletException, IOException;
}
