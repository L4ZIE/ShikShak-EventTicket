package be;


public class Events {
    private int id;
    private String eventName;
    private String startDate;
    private String endDate;
    private String eventLocation;

    private String locationGuidance;
    private String notes;

    public int getId() {
        return id;
    }

    public String getEventName(){return eventName;}

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getLocationGuidance() {
        return locationGuidance;
    }

    public void setLocationGuidance(String locationGuidance) {
        this.locationGuidance = locationGuidance;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Events(int id, String eventName, String startDate, String endDate, String eventLocation, String locationGuidance, String notes){
        this.id = id;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventLocation = eventLocation;
        this.locationGuidance = locationGuidance;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return id + "" + eventName + "" + startDate + "" + endDate + "" + eventLocation + "" + locationGuidance + "" + notes;}
}
