<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view locale="#{Sessao.locale}">
	<f:loadBundle basename="meupacote.rotulos" var="msgs"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<h:outputText value="#{msgs.titulo}"></h:outputText>
	
</title>
</head>
<body>
<h:form>
	<h:commandLink id="en" action="null" actionListener="#{Sessao.setLanguage}" value="#{msgs.ingles}"/> |
	<h:commandLink id="pt" action="null" actionListener="#{Sessao.setLanguage}" value="#{msgs.portugues}"/>
	<br/>
	<h:outputText value="#{msgs.nome}"></h:outputText>:&nbsp;
	<h:inputText value="#{MeuBean.nome}"></h:inputText>
	<br/>
	<h:outputText value="#{msgs.email}"></h:outputText>:&nbsp;
	<h:inputText value="#{MeuBean.email}"></h:inputText>
	<br/>
	<h:commandButton value="#{msgs.enviar}"></h:commandButton>
</h:form>
</body>
</f:view>
</html>