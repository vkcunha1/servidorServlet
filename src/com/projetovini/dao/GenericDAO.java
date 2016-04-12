package com.projetovini.dao;

import java.util.List;

public interface GenericDAO<T> {
	public void adiciona( T t );
	public void deleta( int id );
	public void atualiza( T t);
	public List<T> getTodos();
	public T pegaPorId( int id );
}
