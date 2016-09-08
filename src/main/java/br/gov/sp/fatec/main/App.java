package br.gov.sp.fatec.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.config.DIConfig;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.MovimentacaoService;
import br.gov.sp.fatec.service.MunicipioService;
import br.gov.sp.fatec.service.VeiculoService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ){
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
    	
    	MunicipioService persistenceMunicipio = (MunicipioService) context.getBean(MunicipioService.class);
    	Municipio muni = persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.JACAREI);
    	System.out.println(muni.getNome());
    	
    	ClienteService persistenceCliente = (ClienteService) context.getBean(ClienteService.class);
    	Cliente cliente = persistenceCliente.buscarClienteCpf("36578909810");
    	System.out.println(cliente.getNome());
    	
    	VeiculoService persistenceVeiculo = (VeiculoService) context.getBean(VeiculoService.class);
    	Veiculo veiculo = persistenceVeiculo.buscarVeiculo("DBZ-1101");
    	System.out.println(veiculo.getModelo());
    	
    	MovimentacaoService persistenceMovimentacao = (MovimentacaoService) context.getBean(MovimentacaoService.class);
    	List<Movimentacao> movimentacoes = persistenceMovimentacao.buscarPorPlaca("DBZ-1101");
    	for(Movimentacao m: movimentacoes){
    		System.out.println(m.getData_hora_entrada());
    	}
    	
    	persistenceMovimentacao.fechar();
    	persistenceVeiculo.fechar();
    	persistenceCliente.fechar();
    	persistenceMunicipio.fechar();
    	context.close();
    }
}
