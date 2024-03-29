package br.com.caelum.agenda.teste.contato;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ContatoTestaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		for(Contato contato : contatos){
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endere�o: " + contato.getEndereco());
			System.out.println("Data Nascimeto: " + dateFormat.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
