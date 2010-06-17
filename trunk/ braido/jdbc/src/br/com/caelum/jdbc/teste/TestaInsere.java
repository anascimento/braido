package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Setando os valores a serem salvos
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("Rua Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//Instanciando para gravar no Banco através do DAO
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Dados gravados!");
	}

}
