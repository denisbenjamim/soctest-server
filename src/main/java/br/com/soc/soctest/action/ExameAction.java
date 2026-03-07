package br.com.soc.soctest.action;

import java.util.List;
import br.com.soc.soctest.model.Exame;
import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.service.ExameService;
import br.com.soc.soctest.service.MedicoService;
import br.com.soc.soctest.service.PacienteService;

public class ExameAction extends org.apache.struts2.ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Exame exameBean;
	
	private Long codigo;
	
	private ExameService service;
	
	@Override
	public void validate() {
		
		if(exameBean!=null) {
			
			if(exameBean.getPaciente().getCodigo()==null) {
				addFieldError("exameBean.paciente.codigo", "Selecione um paciente");
			}
			if(exameBean.getSolicitante().getCodigo()==null) {
				addFieldError("exameBean.solicitante.codigo", "Selecione um Medico");
			}
			if(exameBean.getDescricao().isEmpty()) {
				addFieldError("exameBean.descricao", "Inform o nome do exame");
			}
			if(exameBean.getDescricao().isEmpty()) {
				addFieldError("exameBean.resultado", "Deve ser informado o resultado detalhado");
			}
			if(exameBean.getEmissao()==null) {
				addFieldError("exameBean.emissao", "Informe a data para Emissão");
			}
			if(exameBean.getPrevisaoEntrega()==null) {
				addFieldError("exameBean.previsaoEntrega", "Informe a data para Retirada");
			}
		}
		
		
	}
	
	
	public ExameAction() {		
		this.service = new ExameService();		
	}	
	
	@Override
	public String execute() {		
		service.save(exameBean);
		return SUCCESS;	
	}
	
	public String cadastrar() {	
		return INPUT;
	}
	
	public String editar() {
		exameBean = service.find(codigo);
		return INPUT;
	}
	
	public String excluir() {
		service.remove(codigo);		
		return "REDIRECIONAR";
	}
	
	public String listar() {
		return SUCCESS;
	}
	
	public List<Exame> getExames(){
		return service.findOrderByName();
	}
	
	public List<Paciente> getPacientes(){
		PacienteService pacienteService = new PacienteService();
		return pacienteService.findOrderByName();
	}
		
	public List<Medico> getMedicos(){
		return new MedicoService().findOrderByName();
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
