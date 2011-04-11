<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu Primeiro JSF</title>
</head>
<body>
<f:view>
	<h:form id="formulario">
		Digite seu nome:
		<h:inputText id="nome" value="#{MeuBean.nome}" required="true"></h:inputText>
		<h:commandButton action="#{MeuBean.acao}" value="Enviar" id="submit"></h:commandButton>
		</br>
		<h:messages style="color: red"></h:messages>
	</h:form>
</f:view>
</body>
</html>