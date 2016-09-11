package br.gov.sp.fatec.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.service.MunicipioService;

@Component
public class MunicipioPersistence {
	
	@Autowired
	@Qualifier("municipioService")
	private MunicipioService service;

	public List<Municipio> buscarListaMunicipio() {
		try {
			return service.buscarListaMunicipio();
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

	public Municipio buscarMunicipioPorNome(DescricaoMunicipio desc) {
		try {
			return service.buscarMunicipioPorNome(desc);
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

	public void salvarMunicipio(Municipio municipio) {
		try {
			service.salvar(municipio);
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

	public void excluirMunicipio(Municipio municipio) {
		try {
			service.deletar(municipio);
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
	
	public void alterarMunicipio(Municipio municipio) {
		try {
			service.atualizar(municipio);
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
