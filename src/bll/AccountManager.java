package bll;

import be.Account;
import bll.interfaces.IAccountManager;

import java.util.List;

public class AccountManager implements IAccountManager {
    @Override
    public List<Account> getAllAccount() {
        return null;
    }

    @Override
    public void createAccount(Account account) {

    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> searchForAccount(String query) {
        return null;
    }

    @Override
    public List<Account> getAccountsByRole(int roleId) {
        return null;
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }

    @Override
    public Boolean logInUser(String uName, String uPassword) {
        return null;
    }

    @Override
    public Account getAccountByName(String name) {
        return null;
    }
}
