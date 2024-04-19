package be;

public class Account
{
    private int id;
    private String username;
    private String password;
    private int roleId;

    public int getId() {
        return id;
    }
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public int getRoleId(){return roleId;}

    public void setRoleId(int roleID) {this.roleId = roleID;}

    public Account(int id, String username, String password, int roleId){
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString(){
        return id + "" + username + "" + password + "" + roleId;
    }
}
