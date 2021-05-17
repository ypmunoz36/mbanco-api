package com.co.mbanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.mbanco.model.DAOClient;


public interface ClientRepository extends JpaRepository<DAOClient, Integer>{

}
