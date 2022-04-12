package strikebaza.strikebaza.form;

import org.hibernate.validator.constraints.NotBlank;

public class EmailForm {
	@NotBlank
    private String login;
	@NotBlank
    private String text;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@NotBlank
    private String email;
}
