package br.gov.sp.fatec;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.service.MunicipioService;


/**
 * Unit test for simple App.
 */
public class MunicipioTest {
   
	private final MunicipioService persistenceMunicipio = new MunicipioService();

	@Test
	public void cadastrarCidade() {
		Municipio muni = new Municipio(DescricaoMunicipio.JACAREI);
		persistenceMunicipio.salvar(muni);
		persistenceMunicipio.fechar();
		Assert.assertEquals(new Integer("5"), muni.getId_municipio());
	}
	
	@Test
	public void consultarMunicipio() {
    	Municipio muni = persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.SJC);
    	persistenceMunicipio.fechar();
    	Assert.assertEquals(DescricaoMunicipio.SJC, muni.getNome());
	}
	
	@Test
	public void deletarMunicipio() {
		Municipio muni = persistenceMunicipio.buscarMunicipioPorId(new Integer("5"));
		persistenceMunicipio.deletar(muni);
		Assert.assertNull(persistenceMunicipio.buscarMunicipioPorId(new Integer("5")));
		persistenceMunicipio.fechar();
	}
	
	@Test
	public void consultarListaMunicipio() {
		List<Municipio> listaMunicipio = persistenceMunicipio.buscarListaMunicipio();
		persistenceMunicipio.fechar();
		Assert.assertEquals(4, listaMunicipio.size());
	}

	@Test
	public void atualizarMunicipio() {
		Municipio muni = persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.CACAPAVA);
		muni.setNome(DescricaoMunicipio.JACAREI);
		persistenceMunicipio.atualizar(muni);
		Assert.assertEquals(DescricaoMunicipio.JACAREI, persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.JACAREI).getNome());
		persistenceMunicipio.fechar();
	}
	
}
