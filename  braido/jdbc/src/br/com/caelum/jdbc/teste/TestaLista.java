package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		for(Contato contato : contatos){
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endere�o: " + contato.getEndereco());
			System.out.println("Data Nascimeto: " + dateFormat.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
