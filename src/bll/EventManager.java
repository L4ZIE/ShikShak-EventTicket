package bll;

import be.Events;
import bll.interfaces.IEventManager;

import java.util.Date;
import java.util.List;

public class EventManager implements IEventManager {
    @Override
    public List<Events> getAllEvents() {
        return null;
    }

    @Override
    public void createEvent(Events events) {

    }

    @Override
    public void deleteEvent(int id) {

    }

    @Override
    public Events getEventByID(int id) {
        return null;
    }

    @Override
    public List<Events> getEventsByStartDate(Date start) {
        return null;
    }

    @Override
    public List<Events> getEventByEndDate(Date end) {
        return null;
    }

    @Override
    public Events getEventByName(String name) {
        return null;
    }

    @Override
    public List<Events> searchForEvent(String query, List<Events> allEvents) {
        return null;
    }

    @Override
    public int getMaxID() {
        return 0;
    }

    @Override
    public void updateEvent(Events events) {

    }
}
