package strikebaza.strikebaza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.form.RegForm;
import strikebaza.strikebaza.form.UpdateForm;
import strikebaza.strikebaza.service.EventService;
import strikebaza.strikebaza.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;

	@RequestMapping(value = "regform.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String processForm(@ModelAttribute("regform") @Valid RegForm regform,Model model, HttpSession session, Errors errors, String input){
		
			 
			  
		
	switch (input) {
		case "back":
			return ("redirect:/");
		case "add":
			User user=	uService.getUser(regform.getUserName());
			if(user == null) {
			try {
				
			 uService.add(regform.getUserName(), regform.getPassword(), regform.getEmail(), regform.getTelefon(), regform.getRole(),"unlocked","strike4.jpg");

			  }catch (Exception e) {
				  
			  errors.rejectValue("telefon", "Duplicate.phone");
			  return "regform"; }
			}else {
				errors.rejectValue("userName", "Duplicate.userName");
				return "regform";
			}
			}
	
	 model.addAttribute("updateForm", new UpdateForm()); 
	 User user1 = uService.getUser(regform.getUserName());
		session.setAttribute("user", user1);	
	session.setAttribute("events", eService.getAllEvents());
	
	if (regform.getRole().equals("organizer")) {
     	
         return "loginsuccess";
     }
     return "loginPlayer";
	}

}
