package br.com.caelum.agenda.teste.funcionario;

import br.com.caelum.agenda.dao.FuncionarioDAO;
import br.com.caelum.agenda.modelo.Funcionarios;

public class FuncionarioTestaAltera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Setando os valores a serem salvos
		Funcionarios funcionario = new Funcionarios();
		funcionario.setId(2);
		funcionario.setNome("Caelum 2");
		funcionario.setUsuario("caelum2");
		funcionario.setSenha("pwdcaelum2");
		
		//Instanciando para gravar no Banco através do DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.altera(funcionario);
		System.out.println("Dados alterados!");
	}
}
