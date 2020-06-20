package Exceptions;

public class NullArticleFields extends Exception{
    public NullArticleFields(){
        super("The article has null fields");
    }
}