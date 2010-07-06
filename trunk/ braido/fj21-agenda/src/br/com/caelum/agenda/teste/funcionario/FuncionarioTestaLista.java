package br.com.caelum.agenda.teste.funcionario;

import java.util.List;

import br.com.caelum.agenda.dao.FuncionarioDAO;
import br.com.caelum.agenda.modelo.Funcionarios;

public class FuncionarioTestaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionarios> funcionarios = dao.getLista();
		for (Funcionarios funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Email: " + funcionario.getUsuario());
			System.out.println("Endereço: " + funcionario.getSenha() + "\n");
		}
	}
}
