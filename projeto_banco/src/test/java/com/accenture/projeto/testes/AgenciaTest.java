package com.accenture.projeto.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import com.accenture.projeto.entity.Agencia;

@SpringBootTest
class AgenciaTest {
	
	Agencia ag = new Agencia();
	
	
	void contextLoads() {
	}
	
	//Testes com sucesso
	/*
	@Test
	public void testarAgenciaNome() {
		
		String nomeAgencia = "Agencia02";
		assertNull(ag.getNomeAgencia());
		ag.setNomeAgencia("Agencia02");
		assertEquals(nomeAgencia,ag.getNomeAgencia());
		
	}
	
	@Test
	public void testarNumeroAgencia() {
		
		String enderecoAgencia = "Rua sambalelê";
		assertNull(ag.getEndereco());
		ag.setEndereco("Rua sambalelê");
		assertEquals(enderecoAgencia,ag.getEndereco());
	}
	
	@Test
	public void testarTelefone() {
		
		String telefoneAgencia = "(31)8888-4444";
		assertNull(ag.getTelefone());
		ag.setTelefone("(31)8888-4444");
		assertEquals(telefoneAgencia,ag.getTelefone());

	}
	*/
	
	//Testes  sem sucesso
	
	
	@Test
	public void testarAgenciaNome() {
		
		String nomeAgencia = "Agencia01";
		assertNull(ag.getNomeAgencia());
		ag.setNomeAgencia("Agencia02");
		assertEquals(nomeAgencia,ag.getNomeAgencia());
		
	}
	
	@Test
	public void testarNumeroAgencia() {
		
		String enderecoAgencia = "Rua sambalelê";
		assertNull(ag.getEndereco());
		ag.setEndereco("Rua sambalel");
		assertEquals(enderecoAgencia,ag.getEndereco());
	}
	
	@Test
	public void testarTelefone() {
		
		String telefoneAgencia = "(31)8881-4444";
		assertNull(ag.getTelefone());
		ag.setTelefone("(31)8888-4444");
		assertEquals(telefoneAgencia,ag.getTelefone());

	}
	
	

}
