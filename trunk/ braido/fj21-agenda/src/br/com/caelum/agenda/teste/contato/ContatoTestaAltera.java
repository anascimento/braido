package br.com.caelum.agenda.teste.contato;

import java.util.Calendar;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contatos;

public class ContatoTestaAltera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Setando os valores a serem salvos
		Contatos contato = new Contatos();
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
