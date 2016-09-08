package br.gov.sp.fatec.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Municipio;

@Component("MovimentacaoService")
public class MovimentacaoService extends PersistenceServiceImpl{
	
	public List<Movimentacao> buscarPorPlaca(String placa) {
		 
		String queryText = "select m from Movimentacao m where m.veiculo.placa = :placa";
		Query query = getManager().createQuery(queryText);
		query.setParameter("placa", placa);
		List<Movimentacao> movimentacoes = query.getResultList(); 
		return movimentacoes;
	}
	
	public Movimentacao buscarPorId(int id) {
		return getManager().find(Movimentacao.class, id);
	}
	
	
}
