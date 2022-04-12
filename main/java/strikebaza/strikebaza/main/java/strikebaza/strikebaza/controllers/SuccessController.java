package strikebaza.strikebaza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import strikebaza.strikebaza.entity.User;

import strikebaza.strikebaza.form.UpdateForm;
import strikebaza.strikebaza.service.EventService;
import strikebaza.strikebaza.service.UserService;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@SessionAttributes("user")
public class SuccessController {

	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;

	@RequestMapping(value = "loginsuccess.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView onSubmit(@ModelAttribute("updateForm") UpdateForm updateForm,
			@RequestParam(required = true) String input, User user, Errors errors, HttpSession session)
			throws IllegalArgumentException {
		ModelMap modelMap = new ModelMap();

		updateForm.setLogin(user.getLogin());
		switch (input) {
		case "back":
			modelMap.clear();
			if (session != null) {
				session.invalidate();
			}
			return new ModelAndView("redirect:/");
		case "save":
			try {
			User userNew = uService.getSave(updateForm.getLogin(), updateForm.getLoginNew(),
					updateForm.getPasswordNew(), updateForm.getEmailNew());
			user.setLogin(userNew.getLogin());
			user.setPassword(userNew.getPassword());
			user.setEmail(userNew.getEmail());
			session.setAttribute("user", user);
			updateForm.setLogin(userNew.getLogin());
			}catch (Exception e) {
				errors.rejectValue("login", "Duplicate.userName");	
			}
			break;
		case "add":

			break;
		case "addEvent":

			eService.add(updateForm.getEventName(), updateForm.getEventDate(), updateForm.getEventLocation(),
					updateForm.getPrice(), user.getUserId());
			break;
		case "delete":

			break;
		case "deleteEvent":
			eService.delEvent(updateForm.getEventName());
			break;
		case "upload":

			break;
		case "img":

			break;
		default:
			throw new IllegalArgumentException();
		}
		modelMap.addAttribute("myList", uService.getUser(updateForm.getLogin()).getEvents());
		modelMap.addAttribute("events", eService.getAllEvents());
		return new ModelAndView("loginsuccess", modelMap);
	}

}
