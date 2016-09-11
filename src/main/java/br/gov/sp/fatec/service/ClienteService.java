package br.gov.sp.fatec.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.PersistenceServiceImpl;

@Component("clienteService")
public class ClienteService extends PersistenceServiceImpl {

	public Cliente buscarClienteCpf(String cpf) {
		 
		String queryText = "select c from Cliente c where c.cpf = :cpf";
		Query query = getManager().createQuery(queryText);
		query.setParameter("cpf", cpf);
		return (Cliente)query.getSingleResult();
	}
	
	public List<Veiculo> buscarListaVeiculo() {
		String queryText = "select v from Veiculo v ";
		Query query = getManager().createQuery(queryText);
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculosLista = query.getResultList(); 
		return veiculosLista;
	}

}
