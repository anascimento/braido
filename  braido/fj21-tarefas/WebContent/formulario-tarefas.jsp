<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<c:import url="cabecalho.jsp"/>

<h3>Adicionar tarefas</h3>
	<form action="adicionaTarefa" method="post">
	Descrição: <br />
		<textarea name="tarefa.descricao" rows="5" cols="100"></textarea><br />
	<input type="submit" value="Adicionar">
	</form>

<c:import url="rodape.jsp"></c:import>