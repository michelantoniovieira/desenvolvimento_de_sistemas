<%@page import="model.CadastrarClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<CadastrarClienteDTO> lista = (ArrayList<CadastrarClienteDTO>) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Pesquisar Cliente</title>
<link rel="icon" href="imagens/cadastro_cliente.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Pesquisar Clientes</h1>
	<table id="tabela">
		<thead>
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Modalidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++)
			{
			%>
			<tr>
				<td><%=lista.get(i).getMatricula()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEndereco()%></td>
				<td><%=lista.get(i).getModalidade()%></td>
				<td><a href="select?matricula=<%=lista.get(i).getMatricula()%>"
					class="botaoCadastrar">Editar</a> 
					<a href="javascript: confirmar(<%=lista.get(i).getMatricula()%>)" class="botaoCadastrar">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
	<a href="main" class="botaoRetornar">Retornar</a>
</body>
</html>