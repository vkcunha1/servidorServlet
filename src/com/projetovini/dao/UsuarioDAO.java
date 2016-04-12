package com.projetovini.dao;

import com.projetovini.model.Usuario;

public interface UsuarioDAO {
	public Usuario pegaUsuarioPorEmailESenha(String email,String senha);
}
