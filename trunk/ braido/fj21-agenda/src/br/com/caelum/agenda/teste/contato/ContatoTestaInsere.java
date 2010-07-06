package br.com.caelum.agenda.teste.contato;

import java.util.Calendar;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contatos;

public class ContatoTestaInsere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Setando os valores a serem salvos
		Contatos contato = new Contatos();
		contato.setNome("Caelum 3");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("Rua Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//Instanciando para gravar no Banco através do DAO
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Dados gravados!");
	}

}
