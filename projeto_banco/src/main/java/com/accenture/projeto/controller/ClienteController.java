package com.accenture.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.projeto.entity.Cliente;
import com.accenture.projeto.entity.Conta;
import com.accenture.projeto.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> Get() {
        return clienteRepositorio.findAll();
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") int id)
    {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent())
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@RequestMapping(value = "/cliente", method =  RequestMethod.POST)
    public Cliente Post(@Valid @RequestBody Cliente cliente)
    {
        return clienteRepositorio.save(cliente);
    }*/
    
    @RequestMapping(value = "/cliente", method =  RequestMethod.POST)
    public Cliente Post(@RequestParam("nome") String nome, @RequestParam("cpf") String cpf, @RequestParam("telefone") String telefone,Cliente cliente) {
    	
    	cliente.setClienteNome(nome);
    	try {
			cliente.setClienteCPF(cpf);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
    	cliente.setClienteFone(telefone);
    	
    	return clienteRepositorio.save(cliente);
    }

    @RequestMapping(value = "/cliente/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Cliente newCliente)
    {
        Optional<Cliente> oldCliente = clienteRepositorio.findById(id);
        if(oldCliente.isPresent()){
            Cliente cliente = oldCliente.get();
            cliente.setClienteNome(newCliente.getClienteNome());
            clienteRepositorio.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent()){
            clienteRepositorio.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
    
  
	
}
