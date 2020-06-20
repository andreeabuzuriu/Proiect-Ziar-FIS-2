package Exceptions;

public class EmptyPassword extends Exception{
    String password;

    public EmptyPassword(String password){
        super("The password field is mandatory");
        this.password=password;
    }
}
