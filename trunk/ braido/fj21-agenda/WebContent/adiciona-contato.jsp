<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<c:import url="cabecalho.jsp"/>

<form action="adicionaContato">
	Nome: <input type="text" name="nome" /><br />
	E-mail: <input type="text" name="email" /><br />
	Endereço: <input type="text" name="endereco" /><br />
	<!-- Data Nascimento: <input type="text" name="dataNascimento" /><br /> -->
	<!-- Utilizando o datePicker do JQuery com tagfiles -->
	Data Nascimento: <caelum:campoData id="dataNascimento"/><br />
	<input type="submit" value="Gravar" />
</form>
<c:import url="rodape.jsp"></c:import>
