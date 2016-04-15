package com.projetovini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;
import com.projetovini.dao.UsuarioDAO;
import com.projetovini.dao.UsuarioDAOImp;
import com.projetovini.model.Usuario;

@WebServlet(urlPatterns="/loginController")
public class LoginController extends HttpServlet {
	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String MENU_CONTROLE = "/menuController";
	public static final String SUCESSO ="/sucessoLogin.jsp";
	public static final String LOGIN= "/index.html";
	
	public LoginController(){
		dao=new UsuarioDAOImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		RequestDispatcher requestDispatcher = null;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action.equalsIgnoreCase("nao")){
			 session.removeAttribute("usuarioLogado");
			 forward = LOGIN;
			 requestDispatcher = request.getRequestDispatcher(forward);
		}
		else if(action.equalsIgnoreCase("sim")){
			forward = MENU_CONTROLE;
			requestDispatcher= request.getRequestDispatcher(forward);
		}
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramEmail = request.getParameter("email");
		String paramSenha = request.getParameter("senha");
		HttpSession session = request.getSession();
		RequestDispatcher requestDispatcher = null;
		String forward="";
		
		if(!StringUtils.isNullOrEmpty(paramEmail) && !StringUtils.isNullOrEmpty(paramSenha)){
			Usuario usuarioLogado = dao.pegaUsuarioPorEmailESenha(paramEmail, paramSenha);
			if(Usuario.notNovoObjeto(usuarioLogado)){
				session.setAttribute("usuarioLogado", usuarioLogado);
				forward=SUCESSO;
				requestDispatcher = request.getRequestDispatcher(forward);
			}
		} 
		if(requestDispatcher ==null){
			forward = LOGIN;
			requestDispatcher = request.getRequestDispatcher(forward);
		}
		requestDispatcher.forward(request, response);
	}

}
