<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SOCTest - Cadastro Paciente</title>
    <link
	href="<s:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>"
	rel="stylesheet">
  </head>
  <body  class="container">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark ">
	
		<s:a class="navbar-brand" href="index.action"><h3>SOCTest - Cadastro Paciente</h3></s:a>
		 
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
						<s:a cssClass="dropdown-item" action="listarExame">Exame</s:a>
						<s:a cssClass="dropdown-item" action="listarMedico">Medico</s:a>
						<s:a cssClass="dropdown-item" action="listarPaciente">Paciente</s:a>
					</div>
				</li>
				
			</ul>
		</div>
	</nav>
<div style="background-color: 	#42949F;">
 	<s:form action="Paciente" theme="bootstrap" style="height:85vh;" cssClass=" pt-2 pl-3 pb-2 text-white bg-dark  col-sm-10 offset-sm-1">
     <div class="form-group row">
 	 	<div class="offset-sm-2 col-sm-2">
      		<s:textfield key="pacienteBean.codigo" readonly="true"/>
      	</div>
      	<div class="offset-sm-2 col-sm-3">
      		<s:textfield key="pacienteBean.nascimento" 
      				value="%{getText('format.date',{pacienteBean.nascimento})}"
      				type="date"  />
      	</div>
      </div>
      <div class="form-group row"> 
      
   	 		<div class="offset-sm-2 col-sm-4">     
     			 <s:textfield key="pacienteBean.nome" />
     		 </div>
     
   	 		<div class="col-sm-4"> 
      			<s:textfield key="pacienteBean.sobrenome"	/> 
       		</div>
      </div>
     
      <div class="form-group row"> 
   	 		<div class="offset-sm-2 col-sm-3"> 
      			<s:textfield key="pacienteBean.CPF"   	/>
      		 </div>
      		 <div class="offset-sm-1 col-sm-3">
      		 <s:textfield key="pacienteBean.RG"   	/>
      		 </div>
      </div>
       <div class="form-group row"> 
   	 		<div class="offset-sm-2 col-sm-6 form-check">  
   	 			<label>Genero</label>
				<div class="radio radio-inline ">				
						
					<s:radio cssClass="mr-3" theme="simple" key="pacienteBean.sexo" list="generos"  listValueKey="%{descricao()}"/>
				</div>
      			
      		</div>
      	</div>	
      <div class="form-group row">  
	      <s:submit class="btn btn-success offset-sm-2 col-sm-2  mr-5" value="%{pacienteBean.codigo==null?'Salvar':'Alterar'}" />
	      <s:reset class="btn btn-warning col-sm-2" value="Limpar" />	       
	   </div>
    </s:form>
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