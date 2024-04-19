package dal;

import be.Events;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.DataBaseConnector;
import dal.interfaces.IEventsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventsDAO implements IEventsDAO {
    private PreparedStatement preparedStatement;
    private DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();
    @Override
    public List<Events> getAllEvents() {
        List<Events> Events = new ArrayList<>();
        try {
            String sql = "SELECT * FROM events";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Events.add(new Events(
                        resultSet.getInt("id"),
                        resultSet.getString("eventname"),
                        resultSet.getString("startdate"),
                        resultSet.getString("enddate"),
                        resultSet.getString("eventlocation"),
                        resultSet.getString("locationguide"),
                        resultSet.getString("notes")
                ));
            }
            return Events;
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createEvent(Events events) {
        try {
            String sql = "INSERT INTO events(eventname, startdate, enddate, eventlocation, locationguide, notes) VALUES(?,?,?,?,?,?)";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, events.getEventName());
            preparedStatement.setString(2, events.getStartDate());
            preparedStatement.setString(3, events.getEndDate());
            preparedStatement.setString(4, events.getEventLocation());
            preparedStatement.setString(5, events.getLocationGuidance());
            preparedStatement.setString(6, events.getNotes());

            preparedStatement.execute();

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEvent(int id) {
        try {
            String sql = "DELETE FROM events WHERE id=?";
            Connection conn = dataBaseConnector.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEvent(Events events) {
        try {
            String sql = "UPDATE events SET eventname = ?, startdate = ?, enddate = ?, eventlocation = ?, locationguide = ?, notes = ?";
            Connection conn = preparedStatement.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, events.getEventName());
            preparedStatement.setString(2, events.getStartDate());
            preparedStatement.setString(3, events.getEndDate());
            preparedStatement.setString(4, events.getEventLocation());
            preparedStatement.setString(5, events.getLocationGuidance());
            preparedStatement.setString(6, events.getNotes());

            preparedStatement.executeUpdate();
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
