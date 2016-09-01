package br.gov.sp.fatec.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceServiceImpl implements PersistenceService {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("estacionamento");
	private final EntityManager manager = factory.createEntityManager(); 
	
	protected EntityManager getManager() {
		return manager;
	}
	
	@Override
	public void salvar(Object object) {
		
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit(); 

	}

	@Override
	public void atualizar(Object object) {

		manager.getTransaction().begin();
		manager.merge(object);
		manager.getTransaction().commit(); 

	}

	@Override
	public void deletar(Object object) {
		
		manager.getTransaction().begin();
		manager.remove(object);
		manager.getTransaction().commit();
		
	}
	
	@Override
	public void fechar() {
		manager.close();
		factory.close(); 
	}

}
