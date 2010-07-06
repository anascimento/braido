package br.com.caelum.agenda.teste.funcionario;

import br.com.caelum.agenda.dao.FuncionarioDAO;
import br.com.caelum.agenda.modelo.Funcionarios;

public class FuncionarioTestaRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionarios funcionario = new Funcionarios();
		funcionario.setId(1);
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.remove(funcionario);
		System.out.println("Dado Removido!");
	}

}
