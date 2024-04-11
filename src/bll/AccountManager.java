package bll;

import be.Account;
import bll.interfaces.IAccountManager;
import dal.AccountDAO;
import dal.interfaces.IAccountDAO;

import java.util.ArrayList;
import java.util.List;

public class AccountManager implements IAccountManager {
    IAccountDAO accountDAO;
    private List<Account> allAccounts;
    public AccountManager(){
        accountDAO = new AccountDAO();
        fillAllAccounts();
    }

    public void fillAllAccounts(){
        allAccounts = accountDAO.getAllAccounts();
    }

    @Override
    public List<Account> getAllAccount() {
        return allAccounts;
    }

    @Override
    public void createAccount(Account account) {
        allAccounts.add(account);
        accountDAO.createAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountDAO.deleteAccount(id);
        fillAllAccounts();
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        fillAllAccounts();
    }

    @Override
    public List<Account> searchForAccount(String query) {
        List<Account> filtered = new ArrayList<>();

        for (Account a : allAccounts){
            if (a.getUsername().toLowerCase().contains(query.toLowerCase())){
                filtered.add(a);
            }
        }

        return filtered;
    }

    @Override
    public List<Account> getAccountsByType(boolean type) {
        List<Account> result = new ArrayList<>();
        for (Account e : allAccounts){
            if (e.getAccountType() == type){
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }

    @Override
    public Boolean logInUser(String username, String password) {
        return accountDAO.logInUser(username, password);
    }

    @Override
    public Account getAccountByName(String name) {
        return null;
    }
}
