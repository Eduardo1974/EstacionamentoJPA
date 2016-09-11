package br.gov.sp.fatec.repository;

public interface PersistenceService {
	
	public void salvar(Object object);
	
	public void atualizar(Object object);
	
	public void deletar(Object object);
	
	public void fechar();
	
	public void desfazerTransacao();

}
