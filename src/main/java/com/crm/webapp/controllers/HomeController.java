package com.crm.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping("/")
	 public String home() {
	        return "index"; // This should return the name of your home view (e.g., home.html)
	    }
}
