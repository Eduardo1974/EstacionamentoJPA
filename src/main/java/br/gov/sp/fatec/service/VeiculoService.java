package br.gov.sp.fatec.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.PersistenceServiceImpl;

@Component("veiculoService")
public class VeiculoService extends PersistenceServiceImpl{
	
	public List<Veiculo> buscarVeiculosCpf(String cpf) {
		 
		String queryText = "select v from Veiculo v where v.cliente.cpf = :cpf";
		Query query = getManager().createQuery(queryText);
		query.setParameter("cpf", cpf);
		List<Veiculo> veiculos = query.getResultList(); 
		return veiculos;
	}
	
	public Veiculo buscarVeiculo(String placa) {
		String queryText = "select v from Veiculo v where v.placa = :placa";
    	Query query = getManager().createQuery(queryText);
    	query.setParameter("placa", placa);
    	return (Veiculo)query.getSingleResult();
	}
}
