package com.co.mbanco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.mbanco.model.DAOClient;
import com.co.mbanco.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public List<DAOClient> listAllClients() {
		return clientRepository.findAll();
	}

	public void saveCliente(DAOClient cliente) {
		clientRepository.save(cliente);
	}

	public DAOClient getCliente(Integer id) {
		return clientRepository.findById(id).get();
	}
	
}
