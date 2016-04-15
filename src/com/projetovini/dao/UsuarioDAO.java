package com.projetovini.dao;

import com.projetovini.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public Usuario pegaUsuarioPorEmailESenha(String email,String senha);
}
