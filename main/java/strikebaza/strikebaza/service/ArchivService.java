package strikebaza.strikebaza.service;

import java.util.Set;
import static java.util.stream.Collectors.toSet;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strikebaza.strikebaza.entity.Archiv;
import strikebaza.strikebaza.entity.Event;
import strikebaza.strikebaza.repository.ArchivRepository;
import strikebaza.strikebaza.repository.EventRepository;

@Service
public class ArchivService {
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private EventService eService;
	/*
	 * @Autowired private UserRepository userRrepo;
	 */
	@Autowired
	private ArchivRepository archivRepo;
	
	
	public void archiv() {
    	Set<Event> events = eventRepo.findAll().stream().collect(toSet());
    	Date date=new Date();
    	
    	for (Event event : events) {
    		if(event.getEventDateTime().before(date)) {
    		Archiv archiv = new Archiv(event.getEventName(),event.getEventLocation(),event.getEventDate(),event.getPrice(),event.getCol(),event.getImgUrl());
    		archivRepo.save(archiv);
    		eService.delEvent(event.getEventName());
    		}
    	}
    }
	
	public Set<Archiv> getAllArchivs() {
		Set<Archiv> archivs = archivRepo.findAll().stream().collect(toSet());
		return archivs;

	}
}
