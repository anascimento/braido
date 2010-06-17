package br.com.caelum.jdbc.teste.contato;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoTestaAltera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Setando os valores a serem salvos
		Contato contato = new Contato();
		contato.setId(2);
		contato.setNome("Caelum 2");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("Rua Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		System.out.println("Dado Alterado!");
		
	}

}
