package com.hotel.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope (value = "session")
@Component (value = "loginController")
@ELBeanName(value = "loginController")
public class LoginController {

}
