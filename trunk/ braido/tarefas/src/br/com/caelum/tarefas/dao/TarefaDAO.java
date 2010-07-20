package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import br.com.caelum.tarefas.modelo.Tarefa;

public class TarefaDAO {

	public TarefaDAO(){
		setSession();
	}
	
	//Utilizando o DAO
	private Connection connection;
	private DAOException exception;
	/*public TarefaDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}*/
	
	public void adiciona(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.execute();
			stmt.close();
			System.out.println("Inserido tarefa com sucesso!");
		} catch (SQLException e) {
			this.exception.getException(e);
		}
	}
	
	//Utilizando o Hibernates
	private Session session;
	
	private void setSession(){
		this.session = new HibernateUtil(Tarefa.class).getSession();
	}
	
	public TarefaDAO(Session session){
		this.session = session;
	}
	
	public void salva(Tarefa tarefa){
		this.session.beginTransaction();
		try{
			this.session.save(tarefa);
			this.session.beginTransaction().commit();
			System.out.println("ID da tarefa adicionada: " + tarefa.getId());
		}catch(Exception erro){
			System.out.println("Houve um erro ao tentar salvar uma tarefa: "+ erro.getMessage());
			erro.printStackTrace();
			this.session.beginTransaction().rollback();
		}finally{
			this.session.close();
		}
		
	}
	
	public void remove(Tarefa tarefa){
		this.session.delete(tarefa);
	}
	
	public void altera(Tarefa tarefa){
		this.session.update(tarefa);
	}
	
	public List<Tarefa> listaTudo(){
		return this.session.createCriteria(Tarefa.class).list();
	}
	/*public void adiciona(Tarefa tarefa){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
			em.persist(tarefa);
			em.getTransaction().commit();
			System.out.println("Tarefa cadastrada");
		}catch(Exception e){
			System.out.println("Houve um problema ae tentar cadastrar a tarefa: " + e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}*/
	
}
