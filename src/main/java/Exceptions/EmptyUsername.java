package Exceptions;

public class EmptyUsername extends Exception{
    String name;
    public EmptyUsername(String name){
        super("The name field is mandatory");
        this.name=name;
    }
}
