package br.com.caelum.jdbc.dao;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
	public void getException(Exception e){
		System.out.println(e);
	}
}
