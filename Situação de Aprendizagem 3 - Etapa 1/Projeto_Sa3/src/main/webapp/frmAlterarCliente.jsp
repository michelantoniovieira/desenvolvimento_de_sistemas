<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Cliente</title>
<link rel="icon" href="imagens/cadastro_cliente.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Cliente</h1>

	<form name="frmCliente" action=update>
		<table>
			<tr>
				<td><input type="text" name="matricula" id="caixa2"
					placeholder="Matricula" readonly
					value="<%out.print(request.getAttribute("matricula"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome"
					class="caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" placeholder="Endereco"
					class="caixa1"
					value="<%out.print(request.getAttribute("endereco"));%>"></td>
			</tr>
			<tr>
				<td><select name="modalidade" class="caixa1">
						<option value="Pessoa Física">Pessoa Física</option>
						<option value="Pessoa Jurídica">Pessoa Juridica</option>
				</select></td>
			</tr>
		</table>
		<input type="button" class="botaoCadastrar" value="Salvar"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>