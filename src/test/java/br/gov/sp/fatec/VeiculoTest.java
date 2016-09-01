package br.gov.sp.fatec;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Marca;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.VeiculoService;

public class VeiculoTest {

	private final VeiculoService persistenceVeiculo = new VeiculoService();
	private final ClienteService persistenceCliente = new ClienteService();
	
	@Test
	public void cadastrarVeiculo() {
		
		Cliente cli = persistenceCliente.buscarClienteCpf("36578909810");
		
		Veiculo veiculo = new Veiculo("DBZ-1101", Marca.VOLKSWAGEN, "GOL", "G3", cli);
		persistenceVeiculo.salvar(veiculo);
		Assert.assertEquals(new Integer("4"), veiculo.getId_veiculo());
		persistenceVeiculo.fechar();
	}

	@Test
	public void consultarVeiculosCliente() {
		List<Veiculo> veiculos = persistenceVeiculo.buscarClienteCpf("41520050050");
		Assert.assertEquals(1, veiculos.size());
		persistenceVeiculo.fechar();
	}
	
	@Test
	public void consultarVeiculoCliente() {
		Veiculo veiculo = persistenceVeiculo.buscarVeiculo("DBZ-1101");
		Assert.assertEquals("DBZ-1101",veiculo.getPlaca());
		persistenceVeiculo.fechar();
	}
	
	@Test
	public void alterar() {
		Veiculo veiculo = persistenceVeiculo.buscarVeiculo("DBZ-1101");
		veiculo.alterarCliente(persistenceCliente.buscarClienteCpf("41520050050"));
		persistenceVeiculo.atualizar(veiculo);
		Assert.assertEquals("Inacio", persistenceCliente.buscarClienteCpf("41520050050").getNome());
		persistenceVeiculo.fechar();
	}
	
	@Test(expected = Exception.class)
	public void remover() {
		persistenceVeiculo.deletar(persistenceVeiculo.buscarVeiculo("DBZ-1101"));
		Assert.assertNull(persistenceVeiculo.buscarVeiculo("DBZ-1101"));
		persistenceVeiculo.fechar();
	}

}
