package strikebaza.strikebaza.form;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	@NotBlank
    private String login;
	@NotBlank
    private String password;
	@NotBlank
    private String phone;

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}