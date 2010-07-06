package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contatos;

public class RemoveContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contatos contato = new Contatos();
		Connection connection = (Connection) request.getAttribute("connection");//Faz a conexão através do filtro
		
		long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		
		ContatoDAO dao = new ContatoDAO(connection);
		dao.remove(contato);
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Removendo o contato " + contato.getNome());
	}

}
