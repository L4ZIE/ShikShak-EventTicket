package dal;

import be.Events;
import be.Tickets;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.DataBaseConnector;
import dal.interfaces.ITicketsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketsDAO implements ITicketsDAO {
    private PreparedStatement preparedStatement;
    private DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();
    @Override
    public List<Tickets> getAllTickets() {
        List<Tickets> Tickets = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tickets";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Tickets.add(new Tickets(
                        resultSet.getInt("id"),
                        resultSet.getString("customername"),
                        resultSet.getString("customeremail"),
                        resultSet.getString("tickettype"),
                        resultSet.getDouble("ticketprice"),
                        resultSet.getBoolean("used")
                ));
            }
            return Tickets;
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTicket(Tickets tickets) {
        try {
            String sql = "INSERT INTO tickets(customername, customeremail, tickettype, ticketprice, used) VALUES(?,?,?,?,?)";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, tickets.getCustomerName());
            preparedStatement.setString(2, tickets.getCustomerEmail());
            preparedStatement.setString(3, tickets.getTicketType());
            preparedStatement.setDouble(4,tickets.getTicketPrice());
            preparedStatement.setBoolean(5, tickets.isUsed());

            preparedStatement.execute();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTicket(int id) {
        try {
            String sql ="DELETE FROM tickets WHERE id=?";
            Connection conn = dataBaseConnector.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void updateTicket(Tickets tickets) {
        try {
            String sql = "UPDATE tickets SET customername = ?, customeremail = ?, tickettype = ?, ticketprice = ?, used = ?";
            Connection conn = dataBaseConnector.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, tickets.getCustomerName());
            preparedStatement.setString(2, tickets.getCustomerEmail());
            preparedStatement.setString(3, tickets.getTicketType());
            preparedStatement.setDouble(4,tickets.getTicketPrice());
            preparedStatement.setBoolean(5, tickets.isUsed());

            preparedStatement.executeUpdate();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
