<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SOCTest - Lista de Pacientes</title>
<link
	href="<s:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>"
	rel="stylesheet">
</head>
<body class="container">
	<nav class="navbar navbar-expand-md navbar-dark bg-dark ">
	
		<a class="navbar-brand" href="index.action"><h3>SOCTEST - Lista Pacientes</h3></a>
		 
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
	<table  class="table table-striped table-dark" style="height:85vh;">
		<thead>
			<tr>
				<th scope="col" class="text-center">ID</th>
				<th scope="col">Nome</th>
				
				<th scope="col" class="text-center">CPF</th>
				
				<th scope="col" class="text-center">Data Nascimento</th>
				<th  scope="col" class="text-center">Genero</th>
				<th/>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pacientes">	
				<tr>
					<th scope="row" class="align-middle text-center"><s:property value="codigo" /></th>
					<td class="align-middle"><s:property value="nome+' '+sobrenome" /></td>
					<td class="align-middle"><s:property value="CPF" /></td>
					<td class="align-middle text-center"><s:date name="nascimento" format="dd/MM/yyy"  /></td>
					<td class="align-middle text-center"><s:property value="%{sexo.descricao()}" /></td>
					<td  class="text-right">
						 <s:url action="editarExame" var="editar">
								<s:param name="codigo" value="codigo"></s:param>
							</s:url>
							<s:a class="btn btn-warning mr-1" style="width: 75px;" href="%{editar}"  >Editar</s:a>
							
							<s:a class="btn btn-danger mr-1" style="width: 75px;" data-codigo="%{codigo}"  data-toggle="modal"	data-target="#confirmaExclusao" >Excluir</s:a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
		<tfoot>
			<tr class="table-dark" >
				<td colspan="9">
					<s:a cssClass="btn btn-success"  action="cadastrarPaciente">Novo Paciente</s:a>	
				</td>
			</tr>
		</tfoot>
	</table>
	</div>
	<div  class="modal fade" id="confirmaExclusao" data-keyboard="false"  
		data-backdrop="static" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		   
		  	
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel" >Confirmação de Exclusão</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          	<span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<span>Deseja excluir o paciente ?</span>
		      </div>
		      <div class="modal-footer">
		       	<a class="btn btn-secondary" data-dismiss="modal">Não</a>
		       
				<s:a id="excluir" url-base="/soctest/excluirPaciente.action?codigo="  class="btn btn-primary" style="width: 75px;"  >Sim</s:a>
						
		      </div>
		    </div>
		    
		  </div>
</div>
	<footer>
		<script
			src="<s:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"
			type="text/javascript"></script>
		<script
			src="<s:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"/>"
			type="text/javascript"></script>
			<script>
		$('#confirmaExclusao').on('show.bs.modal',function(event){
			var source = $(event.relatedTarget);
			let codigo = source.data('codigo');
			var link = $('#excluir');
			
			var action = link.attr('href');
			if(!action.endsWith('=')){
				link.attr('href',link.attr('url-base')+codigo);
			}			
		});
	</script>
	</footer>
</body>
</html>