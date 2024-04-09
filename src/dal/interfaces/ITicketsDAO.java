package dal.interfaces;

import be.Tickets;

import java.util.List;

public interface ITicketsDAO {
    List<Tickets> getAllTickets();
    void createTicket(Tickets tickets);
    void deleteTicket(int id);
    void updateTicket(Tickets tickets);
}
