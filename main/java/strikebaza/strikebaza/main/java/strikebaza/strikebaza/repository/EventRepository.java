package strikebaza.strikebaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import strikebaza.strikebaza.entity.Event;
  
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByEventName(String eventName);
}