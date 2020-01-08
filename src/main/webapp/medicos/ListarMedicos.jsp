<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SOCTest - Lista Medicos</title>
<link
	href="<s:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>"
	rel="stylesheet">
</head>
<body class="container">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark ">
	
		<a class="navbar-brand" href="index.action"><h3>SOCTEST - Lista Medicos</h3></a>
		 
		<div class="collapse navbar-collapse flex-row-reverse" id="navbarNavDropdown">
			<ul class="navbar-nav p-2">
				<li class="nav-item dropdown">
				</li>
				<li class="nav-item dropdown mr-2">
					<a	class="nav-link dropdown-toggle btn btn-outline-secondary text-white " 
						href="#"
						id="navbarDropdownMenuLink" 
						role="button" 
						data-toggle="dropdown"
						aria-haspopup="true" 
						aria-expanded="false"
						style="width: 130px;"
						><b>CADASTROS</b> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<s:a class="dropdown-item" action="cadastrarExame">Exame</s:a>
						<s:a class="dropdown-item" action="cadastrarMedico">Medico</s:a>
						<s:a class="dropdown-item" action="cadastrarPaciente">Paciente</s:a>
					</div>
				</li>
					<li class="nav-item dropdown">
					<a	class="nav-link dropdown-toggle btn btn-outline-secondary text-white" 
						href="#"
						id="navbarDropdownMenurRegistros" 
						role="button" 
						data-toggle="dropdown"
						aria-haspopup="true" 
						aria-expanded="false"
						style="width: 130px;"
						><b>REGISTROS</b></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenurRegistros">
						<s:a class="dropdown-item" action="listarExame">Exame</s:a>
						<s:a class="dropdown-item" action="listarMedico">Medico</s:a>
						<s:a class="dropdown-item" action="listarPaciente">Paciente</s:a>
					</div>
				</li>
				
			</ul>
		</div>
	</nav>
<div class="bg-dark">
	<table class="table table-striped table-dark" style="height:85vh;">
		<thead>
			<tr>
				<th scope="col" class="text-center">ID</th>
				<th scope="col">Nome</th>
				<th scope="col" class="text-center">CRM</th>				
				<th scope="col"/>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="medicos">	
				<tr>
					<th scope="row" class="align-middle text-center"><s:property value="codigo" /></th>
					<td class="align-middle"><s:property value="nome+' '+sobrenome" /></td>
					<td class="align-middle text-center"><s:property value="CRM" /></td>
					
					<td class="text-right">
						<s:url action="editarMedico" var="editar">
							<s:param name="codigo" value="codigo"></s:param>
						</s:url>
						<s:a href="%{editar}" class="btn btn-warning mr-1" style="width: 75px;" >Editar</s:a>					
					
						<s:url action="excluirMedico" var="excluir">
							<s:param name="codigo" value="codigo"></s:param>
						</s:url>
						<s:a href="%{excluir}" class="btn btn-danger " style="width: 75px;" >Excluir</s:a>					
					</td>
				</tr>
			</s:iterator>
		</tbody>
		<tfoot >
			<tr class="table-dark">
				<td colspan="9">
					<s:a  cssClass="btn btn-success" action="cadastrarMedico">Novo Medico</s:a>	
				</td>
			</tr>
		</tfoot>
	</table>
	</div>
	<footer>
		<script
			src="<s:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"
			type="text/javascript"></script>
		<script
			src="<s:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"/>"
			type="text/javascript"></script>
	</footer>
</body>
</html>