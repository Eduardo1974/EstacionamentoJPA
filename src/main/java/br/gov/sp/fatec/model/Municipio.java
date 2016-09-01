package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "municipio") 
public class Municipio {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
	private Integer id_municipio;
	
	@Column(name = "nome",  length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private DescricaoMunicipio nome;
	
	@Column(name = "estado",  length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private Estado estado;
	

	public Municipio() { }
	
	public Municipio(DescricaoMunicipio nome) {
		this.nome = nome;
		this.estado = nome.getEstado();
	}
	
	public Integer getId_municipio() {
		return id_municipio;
	}
	public DescricaoMunicipio getNome() {
		return nome;
	}
	public Estado getEstado() {
		return estado;
	}

	public void setNome(DescricaoMunicipio nome) {
		this.nome = nome;
		this.estado = nome.getEstado();
	}

	
}
