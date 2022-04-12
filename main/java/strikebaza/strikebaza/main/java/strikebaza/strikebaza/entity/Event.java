package strikebaza.strikebaza.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "events")
public class Event implements Serializable, Comparable<Event> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Integer eventId;
	@Column(name = "eventName")
	private String eventName;
	@Column(name = "event_location")
	private String eventLocation;
	@Column(name = "event_date")
	private Timestamp eventDate;
	@Column(name = "price")
	private Integer price;
	@Column(name = "imgUrl")
	private String imgUrl;
	@Column(name = "descriptionUrl")
	private String descriptionUrl;
	private Integer col;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "events", cascade = { CascadeType.PERSIST})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<User> users = new HashSet<>();

	public Event() {
	}

	public Event(Integer eventId) {
		this.eventId = eventId;
	}

	public Event(String eventName, String eventDate, String eventLocation, Integer price) {
		this.eventName = eventName;
		if (StringUtils.countMatches(eventDate, ":") == 1) {
			eventDate += ":00";
		}
		this.eventDate = Timestamp.valueOf(eventDate.replace("T", " "));
		this.eventLocation = eventLocation;
		this.price = price;
	}

	public Event(String eventName, String eventDate, String eventLocation, Integer price, Integer col) {

		this.eventName = eventName;
		if (StringUtils.countMatches(eventDate, ":") == 1) {
			eventDate += ":00";
		}
		this.eventDate = Timestamp.valueOf(eventDate.replace("T", " "));
		this.eventLocation = eventLocation;
		this.price = price;
		this.col = col;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDate() {

		return eventDate.toString();
	}

	public Timestamp getEventDateTime() {

		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = Timestamp.valueOf(eventDate.replace("T", " "));
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescriptionUrl() {
		return descriptionUrl;
	}

	public void setDescriptionUrl(String descriptionUrl) {
		this.descriptionUrl = descriptionUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
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
		Event other = (Event) obj;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventDate=" + eventDate + "]";
	}

	@Override
	public int compareTo(Event o) {
		return eventName.compareTo(o.eventName);
	}
}
