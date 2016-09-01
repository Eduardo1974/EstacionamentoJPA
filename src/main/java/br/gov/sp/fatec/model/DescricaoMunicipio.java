package br.gov.sp.fatec.model;

public enum DescricaoMunicipio {
	
	SJC("São José dos Campos", Estado.SP),
	TAUBATE("Taubaté", Estado.SP),
	CACAPAVA("Caçapava", Estado.SP),
	JACAREI("Jacareí", Estado.SP);
	
	private final String nome;
	private final Estado estado;
	
	private DescricaoMunicipio(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public String getMunicipio() {
		
		return nome;
		
	}
	
	public String toString() {
		return nome;
	}
}
