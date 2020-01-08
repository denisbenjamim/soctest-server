package br.com.soc.soctest.action;

import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.model.Sexo;
import br.com.soc.soctest.service.PacienteService;
import lombok.Getter;
import lombok.Setter;

public class PacienteAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Paciente pacienteBean;
	
	@Getter
	private PacienteService service;
	
	@Getter @Setter
	private Long codigo;
	
	public PacienteAction() {
		this.service = new PacienteService();
	}
	@Override
	public void validate() {
		
		if(pacienteBean!=null) {
			
			if(pacienteBean.getSexo()==null) {
				addFieldError("pacienteBean.sexo", "Selecione o Genero");
			}
			
			if(pacienteBean.getNome().isEmpty()) {
				addFieldError("pacienteBean.nome", "Informe o nome do paciente");
			}
			if(pacienteBean.getSobrenome().isEmpty()) {
				addFieldError("pacienteBean.sobrenome", "Informe o sobrenome do paciente");
			}
			if(pacienteBean.getNascimento()==null) {
				addFieldError("pacienteBean.nascimento", "Informe a data de nascimento");
			}
			if(pacienteBean.getCPF().isEmpty()) {
				addFieldError("pacienteBean.CPF", "Informe o CPF do paciente");
			}
			if(pacienteBean.getRG().isEmpty()) {
				addFieldError("pacienteBean.RG", "Informe o RG do paciente");
			}
			
		}
		
		
	}
	
	@Override
	public String execute() {			
		service.save(pacienteBean);
		return SUCCESS;
		
	}
	
	public String cadastrar() {	
		return INPUT;
	}
	
	public String editar() {	
		pacienteBean = service.find(codigo);
		return INPUT;
	}
	
	public String excluir() {	
		service.remove(codigo);
		return "REDIRECIONAR";
	}
	
	public String listar() {
		return SUCCESS;
	}
	public List<Sexo> getGeneros(){
		return Arrays.asList(Sexo.values());
	}
	
	public List<Paciente> getPacientes(){
		return service.findOrderByName();
	}
	

}
