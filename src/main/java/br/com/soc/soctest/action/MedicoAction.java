package br.com.soc.soctest.action;

import java.util.List;

import org.apache.struts2.ActionSupport;

import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.service.MedicoService;

public class MedicoAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Medico medicoBean;
	
	private Long codigo;	
	
	private MedicoService service;
	
	public MedicoAction() {
		
		this.service = new MedicoService();
	}
	
	@Override
	public void validate() {
		
		if(medicoBean!=null) {
			if(medicoBean.getNome().isEmpty()) {
				addFieldError("medicoBean.nome", "Inform o nome do Medico");
			}
			
			if(medicoBean.getSobrenome().isEmpty()) {
				addFieldError("medicoBean.sobrenome", "Informe sobrenome do Medico");
			}
			
			if(medicoBean.getCRM().isEmpty()) {
				addFieldError("medicoBean.CRM", "Informe CRM do Medico");
			}			
		}	
	}
	
	@Override
	public String execute() {			
		service.save(medicoBean);
		return SUCCESS;		
	}
	
	public String cadastrar() {			
		return INPUT;
	}
	
	public String editar() {		
		medicoBean = service.find(codigo);
		return INPUT;
	}
	
	public String excluir() {		
		service.remove(codigo);		
		return "REDIRECIONAR";
	}
	
	public String listar() {
		return SUCCESS;
	}	
	
	public List<Medico> getMedicos(){
		return service.findOrderByName();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
