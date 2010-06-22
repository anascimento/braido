package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Funcionario;

public class FuncionarioDAO {
	private Connection connection;
	private DAOException exception;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios (nome,usuario,senha) VALUES (?,?,?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public List<Funcionario> getLista() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM funcionarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de Contato
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));

				// Adiciona o funcionario a lista
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
		return funcionarios;
	}

	public void altera(Funcionario funcionario) {
		String sql = "UPDATE funcionarios SET " + "nome = ?," + "usuario = ?, senha = ? WHERE id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}

	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}
}
