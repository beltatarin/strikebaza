package strikebaza.strikebaza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.form.UpdateForm;
import strikebaza.strikebaza.service.ArchivService;
import strikebaza.strikebaza.service.EventService;
import strikebaza.strikebaza.service.UserService;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@SessionAttributes("user")
public class AdminController {
    @Autowired
    private UserService uService;
    @Autowired
    private EventService eService;
    @Autowired
    private ArchivService aService;

    @RequestMapping(value = "loginAdmin.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView onSubmit(@ModelAttribute("updateForm") UpdateForm updateForm, @RequestParam(required = true) String input,
            User user, HttpSession session) throws IllegalArgumentException {
        ModelMap modelMap = new ModelMap();       
        switch (input) {
            case "back":
                modelMap.clear();
                if (session != null) {
                    session.invalidate();
                }
                return new ModelAndView("redirect:/");
            case "unlockUser":
            case "lockUser":  
            	break;
            case "unlock":
            	uService.unlock(updateForm.getUserName());
            	break;
            case "lock":  
            	uService.lock(updateForm.getUserName()); 
            	break;
            case "delUser":
            	
            case "delEvent": 
            	break;
            case "deleteEvent":
            	eService.delEvent(updateForm.getEventName());
            	break;
            case "deleteUser":
            	uService.delUser(updateForm.getUserName());
            	
            	break;
            default:
                throw new IllegalArgumentException();
        }
        modelMap.addAttribute("users", uService.getAllUsers()); 
        modelMap.addAttribute("events", eService.getAllEvents());
        modelMap.addAttribute("archivs", aService.getAllArchivs());
        return new ModelAndView("loginAdmin", modelMap);
    }
}
