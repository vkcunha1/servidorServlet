package com.projetovini.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projetovini.dao.UsuarioDAO;
import com.projetovini.dao.UsuarioDAOImp;
import com.projetovini.model.Usuario;

@WebServlet(urlPatterns="/loginController")
public class LoginController extends HttpServlet {
	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String MENU = "/listStudent.jsp";
	public static final String LOGIN= "/login.jsp";
	
	public LoginController(){
		dao=new UsuarioDAOImp();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		RequestDispatcher requestDispatcher = null;
		String action = request.getParameter("action");
		String paramEmail = request.getParameter("email");
		String paramSenha = request.getParameter("senha");
		
		if(action.equalsIgnoreCase("inicio")){
			 requestDispatcher = request.getRequestDispatcher(LOGIN);
		}
		if(action.equalsIgnoreCase("logar")){
			Usuario usuarioLogado = dao.pegaUsuarioPorEmailESenha(paramEmail, paramSenha);
			if(usuarioLogado != null){
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogado", usuarioLogado);
				 requestDispatcher = request.getRequestDispatcher(MENU);
			}
		}
		requestDispatcher.forward(request, response);
	}

}
