package br.com.caelum.jdbc.teste.contato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoTestaRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(1);
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		System.out.println("Dado Removido!");
	}

}