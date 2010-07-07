package br.com.caelum.agenda.teste.contato;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

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