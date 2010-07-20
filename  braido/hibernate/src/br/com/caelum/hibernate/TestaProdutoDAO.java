package br.com.caelum.hibernate;

import java.util.Calendar;

import org.hibernate.Session;

import br.com.caelum.hibernate.DAO.ProdutoDAO;

public class TestaProdutoDAO {

	public static void main(String[] args) {
		TestaProdutoDAO testa = new TestaProdutoDAO();
		testa.salva();
		System.out.println("\n\n\n");
		testa.procura();
	}
	
	public void salva(){
		Session session =  new HibernateUtil().getSession();
		
		ProdutoDAO dao = new ProdutoDAO(session);
		Produto produto = new Produto();
		
		produto.setNome("Iphone");
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DATE, 05);
		data.set(Calendar.MONTH, Calendar.AUGUST);
		data.set(Calendar.YEAR, 2010);
		produto.setDataInicioVenda(data);
		
		produto.setPreco(249.80);
		
		session.beginTransaction();
		dao.salva(produto);
		session.getTransaction().commit();
		System.out.println("ID do produto cadastrado: " + produto.getId());
		session.close();
	}
	
	public void procura(){
		Session session =  new HibernateUtil().getSession();
		
		ProdutoDAO dao = new ProdutoDAO(session);
		long id = 10;
		
		session.beginTransaction();
		Produto produto = dao.procura(id);
		System.out.println("Detalhes do Produto");
		System.out.println("Id:" + produto.getId());
		System.out.println("Nome:" + produto.getNome());
		System.out.println("Preço:" + produto.getPreco());
		System.out.println("Data:" + produto.getDataInicioVenda());
		session.close();
	}
}
