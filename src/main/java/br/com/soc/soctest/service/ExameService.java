package br.com.soc.soctest.service;

import java.util.List;

import br.com.soc.soctest.model.Exame;
import br.com.soc.soctest.respository.ExameRepository;

public class ExameService {

	private ExameRepository exames;

	public ExameService() {
		this.exames = new ExameRepository();
	}

	public void save(Exame exame) {
		
		if (exame.getCodigo() == null) {
			
			exames.save(exame);
		}else {
			
			exames.merge(exame);
		}
	}
	
	public void remove(Long codigo) {
		exames.remove(codigo);
	}

	public Exame find(Long codigo) {		
		return exames.find(codigo);
	}
	
	public List<Exame> findOrderByName(){
		return exames.findAll();
	}
}
