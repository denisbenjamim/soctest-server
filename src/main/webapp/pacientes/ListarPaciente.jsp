<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SOCTest - Lista de Pacientes</title>
<s:head></s:head>
</head>
<body>
	<h3>Lista de Pacientes</h3>

	<table style="width: 100%;">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>CPF</th>
				<th>RG</th>
				<th>Data Nascimento</th>
				<th>Genero</th>
				<th colspan="2">OPÇÕES</th>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pacientes">	
				<tr>
					<td><s:property value="codigo" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="sobrenome" /></td>
					<td><s:property value="CPF" /></td>
					<td><s:property value="RG" /></td>
					<td><s:date name="nascimento" format="dd/MM/yyy"  /></td>
					<td><s:property value="%{sexo.descricao()}" /></td>
					<td>
						<s:url action="editarPaciente" var="editar">
							<s:param name="codigo" value="codigo"></s:param>
						</s:url>
						<s:a href="%{editar}" >Editar</s:a>					
					</td>
					<td>
						<s:url action="excluirPaciente" var="excluir">
							<s:param name="codigo" value="codigo"></s:param>
						</s:url>
						<s:a href="%{excluir}" >Excluir</s:a>					
					</td>
				</tr>
			</s:iterator>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<s:a action="cadastrarPaciente">Novo Paciente</s:a>	
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>