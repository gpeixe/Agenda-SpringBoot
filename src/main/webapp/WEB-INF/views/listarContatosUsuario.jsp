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
<h1>Lista de Contatos</h1>
<h2>Bem vindo, ${usuario.nome}! | <a href=home>Início</a> |<a href=logout>Sair</a></h2>

<form method=post action=buscarNome>
	Buscar pelo nome: <input type=text name=nome />
	<input type=submit>
</form>
	<p><a href=listarContatosUsuario>Listar todos</a></p>
	<table border=1>
	<tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Telefone</th>
	</tr>
<c:if test="${contatos != null }">
	<c:forEach var="contato" items="${contatos}">
		<tr>
			<td>${contato.nome}</td>
			<td>${contato.email}</td>
			<td>${contato.telefone}</td>
			<td><a href=removerContato?id=${contato.id}>Remover</a>
			<td><a href=alterarContato?id=${contato.id}>Alterar</a>
		</tr>
		</c:forEach>
</c:if>	
	</table>
<h3><a href=novoContato>Novo Contato</a></h3>
</body>
</html>