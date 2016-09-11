package br.gov.sp.fatec.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.config.DIConfig;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Movimentacao;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.ClientePersistence;
import br.gov.sp.fatec.repository.MovimentacaoPersistence;
import br.gov.sp.fatec.repository.MunicipioPersistence;
import br.gov.sp.fatec.repository.VeiculoPersistence;

public class App {

	public static void main( String[] args ){
    	
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
    	
    	ClientePersistence clientePersistence = (ClientePersistence) context.getBean(ClientePersistence.class);
    	Cliente cli = clientePersistence.buscarClienteCpf("36578909810");
    	System.out.println(cli.getNome());
    	
    	VeiculoPersistence veiculoPersistence = (VeiculoPersistence) context.getBean(VeiculoPersistence.class);
    	Veiculo veiculo = veiculoPersistence.buscarVeiculo("DBZ-1101");
    	System.out.println(veiculo.getModelo());
    	
    	MunicipioPersistence municipioPersistence = (MunicipioPersistence) context.getBean(MunicipioPersistence.class);
    	Municipio municipio = municipioPersistence.buscarMunicipioPorNome(DescricaoMunicipio.JACAREI);
    	System.out.println(municipio.getNome());
    	
    	MovimentacaoPersistence movimentacaoPersistence = (MovimentacaoPersistence) context.getBean(MovimentacaoPersistence.class);
    	List<Movimentacao> movimentacao = movimentacaoPersistence.buscarPorPlaca("DBZ-1101");
    	System.out.println(movimentacao.size());
    	
    	context.close();
    }
}
