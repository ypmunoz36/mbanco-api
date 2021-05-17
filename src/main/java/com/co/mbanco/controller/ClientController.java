package com.co.mbanco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.co.mbanco.model.DAOClient;
import com.co.mbanco.service.ClientService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping({"/clientes"})
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("")
    public List<DAOClient> list() {
        return clientService.listAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DAOClient> get(@PathVariable Integer id) {
        try {
        	DAOClient c = clientService.getCliente(id);
            return new ResponseEntity<DAOClient>(c, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<DAOClient>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody DAOClient cliente) {
    	clientService.saveCliente(cliente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DAOClient cliente, @PathVariable Integer id) {
        try {
        	cliente.setId(id);
        	clientService.saveCliente(cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}