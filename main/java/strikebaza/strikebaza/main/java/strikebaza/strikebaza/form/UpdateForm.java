package strikebaza.strikebaza.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class UpdateForm {
	@NotBlank
	private String login;
	@NotBlank
    private String password;
	@NotBlank
    private String email;
	@NotBlank
    private String role;
	
	private String loginNew;
	
    private String passwordNew;
	
    private String emailNew;
	
    private MultipartFile file;
    private String name;
	
	  private String compar;
	 
	
	@NotBlank(message = "name empty")
    private String eventName;
	@NotBlank(message = "date empty")
	private String eventDate;
	@NotBlank(message = "location empty")
	private String eventLocation;
	@NotNull(message = "price empty")
	private Integer price; 
	
	@NotBlank(message = "name empty")
    private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventDate() {
		
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLoginNew() {
		return loginNew;
	}

	public void setLoginNew(String loginNew) {
		this.loginNew = loginNew;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getEmailNew() {
		return emailNew;
	}

	public void setEmailNew(String emailNew) {
		this.emailNew = emailNew;
	}

	
	  public String getCompar() { return compar; }
	  
	  public void setCompar(String compar) { this.compar = compar; }

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
}