<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/display" prefix="display2" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<c:import url="cabecalho.jsp"/>
<!--  Cria lista  -->
<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO"/>
	<h3><a href="adiciona-contato.jsp">Adiciona Novo Contato</a></h3><br/>
	Utilizando o IF do JSTL	
	<table border="1">
		<!-- for -->
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
			<td>Altera Item</td>
			<td>Remove Item</td>
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
				<td><a href="mvc?logica=AlteraContatoLogic&paramAltera=popula&id=${contato.id}">Altera</a>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}&nome=${contato.nome}">Remove</a>
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
			<td>Altera Item</td>
			<td>Remove Item</td>
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
				<td><a href="/mvc?logica=RemoveContatoLogic&id=${contato.id}">Remove</a>
			</tr>	
		</c:forEach>
	</table>
	<br />
	<!-- Utilizando o Displaytag -->
	Utilizando o Displaytag
	<%-- request.setAttribute( "lista", dao.getLista() ); --%>
	<c:set var="lista" scope="session" value="${dao.lista}"/>
	<display2:table name="lista">		
		<display2:column property="id" />
		<display2:column property="nome" />
	  	<display2:column property="email" />
	  	<display2:column property="endereco" />
	  	<display2:column property="dataNascimento" />		
	</display2:table>
	<br/><h3>Teste 2</h3><br/>
	<% request.setAttribute( "lista", dao.getLista() ); %>
	<display:table name="lista" class="its">		
		<display:column property="id" />
		<display:column property="nome" />
	  	<display:column property="email" />
	  	<display:column property="endereco" />
	  	<display:column property="dataNascimento" />
	</display:table>
<c:import url="rodape.jsp"/>