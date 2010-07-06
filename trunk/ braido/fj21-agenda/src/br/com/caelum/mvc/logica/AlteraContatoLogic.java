package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contatos;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String paramAltera = request.getParameter("paramAltera");
		if(paramAltera.equalsIgnoreCase("altera")){
			this.altera(request, response);
		}else if(paramAltera.equalsIgnoreCase("popula")){
			this.popula(request, response);
		}
	}
	
	public void altera(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contatos contato = new Contatos();
		Connection connection = (Connection) request.getAttribute("connection");//Faz a conexão através do filtro
		
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
		
		ContatoDAO dao = new ContatoDAO(connection);
		dao.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Alterando contato, " + contato.getNome());		
	}
		
	public void popula(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String id = request.getParameter("id");
		Connection connection = (Connection) request.getAttribute("connection");//Faz a conexão através do filtro
		
		Contatos contato = new ContatoDAO(connection).getEspecifico(id);
		request.setAttribute("contato", contato);
		RequestDispatcher rd = request.getRequestDispatcher("/testa-altera-mvc.jsp");
		rd.forward(request, response);
		System.out.println("Recebido o ID para efetuar a alteração, " + contato.getId());
	}
}
