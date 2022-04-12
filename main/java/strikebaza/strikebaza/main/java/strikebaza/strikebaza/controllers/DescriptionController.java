package strikebaza.strikebaza.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import strikebaza.strikebaza.entity.User;


@Controller
@SessionAttributes("user")
public class DescriptionController {

	@RequestMapping(value = "description", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView onSubmit(@RequestParam("eventName") String eventName,
			 User user, Errors errors, HttpSession session)
			throws IllegalArgumentException {
		ModelMap modelMap = new ModelMap();
		
		System.out.println(eventName);
		
	
		return new ModelAndView("loginsuccess", modelMap);
	}

}
