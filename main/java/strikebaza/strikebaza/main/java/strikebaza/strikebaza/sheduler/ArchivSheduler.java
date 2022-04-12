package strikebaza.strikebaza.sheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import strikebaza.strikebaza.service.ArchivService;

@Configuration
@EnableScheduling
public class ArchivSheduler {
	@Autowired
	ArchivService aService;
	
	@Scheduled(fixedDelay = 500000)
	@Transactional
	public void scheduleCrawlerJob() {
		System.out.println("Popytka archivacii");
		 aService.archiv(); 
	}
}
