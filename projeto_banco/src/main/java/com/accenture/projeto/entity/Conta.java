package com.accenture.projeto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContaCorrente;
	@Column(nullable=false)
	private String contaCorrenteAgencia;
	@Column(nullable=false)
	private String contaCorrenteNumero;
	
	private double contaCorrenteSaldo;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToOne
	private Agencia agencia;
	
	@OneToMany
	private List<Extrato> extrato;
	

	public Conta(){
		
	}
	
		
	public String getContaCorrenteAgencia() {
		return contaCorrenteAgencia;
	}

	public void setContaCorrenteAgencia(String contaCorrenteAgencia) {
		this.contaCorrenteAgencia = contaCorrenteAgencia;
	}

	public String getContaCorrenteNumero() {
		return contaCorrenteNumero;
	}

	public void setContaCorrenteNumero(String contaCorrenteNumero) {
		
		if(contaCorrenteNumero!=null) {
			
			this.contaCorrenteNumero = contaCorrenteNumero;
		}else {
			throw new NullPointerException("O numero da conta não pode ser vazio");
		}
	
	}

	public double getContaCorrenteSaldo() {
		return contaCorrenteSaldo;
	}

	public void setContaCorrenteSaldo(double contaCorrenteSaldo) {
		this.contaCorrenteSaldo = contaCorrenteSaldo;
	}

	
	public int getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(int idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
