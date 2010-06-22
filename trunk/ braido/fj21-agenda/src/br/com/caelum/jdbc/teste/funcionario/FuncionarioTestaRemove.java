package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

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
