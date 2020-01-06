<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SOCTest - Cadastro Exame</title>
    <s:head></s:head>
  </head>
  <body>
    <h3>Cadastro Exame</h3>

 	<s:form action="Exame">
      <s:textfield key="exameBean.codigo" />
       <s:select key="exameBean.paciente" name="exameBean.paciente.codigo" list="pacientes"  headerKey="null"  headerValue="Selecione Paciente" listKey="%{codigo}" listValueKey="%{nome+' ' +sobrenome+' - CPF: '+CPF}"/>
       <s:select key="exameBean.solicitante" name="exameBean.solicitante.codigo" list="medicos" headerKey="null"  headerValue="Selecione Especialista" listKey="%{codigo}" listValueKey="%{nome+' ' +sobrenome+' - CRM: '+CRM}"/>
      <s:textfield key="exameBean.emissao" 
      				value="%{getText('format.datet',{exameBean.emissao})}"
      				type="date"  />
      
      <s:textfield key="exameBean.previsaoEntrega" 
      				value="%{getText('format.date',{exameBean.previsaoEntrega})}"
      				type="date"  />
      <s:textfield key="exameBean.descricao"   	/>
      <s:textarea rows="5" cols="30" key="exameBean.resultado"   	/>
      
      
     
      <s:submit value="%{exameBean.codigo==null?'Salvar':'Alterar'}" />
    </s:form>
    <s:a action="listarExame">Voltar Exames</s:a>	
  </body>
</html>