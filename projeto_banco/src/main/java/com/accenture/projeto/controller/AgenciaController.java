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

import com.accenture.projeto.entity.Agencia;
import com.accenture.projeto.entity.Conta;
import com.accenture.projeto.repository.AgenciaRepository;

@RestController
public class AgenciaController {

	@Autowired
	private AgenciaRepository agenciaRepositorio;
	
	
	@RequestMapping(value = "/agencia", method = RequestMethod.GET)
	public List<Agencia> Get() {
		return agenciaRepositorio.findAll();
	}

	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agencia> GetById(@PathVariable(value = "id") int id) {
		
		Optional<Agencia> agencia = agenciaRepositorio.findById(id);
		if (agencia.isPresent())
			return new ResponseEntity<Agencia>(agencia.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/agencia", method = RequestMethod.POST)
	public Agencia Post(@Valid @RequestBody Agencia agencia) {
		return agenciaRepositorio.save(agencia);
	}

	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Agencia> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Agencia newAgencia) {
		
		Optional<Agencia> oldAgencia = agenciaRepositorio.findById(id);
		
		if (oldAgencia.isPresent()) {
			
			Agencia agencia = oldAgencia.get();
			agencia.setNomeAgencia(newAgencia.getNomeAgencia());
			agenciaRepositorio.save(agencia);
			return new ResponseEntity<Agencia>(agencia, HttpStatus.OK);
			
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/agencia/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id) {
		
		Optional<Agencia> agencia = agenciaRepositorio.findById(id);
		
		if (agencia.isPresent()) {
			agenciaRepositorio.delete(agencia.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
