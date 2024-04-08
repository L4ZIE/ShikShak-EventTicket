package be;

public class Roles {
    public int id;
    public String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Roles(int id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

    public String toString(){
        return id + "" + roleName;
    }
}
