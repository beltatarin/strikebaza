package strikebaza.strikebaza.form;

import org.hibernate.validator.constraints.NotBlank;

public class RegForm {
	@NotBlank
    private String userName;
	@NotBlank
    private String password;
	@NotBlank
    private String passwordSecond;
	@NotBlank
    private String email;
	@NotBlank
    private String role;
	@NotBlank
    private String telefon;

    public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
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

	public String getPasswordSecond() {
		return passwordSecond;
	}

	public void setPasswordSecond(String passwordSecond) {
		this.passwordSecond = passwordSecond;
	}
}