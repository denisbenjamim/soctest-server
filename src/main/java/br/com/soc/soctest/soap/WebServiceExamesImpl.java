package br.com.soc.soctest.soap;

import java.util.ArrayList;

import javax.jws.WebService;

import br.com.soc.soctest.model.Exame;
import br.com.soc.soctest.service.ExameService;

@WebService(endpointInterface = "br.com.soc.soctest.soap.WebServiceExames" )
public class WebServiceExamesImpl implements WebServiceExames {

	private ExameService service;
	
	public WebServiceExamesImpl() {
		this.service = new ExameService();
	}
	
	@Override
	public String findExame(Long codigo) {		
		return service.find(codigo).toString();
	}

	@Override
	public String findAllByPacienteCodigo(Long codigo) {	
		StringBuilder builder = new StringBuilder();
		service.findByPacienteCodigo(codigo)
		.forEach(exame->{
		
			builder.append(exame.toString());
		});
		
		return builder.toString();
	}

	
	public static void main(String[] args) {
		new WebServiceExamesImpl().findAllByPacienteCodigo(1l);
		
	}
}
