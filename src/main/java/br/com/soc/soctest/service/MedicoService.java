package br.com.soc.soctest.service;

import java.util.List;

import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.respository.MedicoRepository;
import br.com.soc.soctest.respository.Repository;

public class MedicoService {

	private Repository<Medico> pacientes;

	public MedicoService() {
		this.pacientes = new MedicoRepository();
	}

	public void save(Medico paciente) {
		if (paciente.getCodigo() == null)
			pacientes.save(paciente);
		else
			pacientes.merge(paciente);
	}
	
	public void remove(Long codigo) {
		pacientes.remove(codigo);
	}

	public Medico find(Long codigo) {		
		return pacientes.find(codigo);
	}
	
	public List<Medico> findOrderByName(){
		return pacientes.findAll();
	}
}
