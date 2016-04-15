package com.projetovini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetovini.model.Fornecedor;
import com.projetovini.model.Usuario;
import com.projetovini.util.DBUtil;

public class FornecedorDAOImpl implements FornecedorDAO {
	
	private Connection conexao;

	public FornecedorDAOImpl() {
		conexao = DBUtil.getConnection();
	}
	
	@Override
	public void adiciona(Fornecedor t) {
		try {
			String query = "insert into fornecedor (nomeFornec, cnpjFornec, fornecUf,dsFornec,telFornec) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, t.getNomeFornec() );
			preparedStatement.setString( 2, t.getCnpjFornec() );
			preparedStatement.setString( 3, t.getFornecUf() );
			preparedStatement.setString( 4, t.getDsFornec() );
			preparedStatement.setString( 5, t.getTelFornec() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleta(int id) {
		try {
			String query = "delete from fornecedor where idFornec=?";
			PreparedStatement preparedStatement = conexao.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualiza(Fornecedor t) {
		try {
			String query = "update fornecedor set nomeFornec=?, cnpjFornec=?, fornecUf=?, dsFornec=?, telFornec=? where idFornec=?";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, t.getNomeFornec());
			preparedStatement.setString( 2, t.getCnpjFornec() );
			preparedStatement.setString( 3, t.getFornecUf() );
			preparedStatement.setString( 4, t.getDsFornec() );
			preparedStatement.setString( 5, t.getTelFornec() );
			preparedStatement.setInt(6, t.getIdFornec());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Fornecedor> getTodos() {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from fornecedor" );
			while( resultSet.next() ) {
				Fornecedor fornec = new Fornecedor();
				fornec.setIdFornec( resultSet.getInt( "idFornec" ) );
				fornec.setNomeFornec( resultSet.getString( "nomeFornec" ) );
				fornec.setCnpjFornec( resultSet.getString( "cnpjFornec" ) );
				fornec.setFornecUf(resultSet.getString( "fornecUf" ) );
				fornec.setDsFornec(resultSet.getString("dsFornec"));
				fornec.setTelFornec(resultSet.getString("telFornec"));
				fornecedores.add(fornec);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fornecedores;
	}

	@Override
	public Fornecedor pegaPorId(int id) {
		Fornecedor fornec = new Fornecedor();
		try {
			String query = "select * from fornecedor where idFornec=?";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				fornec.setIdFornec( resultSet.getInt( "idFornec" ) );
				fornec.setNomeFornec( resultSet.getString( "nomeFornec" ) );
				fornec.setCnpjFornec( resultSet.getString( "cnpjFornec" ) );
				fornec.setFornecUf(resultSet.getString( "fornecUf" ) );
				fornec.setDsFornec(resultSet.getString("dsFornec"));
				fornec.setTelFornec(resultSet.getString("telFornec"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fornec;
	}

	@Override
	public List<Fornecedor> find(String filtro) {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
				Statement statement = conexao.createStatement();
				ResultSet resultSet = statement.executeQuery( "select * from fornecedor where nomeFornec like '%"+filtro+"%';" );
				while( resultSet.next() ) {
					Fornecedor fornec = new Fornecedor();
					fornec.setIdFornec( resultSet.getInt( "idFornec" ) );
					fornec.setNomeFornec( resultSet.getString( "nomeFornec" ) );
					fornec.setCnpjFornec( resultSet.getString( "cnpjFornec" ) );
					fornec.setFornecUf(resultSet.getString( "fornecUf" ) );
					fornec.setDsFornec(resultSet.getString("dsFornec"));
					fornec.setTelFornec(resultSet.getString("telFornec"));
					fornecedores.add(fornec);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return fornecedores;
	}
}

