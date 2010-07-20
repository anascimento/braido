package br.com.caelum.hibernate;

import java.util.Calendar;

import org.hibernate.Session;

public class AdicionaProduto {
	public static void main(String[] args) {
		Produto p = new Produto();
		p.setNome("Nome aqui");
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DATE, 11);
		data.set(Calendar.MONTH, Calendar.FEBRUARY);
		data.set(Calendar.YEAR, 2004);
		p.setDataInicioVenda(data);
		
		p.setPreco(100.50);
		
		Session session = new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		System.out.println("ID do produto: " + p.getId());
		session.close();
	}
}
