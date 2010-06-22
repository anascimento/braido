package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {

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
