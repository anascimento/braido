
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="cabecalho.jsp" />
<script type="text/javascript">
	function finalizaAgora(id) {
		$.post("finalizaTarefa", {'id' : id}, function(dados) {
			// selecionando o elemento html através da ID e alterando o HTML dele
			$("#tarefa"+id).html("Tarefa finalizada");
		});		
	}
	function removeTarefa(id) {
		$.post("removeTarefa", {'id' : id}, function(dados) {
			// selecionando o elemento html através da ID e alterando o HTML dele
			$(this).closest("tr").hide();
		});
	}
</script>

<table>
	<tr>
		<th>Id</th>
		<th>Descrição</th>
		<th>Finalizado?</th>
		<th>Data de finalização</th>
		<th>Alterar</th>
		<th>Remover</th>	
	</tr>
	<c:forEach items="${tarefas}" var="tarefa">
		<tr>
			<td>${tarefa.id}</td>
			<td>${tarefa.descricao}</td>
			<c:choose>
				<c:when test="${not tarefa.finalizado}">
					<td bgcolor="red" id="tarefa${tarefa.id}">
						<a href="#" onClick="finalizaAgora(${tarefa.id})"> Finaliza agora!</a>
					</td>
				</c:when>
				<c:otherwise>
					<td>Finalizado!</td>
				</c:otherwise>			
			</c:choose>
			<c:choose>
				<c:when test="${not empty tarefa.dataFinalizacao.time}">
					<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
				pattern="dd/MM/yyyy" /></td>
				</c:when>
				<c:otherwise>
				<td></td>	
				</c:otherwise>
			</c:choose>		
			<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
			<td><a href="#" onClick="removeTarefa(${tarefa.id})">Remover</a></td>
		</tr>
	</c:forEach>
</table>

<c:import url="rodape.jsp" />