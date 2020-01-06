package br.com.soc.soctest.service;

import java.util.List;

import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.respository.PacienteRepository;

public class PacienteService {

	private PacienteRepository pacientes;

	public PacienteService() {
		this.pacientes = new PacienteRepository();
	}

	public void save(Paciente paciente) {
		if (paciente.getCodigo() == null)
			pacientes.save(paciente);
		else
			pacientes.merge(paciente);
	}
	
	public void remove(Long codigo) {
		pacientes.remove(codigo);
	}

	public Paciente find(Long codigo) {		
		return pacientes.find(codigo);
	}
	
	public List<Paciente> findOrderByName(){
		return pacientes.findAll();
	}
}
