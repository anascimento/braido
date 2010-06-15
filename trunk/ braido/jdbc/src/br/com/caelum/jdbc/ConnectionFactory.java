package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		System.out.println("Conectando ao banco");
		try{
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fj21", "caelum", "caelum");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
