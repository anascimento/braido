package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Tarefa;

public class TarefaDAO {
	private Connection connection;
	private DAOException exception;

	public TarefaDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas (descricao, datafinalizacao) VALUES (?,?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setDate(2, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public List<Tarefa> getLista() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM tarefas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de tarefa
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));				

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datafinalizacao"));
				tarefa.setDataFinalizacao(data);

				// Adiciona o tarefas a lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
		return tarefas;
	}
	
	public void altera(Tarefa tarefa) {
		String sql = "UPDATE tarefas SET " + "descricao = ?," + "finalizado = ?,"
				+ "datafinalizacao = ? " + "WHERE id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);			
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());			
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM tarefas WHERE id=?");
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}
	
	public Tarefa buscaPorId(Long id){
		Tarefa tarefa = new Tarefa();
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM tarefas WHERE id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de Tarefa
				//Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datafinalizacao"));
				tarefa.setDataFinalizacao(data);				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
		return tarefa;
	}
}
