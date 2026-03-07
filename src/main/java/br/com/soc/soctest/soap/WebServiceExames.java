package br.com.soc.soctest.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceExames {
	
	@WebMethod
	public String findExame(Long codigo);
	
	@WebMethod
	public String findAllByPacienteCodigo(Long codigo);	
	
}
