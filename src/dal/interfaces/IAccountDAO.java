package dal.interfaces;

import be.Account;

import java.util.List;

public interface IAccountDAO
{
    List<Account> getAllAccounts();
    void createAccount(Account account);
    void deleteAccount(int id);
    void updateAccount(Account account);
    boolean logInUser(String username, String password);

}
