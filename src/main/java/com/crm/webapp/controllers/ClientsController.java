package com.crm.webapp.controllers;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.webapp.models.Client;
import com.crm.webapp.models.ClientDto;
import com.crm.webapp.repositories.ClientRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientsController {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping({"","/"})
	public String getClients(Model model) {
		var clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("clients", clients);
		return "clients/index"; // This should return the name of your clients view (e.g., clients.html)
	}
	
	@GetMapping("/create")
	public String createClient(Model model) {
		ClientDto clientDto = new ClientDto();
		model.addAttribute("clientDto", clientDto);
		
		return "clients/create"; // This should return the name of your create client view (e.g., create-client.html)
	}
	
	@PostMapping("/create")
	public String createClient( @Valid @ModelAttribute ClientDto clientDto,BindingResult result) {
			
		if (clientRepo.findByEmail(clientDto.getEmail()) != null) {
		    result.addError(new FieldError("clientDto", "email", "Email already exists"));
		}
			
		if(result.hasErrors()) {
			return "clients/create"; // Return to the create client view if there are validation errors
		}
		// Save the client to the database
		Client client = new Client();
		client.setFirstName(clientDto.getFirstName());
		client.setLastName(clientDto.getLastName());
		client.setEmail(clientDto.getEmail());
		client.setPhone(clientDto.getPhone());
		client.setAddress(clientDto.getAddress());
		client.setStatus(clientDto.getStatus());
		client.setCreatedAt(LocalDateTime.now());
		
		clientRepo.save(client);
		
		return "redirect:/clients"; // Redirect to the clients list after successful creation
		
	
	}
	
	
	@GetMapping("/edit")
	public String editClient(Model model, @RequestParam int id) {
		Client client = clientRepo.findById(id).orElse(null);
		if (client == null) {
			return "redirect:/clients"; // Redirect if client not found
		}
		
		ClientDto clientDto = new ClientDto();
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setEmail(client.getEmail());
		clientDto.setPhone(client.getPhone());
		clientDto.setAddress(client.getAddress());
		clientDto.setStatus(client.getStatus());
		
		model.addAttribute("client", client);
		model.addAttribute("clientDto", clientDto);
		
		return "clients/edit"; // This should return the name of your edit client view (e.g., edit-client.html)
		
	}
	
	
	@PostMapping("/edit")
	public String editClient(Model model, @RequestParam int id, @Valid @ModelAttribute ClientDto clientDto, BindingResult result) { 
		
		Client client = clientRepo.findById(id).orElse(null);
		if (client == null) {
			return "redirect:/clients"; // Redirect if client not found
		}
		
		model.addAttribute("client", client);
		
		if(result.hasErrors()) {
			return "clients/edit"; // Return to the edit client view if there are validation errors
		}
		
		
		// Update the client in the database
		client.setFirstName(clientDto.getFirstName());
		client.setLastName(clientDto.getLastName());
		client.setEmail(clientDto.getEmail());
		client.setPhone(clientDto.getPhone());
		client.setAddress(clientDto.getAddress());
		client.setStatus(clientDto.getStatus());
		
		try {
			clientRepo.save(client);
		} 
		catch (Exception e) {
			result.addError(new FieldError("clientDto", "email", "Email already exists"));
			return "clients/edit"; // Return to the edit client view if there are validation errors
		}
		
		return "redirect:/clients"; // Redirect to the clients list after successful update
		
	
	}
	
	@GetMapping("/delete")
	public String deleteClient(@RequestParam int id) {
		
		Client client = clientRepo.findById(id).orElse(null);
		if (client != null) {
			clientRepo.delete(client);
		}
		
		return "redirect:/clients"; // Redirect to the clients list after deletion
	}
}
