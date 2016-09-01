package br.gov.sp.fatec.main;

import br.gov.sp.fatec.model.DescricaoMunicipio;
import br.gov.sp.fatec.model.Municipio;
import br.gov.sp.fatec.service.MunicipioService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MunicipioService persistenceMunicipio = new MunicipioService();
        
    	Municipio muni = persistenceMunicipio.buscarMunicipioPorNome(DescricaoMunicipio.SJC);
    	
    	System.out.println(muni.getNome());
  
    	
    }
}
