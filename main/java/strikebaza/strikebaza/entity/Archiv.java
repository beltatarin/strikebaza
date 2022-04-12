package strikebaza.strikebaza.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "archiv") 
public class Archiv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	 @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "archiv_id")
		private Integer archivId;
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
	    @Column(name = "col")
	    private Integer col;
	    
	    public Archiv() {
		
		}
	    public Archiv(String eventName, String eventLocation, String eventDate, Integer price, Integer col,
				String imgUrl) {
		
			this.eventName = eventName;
			this.eventLocation = eventLocation;
			 if (StringUtils.countMatches(eventDate, ":") == 1) { 
					eventDate += ":00";
				 } 
				this.eventDate=Timestamp.valueOf(eventDate.replace("T"," "));
			this.price = price;
			this.col = col;
			this.imgUrl = imgUrl;
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
		public void setEventDate(String eventDate) {
			this.eventDate = Timestamp.valueOf(eventDate.replace("T"," "));
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
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
		
}
