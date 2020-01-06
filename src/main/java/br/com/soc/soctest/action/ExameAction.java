package br.com.soc.soctest.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.soc.soctest.model.Exame;
import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.service.ExameService;
import br.com.soc.soctest.service.MedicoService;
import br.com.soc.soctest.service.PacienteService;
import lombok.Getter;
import lombok.Setter;

public class ExameAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter
	private Exame exameBean;
	
	@Getter	 
	private ExameService service;
	
	public ExameAction() {
		this.exameBean = new Exame();
		this.service = new ExameService();
	}	
	
	@Override
	public String execute() {	
		
		service.save(exameBean);
		return SUCCESS;
		
	}
	
	public String cadastrar() {	
		
		this.exameBean = new Exame();
		return INPUT;
	}
	
	public String editar() {	
	
		exameBean = service.find(exameBean.getCodigo());
		return INPUT;
	}
	
	public String excluir() {	
		
		service.remove(exameBean.getCodigo());
		exameBean = new Exame();
		return "REDIRECIONAR";
	}
	
	public String listar() {
		return SUCCESS;
	}
	
	public List<Exame> getExames(){
		return service.findOrderByName();
	}
	
	public List<Paciente> getPacientes(){
		return new PacienteService().findOrderByName();
	}
		
	public List<Medico> getMedicos(){
		return new MedicoService().findOrderByName();
	}
	
	public void setCodigo(Long codigo) {
		this.exameBean.setCodigo(codigo); 
	}
	
	public Long getCodigo() {
		return exameBean.getCodigo();
	}	
	

}
