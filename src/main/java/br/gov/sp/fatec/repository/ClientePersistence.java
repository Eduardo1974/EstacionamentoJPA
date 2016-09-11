package br.gov.sp.fatec.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.ClienteService;

@Component
public class ClientePersistence {

	@Autowired
	@Qualifier("clienteService")
	private ClienteService service;

	public Cliente buscarClienteCpf(final String cpf) {
		try {
			return service.buscarClienteCpf(cpf);
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

	public List<Veiculo> buscarListaVeiculo() {
		try {
			return service.buscarListaVeiculo();
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

	public void salvarCliente(Cliente cliente) {
		try {
			service.salvar(cliente);
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

	public void excluirCliente(Cliente cliente) {
		try {
			service.deletar(cliente);
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
	
	public void alterarCliente(Cliente cliente) {
		try {
			service.atualizar(cliente);
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
