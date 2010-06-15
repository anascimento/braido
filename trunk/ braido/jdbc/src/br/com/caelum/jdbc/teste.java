package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Connection connection = new ConnectionFactory().getConnection();
			System.out.println("Conectou no banco");
			connection.close();
		}catch(SQLException e){
			System.out.println("Error: " + e.getMessage());
		}
				
	}

}
