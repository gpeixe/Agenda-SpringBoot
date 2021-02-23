<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Compromisso</title>
</head>
<body>
<form method=post action=atualizarCompromisso>
Nome:<input type=text name=nome value="${compromisso.nome }" /><br/>
Local:<input type=text name=local value="${compromisso.local }" /><br/>
Data:<input type=date name=data  value="${compromisso.data }" /><br/>
Descricao:<input type=text name=descricao value="${compromisso.descricao }" /><br/>
<input type=hidden name=id  value="${compromisso.id }" /><br/>
<input type=submit value=Atualizar>
</form>
</body>
</html>