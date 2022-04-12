package strikebaza.strikebaza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import strikebaza.strikebaza.form.EmailForm;
import strikebaza.strikebaza.form.LoginForm;
import strikebaza.strikebaza.form.RegForm;
import strikebaza.strikebaza.service.UserService;

@Controller
public class IndexController {
	 @Autowired
	    private UserService uService;
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showF(Model model) {
		
		model.addAttribute("users", uService.getAllUsers()); 
		model.addAttribute("indexForm");
		return "indexForm";
	}

	@RequestMapping(value = "indexForm.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String showForm(String input, Model model) {
		switch (input) {
		case "reg":
			RegForm regform = new RegForm();
			model.addAttribute("regform", regform);
			return "regform";
		case "login":
			EmailForm emailForm=new EmailForm();
			LoginForm loginForm = new LoginForm();
			model.addAttribute("loginform", loginForm);
			model.addAttribute("emailForm", emailForm);
			return "loginform";

		default:
			return "indexForm";
		}
	}
}