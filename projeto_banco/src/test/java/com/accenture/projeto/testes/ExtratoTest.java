package com.accenture.projeto.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.accenture.projeto.entity.Extrato;

class ExtratoTest {

	Extrato extrato = new Extrato();
	
	void test() {
		fail("Not yet implemented");
	}
	
	//Teste com sucesso
	/*
	@Test
	public void testarDataExtrato() {
		
		String mes = "JULY";
		
		assertEquals(mes,LocalDateTime.now().getMonth().toString());
	}
	
	@Test
	public void testarOperacao() {
		
		String operacao = "SAQUE";
		
		assertEquals(operacao,extrato.getOperacao().SAQUE.name());
	}
	*/
	
	
	//Teste sem sucesso
	@Test
	public void testarDataExtrato() {
		
		String mes = "JULI";
		
		assertEquals(mes,LocalDateTime.now().getMonth().toString());
	}
	
	@Test
	public void testarOperacao() {
		
		String operacao = "SAQU";
		
		assertEquals(operacao,extrato.getOperacao().SAQUE.name());
	}
	
	
	
}
