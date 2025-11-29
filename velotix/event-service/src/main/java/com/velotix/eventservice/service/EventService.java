package com.velotix.eventservice.service;

import com.velotix.eventservice.model.Event;
import com.velotix.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        event.setAvailableSeats(event.getTotalSeats());
        return eventRepository.save(event);
    }

    public Event updateAvailableSeats(Long id, int seatsToDeduct) {
        Event event = eventRepository.findById(id).orElseThrow();
        int remaining = event.getAvailableSeats() - seatsToDeduct;
        event.setAvailableSeats(Math.max(remaining, 0));
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updated) {
        Event existing = eventRepository.findById(id).orElseThrow();
        existing.setEventName(updated.getEventName());
        existing.setVenue(updated.getVenue());
        existing.setDate(updated.getDate());
        existing.setPrice(updated.getPrice());
        existing.setTotalSeats(updated.getTotalSeats());
        existing.setAvailableSeats(updated.getAvailableSeats());
        return eventRepository.save(existing);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}
