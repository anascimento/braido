package br.com.caelum.hibernate;

import org.hibernate.Session;

import br.com.caelum.hibernate.DAO.ProdutoDAO;

public class TestaBuscas {
	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession();
		ProdutoDAO produtoDao = new ProdutoDAO(session);
		System.out.println("*****Listando Tudo*******");
		for (Produto p : produtoDao.listaTudo()) {
			System.out.println(p.getNome());
		}
		System.out.println("*****Listando Paginado*******");
		for (Produto p : produtoDao.listaPagina(2, 3)) {
			System.out.println(p.getNome());
		}
		System.out.println("*****Preços maiores que*******");
		for (Produto p : produtoDao.precoMaiorQue(2.10)) {
			System.out.println(p.getNome());
		}
	}
}
