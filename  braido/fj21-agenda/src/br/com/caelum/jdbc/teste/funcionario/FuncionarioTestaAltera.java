package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioTestaAltera {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Setando os valores a serem salvos
		Funcionario funcionario = new Funcionario();
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
