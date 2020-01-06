<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  %>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SOCTest - Lista de Exames</title>
<s:head></s:head>
</head>
<body>
	<header>
		<h3>Lista de Exames</h3>
	</header>
	<nav>
		<ul >
			<li>Cadastros
				<ul> 
					<li><s:a action="cadastrarExame">Exame</s:a></li>
					<li><s:a action="cadastrarMedico">Medico</s:a></li>
					<li><s:a action="cadastrarPaciente">Paciente</s:a></li>
				</ul>
			</li>
			<li>Consultas
				<ul> 
					<li><s:a action="listarExame">Exames</s:a></li>
					<li><s:a action="listarMedico">Medicos</s:a></li>
					<li><s:a action="listarPaciente">Pacientes</s:a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<table style="width: 98vw;">
		<thead>
			<tr>
				<th>Codigo Exame</th>
				<th>Exame</th>
				<th>Paciente</th>
				<th>Medico</th>
				<th>Emissão</th>
				<th>Previsao Entrega</th>
				<th>Descrição</th>
				
				<th colspan="2">OPÇÕES</th>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="exames">	
				<tr>
					<td><s:property value="codigo" /></td>
					<td><s:property value="descricao" /></td>
					
					<td><s:property value="paciente.nome+' '+paciente.sobrenome" /></td>
					<td><s:property value="solicitante.nome+' '+solicitante.sobrenome" /></td>
					<td><s:date name="emissao" format="dd/MM/yyy"  /></td>
					<td><s:date name="previsaoEntrega" format="dd/MM/yyy"  /></td>
					<td><s:property value="resultado" /></td>
					
					
					<td>
						<s:url action="editarExame" var="editar">
							<s:param name="codigo" value="codigo"></s:param>
						</s:url>
						<s:a href="%{editar}" >Editar</s:a>					
					</td>
					<td>
						<s:url action="excluirExame" var="excluir">
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
					<s:a action="cadastrarExame">Novo Exame</s:a>	
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>