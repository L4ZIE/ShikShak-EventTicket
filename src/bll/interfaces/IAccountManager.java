package bll.interfaces;

import be.Account;

import java.util.List;

public interface IAccountManager {
    List<Account> getAllAccount();
    void createAccount(Account account);
    void deleteAccount(int id);
    void updateAccount(Account account);

    List<Account> searchForAccount(String query);

    List<Account> getAccountsByType(boolean type);
    Account getAccountById(int id);

    Boolean logInUser(String username, String password);
    Account getAccountByName(String name);
}
