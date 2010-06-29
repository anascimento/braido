package br.com.caelum.tarefas.dao;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
	public void getException(Exception e){
		System.out.println(e.getMessage());
	}
}
