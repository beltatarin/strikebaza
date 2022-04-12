package strikebaza.strikebaza.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strikebaza.strikebaza.entity.Event;
import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.repository.UserRepository;
import strikebaza.strikebaza.repository.UserRepositoryPhone;

@Service
public class UserService {
    @Autowired
    private UserRepository userRrepo;
    @Autowired
    private UserRepositoryPhone userRrepoPhone;
    
    public User getUser(String login) {
        return userRrepo.findByLogin(login);
       
    }
    public User getUserPhone(String phone) {
        return userRrepoPhone.findByPhone(phone);
       
    }

	public User add(String login, String password, String email, String phone, String role, String access, String imgUrl) {
	            User user = new User(login, password, email, phone, role, access, imgUrl);
	            userRrepo.save(user);
	            return user;
		
	}
	
	public String delUser(String login) {
    	Set<User> users = getAllUsers();  	
    	for (User c : users) {
    		 if (c.getLogin().equals(login)) { 
    			 unlock(c.getLogin());
    			 Set<Event> events= c.getEvents();
    			 for (Event e : events) {
                	 c.removeEvent(e);
                     userRrepo.save(c);
                 }
    			 userRrepo.deleteById(c.getUserId());
    			 return "success.deleted";
    		 }
    	}
		return "delete.failure";
    }
	
	public User getSave(String login, String loginNew, String passwordNew, String emailNew) {
		User user=getUser(login);
		user.setLogin(loginNew);
		user.setPassword(passwordNew);
		user.setEmail(emailNew);
		userRrepo.save(user);
		return user;
	}
	
	  public String lock(String login) { User user=getUser(login);
	  if(user.getAccess().equals("unlocked")){ user.setAccess("locked");
	  userRrepo.save(user); return "success.locked"; } return "lock.failure"; }
	  
	  public String unlock(String login) { 
		  User user=getUser(login);
	  if(user.getAccess().equals("locked")){ 
		  user.setAccess("unlocked");
	  userRrepo.save(user); return "success.unlocked"; } return "unlock.failure"; }
	 
	

	public Set<User> getAllUsers() {
		Set<User> users=new HashSet<User>(userRrepo.findAll());
		outer: for (User c : users) {
   		 if (c.getLogin().equals("admin")) { 
   			 users.remove(c);
   			break outer;
   		 }
		}
        return users;
    }
	
}
