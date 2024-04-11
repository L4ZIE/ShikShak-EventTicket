package be;

public class Account
{
    private int id;
    private String username;
    private String password;
    private boolean accountType;

    public int getId() {
        return id;
    }
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public boolean getAccountType(){return accountType;}

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }

    public Account(int id, String username, String password, boolean accountType){
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    @Override
    public String toString(){
        return id + "" + username + "" + password + "" + accountType;
    }
}
