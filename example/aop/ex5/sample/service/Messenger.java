package sample.service;

/**
 * POJOサービスが実装するインタフェース。<p>
 */
public interface Messenger{
    
    public String getMessage();
    
    public void displayMessage();
    
    public void displayMessage2(long sleep);
}