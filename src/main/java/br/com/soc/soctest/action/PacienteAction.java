package br.com.soc.soctest.action;

import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.model.Sexo;
import br.com.soc.soctest.service.PacienteService;

public class PacienteAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paciente pacienteBean;
	private PacienteService service;
	
	public PacienteAction() {
		this.pacienteBean = new Paciente();
		this.service = new PacienteService();
	}
	
	
	@Override
	public String execute() {	
		System.err.println("execute");
		service.save(pacienteBean);
		return SUCCESS;
		
	}
	
	public String cadastrar() {	
		System.err.println("cadastrar");
		this.pacienteBean = new Paciente();
		return INPUT;
	}
	
	public String editar() {	
		System.err.println("editar");
		pacienteBean = service.find(pacienteBean.getCodigo());
		return INPUT;
	}
	
	public String excluir() {	
		System.err.println("excluir");
		service.remove(pacienteBean.getCodigo());
		pacienteBean = new Paciente();
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
	
	
	
	
	public void setService(PacienteService service) {
		this.service = service;
	}	

	
	public void setCodigo(Long codigo) {
		this.pacienteBean.setCodigo(codigo); 
	}
	
	public Long getCodigo() {
		return pacienteBean.getCodigo();
	}	
	
	public Paciente getPacienteBean() {
		return pacienteBean;
	}

	public void setPacienteBean(Paciente pacienteBean) {
		this.pacienteBean = pacienteBean;
	}
}
