<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="cabecalho.jsp"/>
<!--  Cria lista  -->
<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO"/>
	Utilizando o IF do JSTL	
	<table border="1">
		<!-- for -->
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}">			
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail não informado
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>	
		</c:forEach>
	</table>
	<br/>
	<!-- Utilizando o choose do JSTL -->
	Utilizando o CHOOSE do JSTL
	<table border="1">
		<!-- for -->
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}">			
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>					
				</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>	
		</c:forEach>
	</table>
<c:import url="rodape.jsp"/>