package com.projetovini.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.projetovini.dao.FornecedorDAO;
import com.projetovini.dao.FornecedorDAOImpl;
import com.projetovini.model.Fornecedor;

@WebServlet(urlPatterns="/providerController")
public class FornecedorController extends HttpServlet {
	
	private FornecedorDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_PROVIDERS = "/listProviders.jsp";
	public static final String INSERT_OR_EDIT = "/providerTest.jsp";
       
    public FornecedorController() {
    	dao = new FornecedorDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		String filtro = request.getParameter( "search" );
		
		if(action!=null){
			if( action.equalsIgnoreCase( "delete" ) ) {
				forward = lIST_PROVIDERS;
				int fornecId = Integer.parseInt( request.getParameter("idFornec") );
				dao.deleta(fornecId);
				request.setAttribute("fornecedores", dao.getTodos());
			}
			else if( action.equalsIgnoreCase( "edit" ) ) {
				forward = INSERT_OR_EDIT;
				int fornecId = Integer.parseInt( request.getParameter("idFornec") );
				Fornecedor fornec = dao.pegaPorId(fornecId);
				request.setAttribute("fornecedor", fornec);
			}
			else if( action.equalsIgnoreCase( "insert" ) ) {
				forward = INSERT_OR_EDIT;
			} else {
				forward = lIST_PROVIDERS;
				request.setAttribute("fornecedores", dao.getTodos() );
			}
		} else if(!StringUtils.isNullOrEmpty(filtro)){
			forward = lIST_PROVIDERS;
			request.setAttribute("fornecedores", dao.find(filtro));
		} else {
			forward = lIST_PROVIDERS;
			request.setAttribute("fornecedores", dao.getTodos() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fornecedor fornec = new Fornecedor();
		fornec.setNomeFornec( request.getParameter( "nomeFornec" ) );
		fornec.setCnpjFornec( request.getParameter( "cnpjFornec" ) );
		fornec.setFornecUf( request.getParameter( "fornecUf" ) );
		fornec.setDsFornec(request.getParameter( "dsFornec" ) );
		fornec.setTelFornec(request.getParameter( "telFornec" ) );
		String fornecId = request.getParameter("idFornec");
		String filtro= request.getParameter("search");
		
		if( fornecId == null || fornecId.isEmpty() ) 
			dao.adiciona(fornec);
		else {
			fornec.setIdFornec( Integer.parseInt(fornecId) );
			dao.atualiza(fornec);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_PROVIDERS );
		request.setAttribute("fornecedores", dao.getTodos());
		view.forward(request, response);
	}
}
