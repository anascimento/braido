<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/display" prefix="display" %>

<c:import url="cabecalho.jsp"/>
<!--  Cria lista  -->
<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO"/>
	Utilizando o IF do JSTL	
	<table border="1">
		<!-- for -->
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}">			
			<tr>
				<td>${contato.id}</td>
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
				<!-- <td>${contato.dataNascimento.time}</td> -->
				<!-- Formatando o dia com JSTL -->
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
			</tr>	
		</c:forEach>
	</table>
	<br/>
	<!-- Utilizando o choose do JSTL -->
	Utilizando o CHOOSE do JSTL
	<table border="1">
		<!-- for -->
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}">			
			<tr>
				<td>${contato.id}</td>
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
				<!-- <td>${contato.dataNascimento.time}</td> -->
				<!-- Formatando o dia com JSTL -->
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
			</tr>	
		</c:forEach>
	</table>
	<br />
	<!-- Utilizando o Displaytag -->
	Utilizando o Displaytag
	<%-- request.setAttribute( "lista", dao.getLista() ); --%>
	<c:set var="lista" scope="session" value="${dao.lista}"/>
	<display:table name="lista">		
		<display:column property="id" />
		<display:column property="nome" />
	  	<display:column property="email" />
	  	<display:column property="endereco" />
	  	<display:column property="dataNascimento" title="Data Nascimento"/>
	</display:table>

<c:import url="rodape.jsp"/>