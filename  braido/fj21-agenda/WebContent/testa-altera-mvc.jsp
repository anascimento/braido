<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<c:import url="cabecalho.jsp" />

Formulário para alteração de contatos:<br/>
<form action="mvc" method="POST">
	Id: <input type="text" name="id" readonly="readonly" value="${contato.id}"/><br/>
	Nome: <input type="text" name="nome" value="${contato.nome}"/><br/>
	E-mail: <input type="text" name="email" value="${contato.email}"/><br/>
	Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br/>
	Data de Nascimento: <caelum:campoData id="dataNascimento" value="${contato.dataNascimento.time}"/>
	<input type="hidden" name="logica" value="AlteraContatoLogic"/>
	<input type="hidden" name="paramAltera" value="altera"/>
	<br/><input type="submit" value="Enviar"/>
</form>

<c:import url="rodape.jsp" />