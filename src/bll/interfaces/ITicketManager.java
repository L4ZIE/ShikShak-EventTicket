package bll.interfaces;

import be.Tickets;

import java.util.List;

public interface ITicketManager {
    List<Tickets> getAllTickets() ;
    void createTicket(Tickets tickets, int eventID);
    void deleteTicket(int id);
    void updateTicket(Tickets tickets);
    int getMaxID();
    List<Tickets> searchTicketsByCustomerName(String query);
    Tickets getTicketByID(int id);
    List<Tickets> searchForTicket(String query);
    List<Tickets> searchTicketByEvent(String query);

    List<Tickets> getTicketsByCustomer(String name);

    List<Tickets> getTicketsByEmail(String email);

    List<Tickets> getTicketsByPrice(double price);

    List <Tickets>getTicketsByUsed(Boolean used);

    List<Tickets> getTicketsByEventID(int id);
    void useTicket(int id);

}