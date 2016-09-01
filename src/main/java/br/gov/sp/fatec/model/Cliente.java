package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id_cliente;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_municipio", nullable = false)
	private Municipio municipio;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "cpf", unique = true, length = 14, nullable = false)
	private String cpf;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Veiculo> veiculos;
	
	public Cliente(){}
	
	public Cliente(String nome, String cpf, Municipio municipio) {
		this.nome = nome;
		this.cpf = cpf;
		this.municipio = municipio;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
