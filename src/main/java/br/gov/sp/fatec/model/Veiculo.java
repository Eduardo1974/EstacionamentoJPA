package br.gov.sp.fatec.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO") 
public class Veiculo {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
	private Integer id_veiculo;
	
	@Column(name = "placa", unique=true, length = 9, nullable = false)
	private String placa;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "marca",  length = 50, nullable = false)
	private Marca marca;
	
	@Column(name = "modelo",  length = 50, nullable = false)
	private String modelo;
	
	@Column(name = "categoria", length = 50, nullable = false)
	private String categoria;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_cliente", nullable = true)
	private Cliente cliente;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo")
	private List<Movimentacao> movimentacao;

	public Veiculo(){}
	
	public Veiculo(String placa, Marca marca, String modelo, String categoria, Cliente cliente) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.categoria = categoria;
		this.cliente = cliente;
	}

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public Marca getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Movimentacao> getMovimentacao() {
		return Collections.unmodifiableList(movimentacao);
	}
	
	public void alterarCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
