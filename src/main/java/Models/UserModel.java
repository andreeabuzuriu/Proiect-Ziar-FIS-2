package Models;

public class UserModel {

    public String username,password;
    public UserType role;

    public UserModel(String username, String password, UserType role){
        this.username=username;
        this.password=password;
        this.role=role;
    }
}
