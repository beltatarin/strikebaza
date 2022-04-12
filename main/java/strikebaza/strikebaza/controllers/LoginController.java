package strikebaza.strikebaza.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//предоставлет атрибуты, используемые для визуализации представлений.
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import strikebaza.strikebaza.entity.User;

import strikebaza.strikebaza.form.LoginForm;
import strikebaza.strikebaza.form.UpdateForm;
import strikebaza.strikebaza.service.ArchivService;
import strikebaza.strikebaza.service.EventService;
import strikebaza.strikebaza.service.UserService;

@Controller
public class LoginController {
    
    @Autowired
    private UserService uService;
    @Autowired
    private EventService eService;
    @Autowired
    private ArchivService aService;
  
    @RequestMapping(value = "loginform.html", method = {RequestMethod.GET, RequestMethod.POST})
	public String processForm(@ModelAttribute("loginform") @Valid LoginForm loginform,
			Errors errors, HttpSession session, String input) throws Exception {
    	ModelMap modelMap = new ModelMap();
    	if (input.equals("back")) {
    		return ("redirect:/");
		}
        if(loginform.getLogin()==null & loginform.getPassword()==null) {
        	return "loginform";
    	}
        User user = uService.getUser(loginform.getLogin());
		session.setAttribute("user", user);	
    	if (loginform.getLogin()!=null & user == null) {
    		
        	errors.rejectValue("login", "Wrong.userName");
        	return "loginform";
        } else 	if (!user.getPassword().equals(loginform.getPassword())) {
        	errors.rejectValue("password", "Wrong.password");
        	return "loginform";
        }else if(user.getAccess().equals("locked")) {
        	errors.rejectValue("login", "loginForm.lock");
            return "loginform";
        }
        
        UpdateForm updateForm = new UpdateForm();
    	modelMap.addAttribute("updateForm", updateForm);
    	session.setAttribute("users", uService.getAllUsers());
    	session.setAttribute("myList", uService.getUser(user.getLogin()).getEvents());
    	session.setAttribute("events", eService.getAllEvents());
    	session.setAttribute("archivs", aService.getAllArchivs());
        if (user.getRole().equals("admin")) {
			return "loginAdmin";
        }else if (user.getRole().equals("organizer")) {
        	
            return "loginsuccess";
        }
        return "loginPlayer";
        }
        
}