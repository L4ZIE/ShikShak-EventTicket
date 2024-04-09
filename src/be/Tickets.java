package be;

public class Tickets {
    public int id;
    public String customerName;
    public String customerEmail;
    public String ticketType;
    public double ticketPrice;
    public boolean used;

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Tickets(int id, String customerName, String customerEmail, String ticketType, double ticketPrice, boolean used) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.used = used;
    }

    @Override
    public String toString() {
        return id + "" + customerName + "" + customerEmail + "" + ticketType + "" + ticketPrice + "" + used;
    }

}
