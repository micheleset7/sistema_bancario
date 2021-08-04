package com.accenture.projeto.controller;

import java.time.LocalDateTime;
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

import com.accenture.projeto.entity.Conta;
import com.accenture.projeto.entity.Extrato;
import com.accenture.projeto.entity.Operacao;
import com.accenture.projeto.repository.ExtratoRepository;

@RestController
public class ExtratoController {
	
	@Autowired
	private ExtratoRepository extratoRepositorio;
	
	@RequestMapping(value = "/extrato", method = RequestMethod.GET)
    public List<Extrato> Get() {
        return extratoRepositorio.findAll();
    }

    @RequestMapping(value = "/extrato/{id}", method = RequestMethod.GET)
    public ResponseEntity<Extrato> GetById(@PathVariable(value = "id") int id)
    {
        Optional<Extrato> extrato = extratoRepositorio.findById(id);
        if(extrato.isPresent())
            return new ResponseEntity<Extrato>(extrato.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/extrato", method =  RequestMethod.POST)
    public Extrato Post(@Valid @RequestBody Extrato extrato)
    {
        return extratoRepositorio.save(extrato);
    }
    
    /*@RequestMapping(value = "/extrato", method =  RequestMethod.POST)
    public Extrato Post(@RequestParam("data") LocalDateTime data, @RequestParam("operacao") Operacao operacao, Extrato extrato) {
    	
    	extrato.setDataHoraMovimento(data);
    	extrato.setOperacao(operacao);
    	return extratoRepositorio.save(extrato);
    }*/

    @RequestMapping(value = "/extrato/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Extrato> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Extrato newExtrato)
    {
        Optional<Extrato> oldExtrato = extratoRepositorio.findById(id);
        if(oldExtrato.isPresent()){
            Extrato extrato = oldExtrato.get();
            extrato.setDataHoraMovimento(newExtrato.getDataHoraMovimento());
            extratoRepositorio.save(extrato);
            return new ResponseEntity<Extrato>(extrato, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/extrato/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
        Optional<Extrato> extrato = extratoRepositorio.findById(id);
        if(extrato.isPresent()){
            extratoRepositorio.delete(extrato.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
