package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Contatos;

public class ContatoDAO {
	private Connection connection;
	private DAOException exception;

	 public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	 //Utilizando a conexão pelo Filtro
	public ContatoDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(Contatos contato) {
		String sql = "INSERT INTO contatos (nome,email,endereco,dataNascimento) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public List<Contatos> getLista() {
		List<Contatos> contatos = new ArrayList<Contatos>();
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de Contato
				Contatos contato = new Contatos();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);

				// Adiciona o contato a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
		return contatos;
	}

	public void altera(Contatos contato) {
		String sql = "UPDATE contatos SET " + "nome = ?," + "email = ?,"
				+ "endereco = ?," + "datanascimento = ?" + "WHERE id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public void remove(Contatos contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}
	
	public Contatos getEspecifico(String id){
		Contatos contato = new Contatos();
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos WHERE id=?");
			stmt.setLong(1, Long.parseLong(id));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de Contato
				//Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
		return contato;
	}
}
