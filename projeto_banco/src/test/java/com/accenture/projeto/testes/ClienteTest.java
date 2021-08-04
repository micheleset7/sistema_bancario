package com.accenture.projeto.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.accenture.projeto.entity.Cliente;

class ClienteTest {
	
	Cliente cliente = new Cliente();
	
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testarClienteNome() {
		
		String clienteNome = "Mark";
		assertNull(cliente.getClienteNome());
		cliente.setClienteNome("Mark");;
		assertEquals(clienteNome,cliente.getClienteNome());
		
	}
	
	//Teste com sucesso
	
	@Test
	public void testarClienteCPF() {
		
		assertTrue(cliente.getClienteCPF()==null);
	}
	
	@Test
	public void testarClienteFone() {
		
		String clienteFone= "(31)9999-1488";
		assertNull(cliente.getClienteFone());
		cliente.setClienteFone("(31)9999-1488");;
		assertEquals(clienteFone,cliente.getClienteFone());
		
	}
	
	//TESTE SEM SUCESSO
	
	/*
	@Test
	public void testarClienteNome() {
		
		String clienteNome = "Mark";
		assertNull(cliente.getClienteNome());
		cliente.setClienteNome("Mrk");;
		assertEquals(clienteNome,cliente.getClienteNome());
		
	}
	
	@Test
	public void testarClienteCPF() {
		
		assertTrue(cliente.getClienteCPF()!=null);
		
	}
	
	
	@Test
	public void testarClienteFone() {
		
		String clienteFone= "(31)999-1488";
		assertNull(cliente.getClienteFone());
		cliente.setClienteFone("(31)9999-1488");;
		assertEquals(clienteFone,cliente.getClienteFone());
		
	}
	
	*/

}
