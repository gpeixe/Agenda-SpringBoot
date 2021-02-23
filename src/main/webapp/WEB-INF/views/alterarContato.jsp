<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Contato</title>
</head>
<body>
<h1>Altere seu contato!</h1>
<form method=post action=atualizarContato>
Nome:<input type=text name=nome  value="${contato.nome}"/><br/>
Email:<input type=text name=email value="${contato.email}"/><br/>
Telefone:<input type=text name=telefone value="${contato.telefone}"/><br/>
<input type=hidden name=id value="${contato.id}" > 
<input type=submit value=Atualizar>
<p><a href="listarContatosUsuario">Cancelar</a></p>
</form>
</body>
</html>