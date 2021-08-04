package com.accenture.projeto.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.projeto.entity.Cliente;
import com.accenture.projeto.entity.Conta;
import com.accenture.projeto.exceptions.ExcecaoTransferencia;
import com.accenture.projeto.repository.ClienteRepository;
import com.accenture.projeto.repository.ContaRepository;
@RestController
public class ContaController {

	@Autowired
    private ContaRepository contaRepositorio;
	
	Conta conta;

	Conta conta2;
	double valorAtual;
	double valorAtual2;
	
	@GetMapping("/depositar")
	String Depositar(@RequestParam("valor")double valor,@RequestParam("id")int id) {
		
		conta = contaRepositorio.getById(id);

		valorAtual = conta.getContaCorrenteSaldo();
		valorAtual += valor;
		conta.setContaCorrenteSaldo(valorAtual);
		contaRepositorio.save(conta);
		return "VALOR DEPOSITADO NA CONTA  : R$ " + valor + 
				"    VALOR ATUAL : R$ "+ conta.getContaCorrenteSaldo();
		
	}
	
	@GetMapping("/sacar")
	String Sacar(@RequestParam("valor")double valor,@RequestParam("id")int id) {
		
		conta = contaRepositorio.getById(id);
		valorAtual = conta.getContaCorrenteSaldo();
		valorAtual-=valor;
		conta.setContaCorrenteSaldo(valorAtual);
		contaRepositorio.save(conta);
		return "VALOR SACADO DA CONTA : R$ " + valor + 
				"        VALOR ATUAL: R$ " + conta.getContaCorrenteSaldo();
		
	}
	
	
	@RequestMapping(value="/transferir",method=RequestMethod.GET)
	String Transferir(@RequestParam("valor")double valor,@RequestParam("id")int id,@RequestParam("id2")int id2) throws ExcecaoTransferencia{
		
		this.conta=contaRepositorio.getById(id);
		this.conta2=contaRepositorio.getById(id2);
		
		if(id2==0) {
			throw new ExcecaoTransferencia();
		}
		
		valorAtual=conta.getContaCorrenteSaldo();
		valorAtual2=conta2.getContaCorrenteSaldo();
		
		valorAtual-=valor;
		valorAtual2+=valor;
		
		//salva conta 1
		this.conta.setContaCorrenteSaldo(valorAtual);
		contaRepositorio.save(conta);
		
		//salva conta 2
		this.conta2.setContaCorrenteSaldo(valorAtual2);
		contaRepositorio.save(conta2);
		
		
		return "O valor transferido foi de: " + valor + " --- " + 
				"Conta 1 R$ : " + contaRepositorio.getById(id).getContaCorrenteSaldo() + 
				"          Conta 2 R$ : " + contaRepositorio.getById(id2).getContaCorrenteSaldo();		
		
	}
	
	@GetMapping(value="/saldo/{id}")
	String exibirSaldo(@PathVariable(value="id")int id) {
		
		Conta conta;
		conta = contaRepositorio.getById(id);
		return "Seu saldo e de: R$: " + conta.getContaCorrenteSaldo();
	}
	
	@GetMapping(value="/info/{id}")
	String exibirInfo(@PathVariable(value="id")int id) {
		
		Conta conta;
		conta = contaRepositorio.getById(id);
		return "Conta Nº : " + conta.getContaCorrenteNumero() + "---    Agencia: "  + conta.getContaCorrenteAgencia(); 
	}
	

	
	 @RequestMapping(value = "/conta", method = RequestMethod.GET)
	    public List<Conta> Get() {
	        return contaRepositorio.findAll();
	    }

	    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Conta> GetById(@PathVariable(value = "id") int id)
	    {
	        Optional<Conta> conta = contaRepositorio.findById(id);
	        if(conta.isPresent())
	            return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	   
	    
	    @RequestMapping(value = "/conta", method =  RequestMethod.POST)
	    public Conta Post(@RequestParam("agencia") String agencia, @RequestParam("numero") String numero, @RequestParam("saldo") double saldo,Conta conta) {
	    	
	    	conta.setContaCorrenteAgencia(agencia);
	    	conta.setContaCorrenteNumero(numero);
			conta.setContaCorrenteSaldo(saldo);
	    	return contaRepositorio.save(conta);
	    }

	    @RequestMapping(value = "/conta/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Conta> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Conta newConta)
	    {
	        Optional<Conta> oldConta = contaRepositorio.findById(id);
	        if(oldConta.isPresent()){
	            Conta conta = oldConta.get();
	            conta.setContaCorrenteNumero(newConta.getContaCorrenteNumero());
	            contaRepositorio.save(conta);
	            return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
	    {
	        Optional<Conta> conta = contaRepositorio.findById(id);
	        if(conta.isPresent()){
	            contaRepositorio.delete(conta.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	
}
