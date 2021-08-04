package com.accenture.projeto.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Extrato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idExtrato;
	@Column(nullable=false)
	LocalDateTime dataHoraMovimento;
	
	@Enumerated(value=EnumType.STRING)
	Operacao operacao;
	
	@ManyToOne
	private Conta conta;
	
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Extrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdExtrato() {
		return idExtrato;
	}
	public void setIdExtrato(int idExtrato) {
		this.idExtrato = idExtrato;
	}
	public LocalDateTime getDataHoraMovimento() {
		return dataHoraMovimento;
	}
	public void setDataHoraMovimento(LocalDateTime dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public Operacao getOperacao() {
		return operacao;
	}
	
}
