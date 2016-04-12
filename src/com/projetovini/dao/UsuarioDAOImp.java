package com.projetovini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
