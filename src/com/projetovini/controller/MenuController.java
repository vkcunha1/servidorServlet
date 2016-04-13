package com.projetovini.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author vinicius
 * 
 */

@WebServlet(urlPatterns="/menuController")
public class MenuController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MENU_INICIO = "/menu.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("menuCliente")){
			
		} else{
			forward = MENU_INICIO;
		}
		requestDispatcher = request.getRequestDispatcher(forward);
		requestDispatcher.forward(request, response);
	}
}
