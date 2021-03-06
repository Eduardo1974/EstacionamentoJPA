package br.gov.sp.fatec.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.repository.PersistenceServiceImpl;

@Component("municipioService")
public class MunicipioService extends PersistenceServiceImpl {

	public Municipio buscarMunicipioPorId(Integer id) {
		return getManager().find(Municipio.class, id);
	}
	
	public Municipio buscarMunicipioPorNome(DescricaoMunicipio desc) {
		String queryText = "select m from Municipio m where m.nome = :nome";
    	Query query = getManager().createQuery(queryText);
    	query.setParameter("nome", desc);
    	return (Municipio) query.getSingleResult();
	}
	
	public List<Municipio> buscarListaMunicipio() {
		String queryText = "select m from Municipio m";
		Query query = getManager().createQuery(queryText);
		@SuppressWarnings("unchecked")
		List<Municipio> municipiosLista = query.getResultList(); 
		return municipiosLista;
	}
	
}
