package com.projetovini.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.projetovini.dao.UsuarioDAO;
import com.projetovini.dao.UsuarioDAOImp;
import com.projetovini.model.Usuario;

@WebServlet(urlPatterns="/userController")
public class UsuarioController extends HttpServlet{
	
	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_USERS = "/listUsers.jsp";
	public static final String INSERT_OR_EDIT = "/userTest.jsp";
       
    public UsuarioController() {
    	dao = new UsuarioDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		String filtro= request.getParameter("search");
		
		if(action!=null){
			if( action.equalsIgnoreCase( "delete" ) ) {
				forward = lIST_USERS;
				int userId = Integer.parseInt( request.getParameter("idUsuario") );
				dao.deleta(userId);
				request.setAttribute("usuarios", dao.getTodos());
			}
			else if( action.equalsIgnoreCase( "edit" ) ) {
				forward = INSERT_OR_EDIT;
				int userId = Integer.parseInt( request.getParameter("idUsuario") );
				Usuario user = dao.pegaPorId(userId);
				request.setAttribute("usuario", user);
			}
			else if( action.equalsIgnoreCase( "insert" ) ) {
				forward = INSERT_OR_EDIT;
			} else {
				forward = lIST_USERS;
				request.setAttribute("usuarios", dao.getTodos() );
			}
		} else if(!StringUtils.isNullOrEmpty(filtro)){
				forward = lIST_USERS;
				request.setAttribute("usuarios", dao.find(filtro));
		} else {
			forward = lIST_USERS;
			request.setAttribute("usuarios", dao.getTodos() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setEmailUsu( request.getParameter( "emailUsu" ) );
		usuario.setSenhaUsu( request.getParameter( "senhaUsu" ) );
		usuario.setTelefoneUsu( request.getParameter( "telefoneUsu" ) );
		usuario.setNomeUsu(request.getParameter( "nomeUsu" ) );
		String userId = request.getParameter("idUsuario");
		
		if( userId == null || userId.isEmpty() ) 
			dao.adiciona(usuario);
		else {
			usuario.setIdUsuario( Integer.parseInt(userId) );
			dao.atualiza(usuario);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_USERS );
		request.setAttribute("usuarios", dao.getTodos());
		view.forward(request, response);
	}
}
