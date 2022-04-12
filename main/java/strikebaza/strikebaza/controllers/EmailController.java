package strikebaza.strikebaza.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import strikebaza.strikebaza.form.EmailForm;
import strikebaza.strikebaza.form.LoginForm;
import strikebaza.strikebaza.service.SimpleEmailManager;

@Controller
public class EmailController {
	
	 @RequestMapping(value = "emailForm", method = {RequestMethod.GET, RequestMethod.POST})
	    public String processForm(@ModelAttribute("emailForm") @Valid EmailForm emailForm, @ModelAttribute("loginform") LoginForm loginform, Errors errors) throws Exception {
		 SimpleEmailManager sem=new SimpleEmailManager();
		 sem.sendEmail(emailForm);
		 return "loginform";
	 }
}
