package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		System.out.println("Conectando ao banco");
		try{
			//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fj21", "caelum", "caelum");
			return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/f21", "sa", "");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
