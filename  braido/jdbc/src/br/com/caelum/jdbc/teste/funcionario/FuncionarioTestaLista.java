package br.com.caelum.jdbc.teste.funcionario;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioTestaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.getLista();
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Email: " + funcionario.getUsuario());
			System.out.println("Endereço: " + funcionario.getSenha() + "\n");
		}
	}
}
