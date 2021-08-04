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
public class Cliente {
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idCliente;
	@Column(nullable=false)
	String clienteNome;
	@Column(nullable=false)
	String clienteCPF;
	@Column(nullable=false)
	String clienteFone;
	
	
	@OneToMany
	private List<Conta> contas;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		
		if(clienteNome!=null) {
			this.clienteNome = clienteNome;
		}else {
			throw new NullPointerException("O nome não pode estar vazio");
		}
	}
	public String getClienteCPF() {
		return clienteCPF;
	}
	
	public void setClienteCPF(String clienteCPF) throws Exception {
		
		if(clienteCPF.length()>14){
			throw new Exception("Excedeu o limite de caractere");
		}
		this.clienteCPF = clienteCPF;
	}
	
	public String getClienteFone() {
		return clienteFone;
	}
	
	public void setClienteFone(String clienteFone) {
		
		if(clienteFone!=null) {
			this.clienteFone = clienteFone;
		}else {
			throw new NullPointerException("Telefone não pode ser vazio");
		}
		
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	
}
