package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato();
		long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		//Converte a Data de Nascimento.
		String dataEmText = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmText);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDAO dao = new ContatoDAO();
		dao.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Alterando contato, " + contato.getNome());
		

	}

}
