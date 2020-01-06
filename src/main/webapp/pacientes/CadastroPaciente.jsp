<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SOCTest - Cadastro Paciente</title>
    <s:head></s:head>
  </head>
  <body>
    <h3>Cadastro Paciente</h3>

 	<s:form action="Paciente">
      <s:textfield key="pacienteBean.codigo" />
      <s:textfield key="pacienteBean.nome" />
      <s:textfield key="pacienteBean.sobrenome"	/>  
      <s:textfield key="pacienteBean.CPF"   	/>
      <s:textfield key="pacienteBean.RG"   	/>
      <s:textfield key="pacienteBean.nascimento" 
      				value="%{getText('format.date',{pacienteBean.nascimento})}"
      				type="date"  />
      
      <s:radio key="pacienteBean.sexo" list="generos"  listValueKey="%{descricao()}"/>
      <s:submit value="%{pacienteBean.codigo==null?'Salvar':'Alterar'}" />
    </s:form>
    <s:a action="listarPaciente">Voltar Pacientes</s:a>	
  </body>
</html>