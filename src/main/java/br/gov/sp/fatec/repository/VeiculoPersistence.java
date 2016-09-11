package br.gov.sp.fatec.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.VeiculoService;

@Component
public class VeiculoPersistence {
	
	@Autowired
	@Qualifier("veiculoService")
	private VeiculoService service;

	public List<Veiculo> buscarVeiculosCpf(final String cpf) {
		try {
			return service.buscarVeiculosCpf(cpf);
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

	public Veiculo buscarVeiculo(String placa) {
		try {
			return service.buscarVeiculo(placa);
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

	public void salvarVeiculos(Veiculo veiculo) {
		try {
			service.salvar(veiculo);
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

	public void excluirVeiculo(Veiculo veiculo) {
		try {
			service.deletar(veiculo);
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
	
	public void alterarVeiculo(Veiculo veiculo) {
		try {
			service.atualizar(veiculo);
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
