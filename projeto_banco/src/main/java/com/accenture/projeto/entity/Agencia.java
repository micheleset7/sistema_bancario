package com.accenture.projeto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Agencia {
	
	public Agencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idAgencia;
	@Column(nullable=false)
	String nomeAgencia;
	@Column(nullable=false)
	String Endereco;
	@Column(nullable=false)
	String telefone;
	
	@OneToMany
	private List<Conta> contas;
	
	
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getNomeAgencia() {
		return nomeAgencia;
	}
	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
