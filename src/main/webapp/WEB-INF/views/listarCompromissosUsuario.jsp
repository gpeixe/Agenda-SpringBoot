<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatos</title>
</head>
<body>
<h1>Lista de Compromisso</h1>
<h2>Bem vindo, ${usuario.nome}! | <a href=home>Início</a> |<a href=logout>Sair</a></h2>
	<table border=1>
	<tr>
		<th>Nome</th>
		<th>Local</th>
		<th>Data</th>
		<th>Descrição</th>
	</tr>
<c:if test="${compromissos != null }">
	<c:forEach var="compromisso" items="${compromissos}">
		<tr>
			<td>${compromisso.nome}</td>
			<td>${compromisso.local}</td>
			<td>${compromisso.data}</td>
			<td>${compromisso.descricao}</td>
			<td><a href=removerCompromisso?id=${compromisso.id}>Remover</a>
			<td><a href=alterarCompromisso?id=${compromisso.id}>Alterar</a>
		</tr>
		</c:forEach>
</c:if>	
	</table>
<h3><a href=novoCompromisso>Novo Compromisso</a></h3>
</body>
</html>