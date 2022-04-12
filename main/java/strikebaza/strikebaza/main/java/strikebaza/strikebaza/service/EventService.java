package strikebaza.strikebaza.service;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import strikebaza.strikebaza.entity.Event;
import strikebaza.strikebaza.entity.User;
import strikebaza.strikebaza.repository.EventRepository;
import strikebaza.strikebaza.repository.UserRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private UserRepository userRrepo;
	@Autowired
	private UserService uService;

	public String add(String eventName, String eventDate, String eventLocation, Integer price, Integer id) {
		try {
			User user = userRrepo.findById(id).get();
			Event event = new Event(eventName, eventDate, eventLocation, price);
			user.addEvent(event);
			userRrepo.save(user);
			Set<User> users = uService.getAllUsers();
			for (User u : users) {
				if (u.getRole().equals("player")) {
					SimpleEmailManager mail=new SimpleEmailManager();
					mail.sendEmail(u, event);
				}
			}
			return "success.update";
		} catch (Exception d) {
			System.err.println(d.getMessage());
			return "success.failure";
		}
	}

	public String add(String eventName, Integer id) {
		try {
			User user = userRrepo.findById(id).get();
			Event event = eventRepo.findByEventName(eventName);
			user.addEvent(event);
			userRrepo.save(user);
			return "success.update";
		} catch (Exception d) {
			System.err.println(d.getMessage());
			return "success.failure";
		}
	}

	public String delete(String eventName, Integer id) {
		User user = userRrepo.findById(id).get();
		try {
			Event event = null;
			List<Event> events = eventRepo.findAll();
			outer: for (Event c : events) {
				if (c.getEventName().equals(eventName)) {
					Set<User> users = c.getUsers();
					for (User u : users) {
						if (u.getUserId().equals(user.getUserId())) {
							event = c;
							break outer;
						}
					}
				}
			}

			if (event != null) {
				user.removeEvent(event);
				userRrepo.save(user);
				eventRepo.deleteById(event.getEventId());
				return "success.deleted";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "delete.failure";
	}

	public String delEvent(String eventName) {
		try {
			List<Event> events = eventRepo.findAll();
			for (Event c : events) {
				if (c.getEventName().equals(eventName)) {
					Set<User> users = c.getUsers();
					for (User u : users) {
						u.removeEvent(c);
						userRrepo.save(u);
					}
					eventRepo.deleteById(c.getEventId());
					return "success.deleted";
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "delete.failure";
	}

	public Set<Event> getAllEvents() {
		Set<Event> events = new HashSet<Event>(eventRepo.findAll());

		for (Event event : events) {
			Set<User> users = event.getUsers();
			int col = users.size() - 1;
			event.setCol(col);
		}

		return events;

	}

	public List<Event> getAllEvents(String compar) {
	
		SortedSet<Event> events = new TreeSet<Event>(eventRepo.findAll());
	
		List<Event> events1 = null;
		if (compar.equals("eventName")) {
			events1 = events.stream().sorted((o1, o2) -> o1.getEventName().compareTo(o2.getEventName())).collect(toCollection(ArrayList::new));
		} else if (compar.equals("eventDate")) {
			events1 = events.stream().sorted((o1, o2) ->o1.getEventDateTime().compareTo(o2.getEventDateTime())).collect(toCollection(ArrayList::new));
		} else if (compar.equals("eventPrice")) {
			events1 = events.stream().sorted((o1, o2) ->o1.getPrice().compareTo(o2.getPrice())).collect(toCollection(ArrayList::new));
		}
		for (Event event : events1) {
			Set<User> users = event.getUsers();
			int col = users.size() - 1;
			event.setCol(col);
		}
		return events1;
	}

	public Event getEvent(String eventName) {
		return eventRepo.findByEventName(eventName);

	}

}
