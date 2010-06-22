package br.com.caelum.jdbc.teste.funcionario;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

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
		
		//Instanciando para gravar no Banco atrav�s do DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adiciona(funcionario);
		System.out.println("Dados gravados!");
	}

}
