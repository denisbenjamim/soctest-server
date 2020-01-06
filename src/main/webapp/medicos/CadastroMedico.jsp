<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SOCTest - Cadastro Medico</title>
    <s:head></s:head>
  </head>
  <body>
    <h3>Cadastro Medico</h3>

 	<s:form action="Medico">
      <s:textfield key="medicoBean.codigo" />
      <s:textfield key="medicoBean.nome" />
      <s:textfield key="medicoBean.sobrenome"	/>  
      <s:textfield key="medicoBean.CRM"   	/>
   
      <s:submit value="%{medicoBean.codigo==null?'Salvar':'Alterar'}" />
    </s:form>
    <s:a action="listarMedico">Voltar Medicos</s:a>	
  </body>
</html>