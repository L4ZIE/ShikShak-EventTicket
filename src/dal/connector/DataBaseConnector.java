package dal.connector;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnector
{
    private SQLServerDataSource dataSource;
    private static DataBaseConnector instance;

    public static DataBaseConnector getInstance(){
        if (instance==null){
            instance = new DataBaseConnector();
        }
        return instance;
    }

    public DataBaseConnector()
    {
        dataSource = new SQLServerDataSource();
        dataSource.setDatabaseName("CSe2023b_e_19-EventTicket");
        dataSource.setUser("CSe2023b_e_19");
        dataSource.setPassword("CSe2023bE19#23 ");
        dataSource.setServerName("EASV-DB4");
        dataSource.setPortNumber(1433);
        dataSource.setTrustServerCertificate(true);
    }

    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException
    {
        DataBaseConnector dataBaseConnector = new DataBaseConnector();

        try(Connection connection = dataBaseConnector.getConnection())
        {
            System.out.println("is it open?" + !connection.isClosed());
        }
    }
}
