package br.com.caelum.agenda.teste.funcionario;

import br.com.caelum.agenda.dao.FuncionarioDAO;
import br.com.caelum.agenda.modelo.Funcionario;

public class FuncionarioTestaInsere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Setando os valores a serem salvos
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Caelum");
		funcionario.setUsuario("caelum");
		funcionario.setSenha("pwdcaelum");
		
		//Instanciando para gravar no Banco através do DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adiciona(funcionario);
		System.out.println("Dados gravados!");
	}

}
