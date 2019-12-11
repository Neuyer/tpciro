package com.hotel.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Scope (value = "session")
@Component (value = "homeController")
@ELBeanName(value = "homeController")
@Getter
public class HomeController {
	
	String title = "Bem vindo!";
	
	
}
