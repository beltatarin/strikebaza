package strikebaza.strikebaza.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id", nullable = false)
	    private Integer userId;
	    @Column(name = "login", nullable = false, length = 30)
	    private String login;
	    @Column(name = "password", nullable = false, length = 30)
	    private String password;
	    @Column(name = "email", nullable = false, length = 30)
	    private String email;
	    @Column(name = "phone", nullable = false, length = 12)
	    private String phone;
	    @Column(name = "role", nullable = false, length = 10)
	    private String role;
	  @Column(name = "access", nullable = false, length = 10)
	  private String access;
	  @Column(name = "imgUrl")
		private String imgUrl;
	 
	    
	    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})    
	        @JoinTable(name = "users_events", 
	              joinColumns = { @JoinColumn(name = "user_id") }, 
	              inverseJoinColumns = { @JoinColumn(name = "event_id") })
	        @OnDelete(action = OnDeleteAction.CASCADE)
	        private Set<Event> events = new HashSet<>();
	    
	    public User() {
	    }
	    
	    public User(Integer userId, String login, String password, String email) {
	        this.userId = userId;
	        this.login = login;
	        this.password = password;
	        this.email = email;
	    }

	    public User(String login, String password, String email, String phone, String role, String access, String imgUrl) {
			super();
			this.login = login;
			this.password = password;
			this.email = email;
			this.phone=phone;
			this.role = role;
			this.access=access;
			this.imgUrl=imgUrl;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

	
	  public String getAccess() { return access; }
	  
	  public void setAccess(String access) { this.access = access; }
	 

		public User(Integer userId) {
	        this.userId = userId;
	    }
		
		public Set<Event> getEvents() {
	        return events;
	    }

	    public void setEvents(Set<Event> events) {
	        this.events = events;
	    }
		
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public void addEvent(Event event) {   
	        event.getUsers().add(this);
	        events.add(event); 
	    }
	 
	    public void removeEvent(Event event) {                
	       events.remove(event);
	    } 

		@Override
		public String toString() {
			return "User [login=" + login + ", password=" + password + ", email=" + email + ", role=" + role
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			return true;
		}

		

		
	   
	    
	    
}
