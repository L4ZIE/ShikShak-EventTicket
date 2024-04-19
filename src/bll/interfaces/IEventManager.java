package bll.interfaces;

import be.Events;

import java.util.Date;
import java.util.List;

public interface IEventManager {
    List<Events> getAllEvents();

    void createEvent(Events events);
    void deleteEvent(int id);
    Events getEventByID(int id);
    List<Events> getEventsByStartDate(Date start);
    List<Events> getEventByEndDate(Date end);
    Events getEventByName(String name);
    List<Events> searchForEvent(String query, List<Events> allEvents);
    int getMaxID();
    void updateEvent(Events events);
}
