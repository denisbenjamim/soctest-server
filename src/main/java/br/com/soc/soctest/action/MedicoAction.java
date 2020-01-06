package br.com.soc.soctest.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.service.MedicoService;

public class MedicoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Medico medicoBean;
	private MedicoService service;
	
	public MedicoAction() {
		this.medicoBean = new Medico();
		this.service = new MedicoService();
	}
	
	
	@Override
	public String execute() {	
		System.err.println("execute");
		service.save(medicoBean);
		return SUCCESS;
		
	}
	
	public String cadastrar() {	
		System.err.println("cadastrar");
		this.medicoBean = new Medico();
		return INPUT;
	}
	
	public String editar() {	
		System.err.println("editar");
		medicoBean = service.find(medicoBean.getCodigo());
		return INPUT;
	}
	
	public String excluir() {	
		System.err.println("excluir");
		service.remove(medicoBean.getCodigo());
		medicoBean = new Medico();
		return "REDIRECIONAR";
	}
	
	public String listar() {
		return SUCCESS;
	}
	
	
	public List<Medico> getMedicos(){
		return service.findOrderByName();
	}
	
	public void setService(MedicoService service) {
		this.service = service;
	}	
	
	public void setCodigo(Long codigo) {
		this.medicoBean.setCodigo(codigo); 
	}
	
	public Long getCodigo() {
		return medicoBean.getCodigo();
	}	
	
	public Medico getMedicoBean() {
		return medicoBean;
	}

	public void setMedicoBean(Medico medicoBean) {
		this.medicoBean = medicoBean;
	}
}
