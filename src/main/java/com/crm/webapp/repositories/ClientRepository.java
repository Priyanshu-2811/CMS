package com.crm.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.webapp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public Client findByEmail(String email);

}
