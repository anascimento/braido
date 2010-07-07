<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Contatos</title>
</head>
<body>
	<table>
		<%
			ContatoDAO dao = new ContatoDAO();
			List<Contato> contatos = dao.getLista();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
			for(Contato contato : contatos){
			%>
				<tr>
					<td><%= contato.getNome()%></td>
					<td><%= contato.getEmail()%></td>
					<td><%= contato.getEndereco()%></td>
					<td><%= dateFormat.format(contato.getDataNascimento().getTime())%></td>
				</tr>	
			<%} %>
	</table>
</body>
</html>