package com.accenture.projeto.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.accenture.projeto.entity.Conta;

class ContaTest {
	
	Conta conta = new Conta();
	
	void test() {
		fail("Not yet implemented");
	}
	
	
	//Teste com sucesso
	/*
	@Test
	public void testarContaCorrenteAgencia() {
		
		String contaCorrenteAgencia = "4025";
		assertNull(conta.getContaCorrenteAgencia());
		conta.setContaCorrenteAgencia("4025");
		assertEquals(contaCorrenteAgencia,conta.getContaCorrenteAgencia());
		
	}
	
	@Test
	public void testarContaCorrenteNumero() {
		
		assertTrue(conta.getContaCorrenteNumero()==null);
		
	}*/
	
	
	//Teste sem sucesso
	@Test
	public void testarContaCorrenteAgencia() {
		
		String contaCorrenteAgencia = "4022";
		assertNull(conta.getContaCorrenteAgencia());
		conta.setContaCorrenteAgencia("4025");
		assertEquals(contaCorrenteAgencia,conta.getContaCorrenteAgencia());
		
	}
	
	@Test
	public void testarContaCorrenteNumero() {
		
		assertTrue(conta.getContaCorrenteNumero()!=null);
		
	}
	
	
}
