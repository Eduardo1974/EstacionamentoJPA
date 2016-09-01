package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMENTACAO") 
public class Movimentacao {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_movimentacao")
	private Integer id_movimentacao;
		
	@Column(name = "data_hora_entrada",  length = 50, nullable = false)
	private Long data_hora_entrada;
	
	@Column(name = "data_hora_saida", length = 50, nullable = false)
	private Long data_hora_saida;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_veiculo", nullable = true)
	private Veiculo veiculo;
	
	public Movimentacao(){}
	
	public Movimentacao(Long data_hora_entrada, Long data_hora_saida, Veiculo veiculo) {
		this.data_hora_entrada = data_hora_entrada;
		this.data_hora_saida = data_hora_saida;
		this.veiculo = veiculo;
	}
	
	public Integer getId_movimentacao() {
		return id_movimentacao;
	}
	
	public Long getData_hora_entrada() {
		return data_hora_entrada;
	}
	
	public Long getData_hora_saida() {
		return data_hora_saida;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

}
