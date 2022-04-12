package strikebaza.strikebaza.controllers;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.repository.UserRepository;




@Controller

public class UploadController {
	private static String UPLOADED_FOLDER = "C:\\Users\\DELL\\eclipse-workspace\\strikebaza\\strikebaza\\src\\main\\webapp\\webres\\img\\";
	@Autowired
    private UserRepository userRrepo;
	
	@PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, HttpSession session) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "loginsuccess";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
      User user=(User)session.getAttribute("user");
      user.setImgUrl(file.getOriginalFilename());
      userRrepo.save(user);
      if (user.getRole().equals("organizer")) {
      	
          return "loginsuccess";
      }
      return "loginPlayer";
     
    }

}
