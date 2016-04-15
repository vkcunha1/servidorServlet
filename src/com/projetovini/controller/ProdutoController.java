package com.projetovini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;
import com.projetovini.dao.FornecedorDAO;
import com.projetovini.dao.FornecedorDAOImpl;
import com.projetovini.dao.ProdutoDAO;
import com.projetovini.dao.ProdutoDAOImpl;
import com.projetovini.model.Fornecedor;
import com.projetovini.model.Produto;

@WebServlet(urlPatterns="/productController")
public class ProdutoController extends HttpServlet {
	
	private ProdutoDAO dao;
	private FornecedorDAO daoFornec;
	private static final long serialVersionUID = 1L;
	public static final String lIST_PRODUCTS = "/listProducts.jsp";
	public static final String INSERT_OR_EDIT = "/productTest.jsp";
       
    public ProdutoController() {
    	dao = new ProdutoDAOImpl();
    	daoFornec = new FornecedorDAOImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		String filtro= request.getParameter("search");
		
		if(action!=null){
			if( action.equalsIgnoreCase( "delete" ) ) {
				forward = lIST_PRODUCTS;
				int productId = Integer.parseInt( request.getParameter("codProd") );
				dao.deleta(productId);
				request.setAttribute("produtos", dao.getTodos());
			}
			else if( action.equalsIgnoreCase( "edit" ) ) {
				int productId = Integer.parseInt( request.getParameter("codProd") );
				Produto prod = dao.pegaPorId(productId);
				request.setAttribute("fornecedores", daoFornec.getTodos());
				request.setAttribute("produto", prod);
				forward = INSERT_OR_EDIT;
			}
			else if( action.equalsIgnoreCase( "insert" ) ) {
				request.setAttribute("fornecedores", daoFornec.getTodos());
				forward = INSERT_OR_EDIT;
				
			} else {
				forward = lIST_PRODUCTS;
				request.setAttribute("produtos", dao.getTodos() );
			}
		} else if(!StringUtils.isNullOrEmpty(filtro)){
				forward = lIST_PRODUCTS;
				request.setAttribute("produtos", dao.find(filtro));
		} else {
			forward = lIST_PRODUCTS;
			request.setAttribute("produtos", dao.getTodos() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto prod = new Produto();
		prod.setNomeProd( request.getParameter( "nomeProd" ) );
		prod.setTipoProd( request.getParameter( "tipoProd" ) );
		prod.setTamanhoProd( request.getParameter( "tamanhoProd" ) );
		String paramFornec = (request.getParameter("idFornec")).substring(0, 1);
		prod.setProdFornec(daoFornec.pegaPorId(Integer.parseInt(paramFornec)));
		String productId = request.getParameter("codProd");
		
		if( productId == null || productId.isEmpty() ) 
			dao.adiciona(prod);
		else {
			prod.setCodProd( Integer.parseInt(productId));
			dao.atualiza(prod);
		}
		RequestDispatcher view = request.getRequestDispatcher( lIST_PRODUCTS );
		request.setAttribute("produtos", dao.getTodos());
		view.forward(request, response);
	}
}
