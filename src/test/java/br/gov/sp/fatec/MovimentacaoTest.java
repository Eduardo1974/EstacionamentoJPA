package br.gov.sp.fatec;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.MovimentacaoService;
import br.gov.sp.fatec.service.VeiculoService;

public class MovimentacaoTest {
	
	private final MovimentacaoService persistenceMovimentacao = new MovimentacaoService();
	private final VeiculoService persistenceVeiculo = new VeiculoService();

	@Test
	public void cadastrarMovimentacao() {
		
		Veiculo veiculo = persistenceVeiculo.buscarVeiculo("DVZ-6625");
		Movimentacao mov = new Movimentacao(new Date().getTime(), (new Date().getTime() + 500 ), veiculo);
		persistenceMovimentacao.salvar(mov);
		persistenceMovimentacao.fechar();
		Assert.assertEquals(new Integer("3"), mov.getId_movimentacao());
	}

	@Test
	public void consultarMovimentacoesVeiculo() {
		List<Movimentacao> movimentacoes = persistenceMovimentacao.buscarPorPlaca("DBZ-1101");
		persistenceMovimentacao.fechar();
		Assert.assertEquals(1, movimentacoes.size());
	}
	
	@Test
	public void remover() {
		persistenceMovimentacao.deletar(persistenceMovimentacao.buscarPorId(1));
		Assert.assertNull(persistenceMovimentacao.buscarPorId(1));
	}
}
