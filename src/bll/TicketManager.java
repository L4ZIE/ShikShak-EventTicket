package bll;

import be.Tickets;
import bll.interfaces.ITicketManager;
import dal.connector.DataBaseConnector;

import java.sql.PreparedStatement;
import java.util.List;

public class TicketManager implements ITicketManager {
    @Override
    public List<Tickets> getAllTickets() {
        return null;
    }

    @Override
    public void createTicket(Tickets tickets, int eventID) {

    }

    @Override
    public void deleteTicket(int id) {

    }

    @Override
    public void updateTicket(Tickets tickets) {

    }

    @Override
    public int getMaxID() {
        return 0;
    }

    @Override
    public List<Tickets> searchTicketsByCustomerName(String query) {
        return null;
    }

    @Override
    public Tickets getTicketByID(int id) {
        return null;
    }

    @Override
    public List<Tickets> searchForTicket(String query) {
        return null;
    }

    @Override
    public List<Tickets> searchTicketByEvent(String query) {
        return null;
    }

    @Override
    public List<Tickets> getTicketsByCustomer(String name) {
        return null;
    }

    @Override
    public List<Tickets> getTicketsByEmail(String email) {
        return null;
    }

    @Override
    public List<Tickets> getTicketsByPrice(double price) {
        return null;
    }

    @Override
    public List<Tickets> getTicketsByUsed(Boolean used) {
        return null;
    }

    @Override
    public List<Tickets> getTicketsByEventID(int id) {
        return null;
    }

    @Override
    public void useTicket(int id) {

    }
}
