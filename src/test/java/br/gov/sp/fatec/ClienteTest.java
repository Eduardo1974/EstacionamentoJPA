package br.gov.sp.fatec;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.MunicipioService;

public class ClienteTest {

	private final ClienteService persistence = new ClienteService();
	private final MunicipioService persistenceMunicipio = new MunicipioService();

	@Test
	public void cadastrarClienteTest() {

		Municipio muni = persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.SJC);

		Cliente cliente = new Cliente("Thiago", "36578909810", muni);

		persistence.salvar(cliente);

		Assert.assertEquals("Thiago", cliente.getNome());

		persistence.fechar();
	}
	
	@Test
	public void consultarClienteTest() {
		Cliente cliente = persistence.buscarClienteCpf("35134667810");
		Assert.assertEquals("William", cliente.getNome());
		persistence.fechar();
	}
	
	@Test
	public void consultarListaVeiculo() {
		List<Veiculo> listaVeiculo = persistence.buscarListaVeiculo();
		persistence.fechar();
		Assert.assertEquals(3, listaVeiculo.size());
	}
	
	@Test
	public void atualizarClienteTest() {
		
		Cliente cliente = persistence.buscarClienteCpf("42487690852");
		cliente.setNome("Eduardo Di Nizo");
		Assert.assertEquals("Eduardo Di Nizo", persistence.buscarClienteCpf("42487690852").getNome());
		persistence.fechar();
	}
	
	@Test(expected = Exception.class)
	public void deletarClienteTest() {
		persistence.deletar(persistence.buscarClienteCpf("42487690852"));
		Assert.assertNull(persistence.buscarClienteCpf("42487690852"));
		persistence.fechar();
	}

}
