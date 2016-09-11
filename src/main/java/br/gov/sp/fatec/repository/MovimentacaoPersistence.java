package br.gov.sp.fatec.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.service.MovimentacaoService;

@Component
public class MovimentacaoPersistence {
	
	@Autowired
	@Qualifier("movimentacaoService")
	private MovimentacaoService service;

	public List<Movimentacao> buscarPorPlaca(String placa) {
		try {
			return service.buscarPorPlaca(placa);
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		} catch (HibernateException he) {
			he.printStackTrace();
			return null;
		} finally {
			service.fechar();
		}
	}

	public Movimentacao buscarPorId(int id) {
		try {
			return service.buscarPorId(id);
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		} catch (HibernateException he) {
			he.printStackTrace();
			return null;
		} finally {
			service.fechar();
		}
	}

	public void salvarMovimentacao(Movimentacao movimentacao) {
		try {
			service.salvar(movimentacao);
		} catch (ConstraintViolationException cve) {
			cve.printStackTrace();
			service.desfazerTransacao();
		} catch (HibernateException he) {
			service.desfazerTransacao();
			he.printStackTrace();
		} finally {
			service.fechar();
		}
	}

	public void excluirMovimentacao(Movimentacao movimentacao) {
		try {
			service.deletar(movimentacao);
		} catch (ConstraintViolationException cve) {
			cve.printStackTrace();
			service.desfazerTransacao();
		} catch (HibernateException he) {
			he.printStackTrace();
			service.desfazerTransacao();
		} finally {
			service.fechar();
		}
	}
	
	public void alterarMovimentacao(Movimentacao movimentacao) {
		try {
			service.atualizar(movimentacao);
		} catch (ConstraintViolationException cve) {
			cve.printStackTrace();
			service.desfazerTransacao();
		} catch (HibernateException he) {
			he.printStackTrace();
			service.desfazerTransacao();
		} finally {
			service.fechar();
		}
	}
}
