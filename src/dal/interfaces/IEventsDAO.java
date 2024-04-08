package dal.interfaces;

import be.Events;

import java.util.List;

public interface IEventsDAO {
    List<Events> getAllEvents();
    void createEvent(Events events);
    void deleteEvent(int id);
    void updateEvent(Events events);
}
