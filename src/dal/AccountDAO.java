package dal;

import be.Account;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.DataBaseConnector;
import dal.interfaces.IAccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    private PreparedStatement preparedStatement;
    private DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();

    @Override
    public List<Account> getAllAccounts() {
        List<Account> Accounts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM accounts";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Accounts.add(new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("roleID")
                ));
            }
            return Accounts;

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createAccount(Account account) {
        try {
            String sql = "INSERT INTO accounts(username, password, role_Id) VALUES(?,?,?)";
            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRoleId());

            preparedStatement.execute();


        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAccount(int id) {
        try {
            String sql ="DELETE FROM accounts WHERE id=?";
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
    public void updateAccount(Account account) {
        try {
            String sql = "UPDATE accounts SET username = ?, password = ?, role_Id = ? WHERE id = ?";
            Connection conn = dataBaseConnector.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRoleId());
            preparedStatement.setInt(4, account.getId());

            preparedStatement.executeUpdate();

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean logInUser(String username, String password) {
        try {
            String sql = "SELECT password, role_Id FROM accounts WHERE username = ?";

            preparedStatement = dataBaseConnector.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                return false;
            } else {
                if (resultSet.next()){
                    return resultSet.getString(password).equals(password);
                } else {
                    return false;
                }
            }

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
