package be;

import java.util.Date;

public class Events {
    private int id;
    private String eventName;
    private Date startDate;
    private Date endDate;
    private String eventLocation;
    private String notes;

    public int getId() {
        return id;
    }

    public String getEventName(){return eventName;}

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Events(int id, String eventName, Date startDate, Date endDate, String eventLocation, String notes){
        this.id = id;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventLocation = eventLocation;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return id + "" + eventName + "" + startDate + "" + endDate + "" + eventLocation + "" + notes;}
}
