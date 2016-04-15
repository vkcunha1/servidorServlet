package com.projetovini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetovini.model.Produto;
import com.projetovini.model.Usuario;
import com.projetovini.util.DBUtil;

public class ProdutoDAOImpl implements ProdutoDAO {

	private Connection conexao;

	public ProdutoDAOImpl() {
		conexao = DBUtil.getConnection();
	}
	
	@Override
	public void adiciona(Produto t) {
		try {
			String query = "insert into produto (nomeProd, tipoProd, tamanhoProd,prodFornec) values (?,?,?,?)";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, t.getNomeProd() );
			preparedStatement.setString( 2, t.getTipoProd() );
			preparedStatement.setString( 3, t.getTamanhoProd() );
			preparedStatement.setInt( 4, t.getProdFornec().getIdFornec() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleta(int idProd) {
		try {
			String query = "delete from produto where codProd=?";
			PreparedStatement preparedStatement = conexao.prepareStatement(query);
			preparedStatement.setInt(1, idProd);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualiza(Produto t) {
		try {
			String query = "update produto set nomeProd=?, tipoProd=?, tamanhoProd=?, prodFornec=? where codProd=? ;";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, t.getNomeProd());
			preparedStatement.setString( 2, t.getTipoProd() );
			preparedStatement.setString( 3, t.getTamanhoProd() );
			preparedStatement.setInt( 4, t.getProdFornec().getIdFornec() );
			preparedStatement.setInt(5, t.getCodProd());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> getTodos() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery( "select a.codProd,a.nomeProd,a.tipoProd,a.tamanhoProd,a.prodFornec,"
					+ "b.idFornec "
					+ "from produto as a inner join fornecedor as b on b.idFornec = a.prodFornec;" );
			while( resultSet.next() ) {
				Produto p = new Produto();
				p.setCodProd( resultSet.getInt( "codProd" ) );
				p.setNomeProd( resultSet.getString( "nomeProd" ) );
				p.setTipoProd( resultSet.getString( "tipoProd" ) );
				p.setTamanhoProd(resultSet.getString( "tamanhoProd" ) );
				FornecedorDAO fornDao = new FornecedorDAOImpl();
				p.setProdFornec(fornDao.pegaPorId(resultSet.getInt( "prodFornec" )));
				produtos.add(p);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public Produto pegaPorId(int codProd) {
		Produto p = new Produto();
		try {
			String query = "select a.codProd,a.nomeProd,a.tipoProd,a.tamanhoProd,"
					+ "a.prodFornec,b.idFornec "
					+ "from produto a inner join fornecedor b on a.prodFornec = b.idFornec where a.codProd=?;";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setInt(1, codProd);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				p.setCodProd( resultSet.getInt( "codProd" ) );
				p.setNomeProd( resultSet.getString( "nomeProd" ) );
				p.setTipoProd( resultSet.getString( "tipoProd" ) );
				p.setTamanhoProd( resultSet.getString( "tamanhoProd" ) );
				FornecedorDAO fornDao = new FornecedorDAOImpl();
				p.setProdFornec(fornDao.pegaPorId(resultSet.getInt( "prodFornec" )));
				
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produto> find(String filtro) {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
				Statement statement = conexao.createStatement();
				ResultSet resultSet = statement.executeQuery( "select a.codProd,a.nomeProd,a.tipoProd,a.tamanhoProd,"
						+ "a.prodFornec,b.idFornec,b.nomeFornec "
						+ "from produto a inner join fornecedor b on a.prodFornec = b.idFornec where a.nomeProd like '%"+filtro+"%';" );
				while( resultSet.next() ) {
					Produto p = new Produto();
					p.setCodProd( resultSet.getInt( "codProd" ) );
					p.setNomeProd( resultSet.getString( "nomeProd" ) );
					p.setTipoProd( resultSet.getString( "tipoProd" ) );
					p.setTamanhoProd( resultSet.getString( "tamanhoProd" ) );
					FornecedorDAO fornDao = new FornecedorDAOImpl();
					p.setProdFornec(fornDao.pegaPorId(resultSet.getInt( "prodFornec" )));
					produtos.add(p);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produtos;
	}

}
