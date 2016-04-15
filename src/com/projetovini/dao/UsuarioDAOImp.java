package com.projetovini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetovini.model.Student;
import com.projetovini.model.Usuario;
import com.projetovini.util.DBUtil;

public class UsuarioDAOImp implements UsuarioDAO {
	
	private Connection conexao;

	public UsuarioDAOImp() {
		conexao = DBUtil.getConnection();
	}
	
	public Usuario pegaUsuarioPorEmailESenha(String email,String senha){
		Usuario usuario= new Usuario();
		try {
			String query = "select * from usuario where emailUsu=? and senhaUsu=?";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				usuario.setIdUsuario( resultSet.getInt( "idUsuario" ) );
				usuario.setEmailUsu( resultSet.getString( "emailUsu" ) );
				usuario.setSenhaUsu( resultSet.getString( "senhaUsu" ) );
				usuario.setTelefoneUsu(resultSet.getString("telefoneUsu"));
				usuario.setNomeUsu(resultSet.getString("nomeUsu"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public List<Usuario> find(String filtro) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
				Statement statement = conexao.createStatement();
				ResultSet resultSet = statement.executeQuery( "select * from usuario where nomeUsu like '%"+filtro+"%';" );
				while( resultSet.next() ) {
					Usuario usu = new Usuario();
					usu.setIdUsuario( resultSet.getInt( "idUsuario" ) );
					usu.setEmailUsu( resultSet.getString( "emailUsu" ) );
					usu.setSenhaUsu( resultSet.getString( "senhaUsu" ) );
					usu.setTelefoneUsu(resultSet.getString( "telefoneUsu" ) );
					usu.setNomeUsu(resultSet.getString("nomeUsu"));
					usuarios.add(usu);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return usuarios;
	}
	
	@Override
	public void adiciona(Usuario usu) {
		try {
			String query = "insert into usuario (emailUsu, senhaUsu, telefoneUsu,nomeUsu) values (?,?,?,?)";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, usu.getEmailUsu() );
			preparedStatement.setString( 2, usu.getSenhaUsu() );
			preparedStatement.setString( 3, usu.getTelefoneUsu() );
			preparedStatement.setString( 4, usu.getNomeUsu() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleta(int idUsu) {
		try {
			String query = "delete from usuario where idUsuario=?";
			PreparedStatement preparedStatement = conexao.prepareStatement(query);
			preparedStatement.setInt(1, idUsu);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	

	@Override
	public void atualiza(Usuario usu) {
		try {
			String query = "update usuario set emailUsu=?, senhaUsu=?, telefoneUsu=?, nomeUsu=? where idUsuario=?";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setString( 1, usu.getEmailUsu());
			preparedStatement.setString( 2, usu.getSenhaUsu() );
			preparedStatement.setString( 3, usu.getTelefoneUsu() );
			preparedStatement.setString( 4, usu.getNomeUsu() );
			preparedStatement.setInt(5, usu.getIdUsuario());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> getTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from usuario" );
			while( resultSet.next() ) {
				Usuario usu = new Usuario();
				usu.setIdUsuario( resultSet.getInt( "idUsuario" ) );
				usu.setEmailUsu( resultSet.getString( "emailUsu" ) );
				usu.setSenhaUsu( resultSet.getString( "senhaUsu" ) );
				usu.setTelefoneUsu(resultSet.getString( "telefoneUsu" ) );
				usu.setNomeUsu(resultSet.getString("nomeUsu"));
				usuarios.add(usu);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario pegaPorId(int usuId) {
		Usuario usuario = new Usuario();
		try {
			String query = "select * from usuario where idUsuario=?";
			PreparedStatement preparedStatement = conexao.prepareStatement( query );
			preparedStatement.setInt(1, usuId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				usuario.setIdUsuario( resultSet.getInt( "idUsuario" ) );
				usuario.setEmailUsu( resultSet.getString( "emailUsu" ) );
				usuario.setSenhaUsu( resultSet.getString( "senhaUsu" ) );
				usuario.setTelefoneUsu( resultSet.getString( "telefoneUsu" ) );
				usuario.setNomeUsu( resultSet.getString( "nomeUsu" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
		
}

