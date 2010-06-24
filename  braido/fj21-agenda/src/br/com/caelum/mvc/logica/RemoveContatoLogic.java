package br.com.caelum.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Contato contato = new Contato();
		long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Removendo o contato " + contato.getNome());
	}

}
