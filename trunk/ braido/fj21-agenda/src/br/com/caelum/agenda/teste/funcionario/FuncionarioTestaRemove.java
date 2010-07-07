package br.com.caelum.agenda.teste.funcionario;

import br.com.caelum.agenda.dao.FuncionarioDAO;
import br.com.caelum.agenda.modelo.Funcionario;

public class FuncionarioTestaRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1);
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.remove(funcionario);
		System.out.println("Dado Removido!");
	}

}
