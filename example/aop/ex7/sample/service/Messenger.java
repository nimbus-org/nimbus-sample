package sample.service;

/**
 * POJOサービスが実装するインタフェース。<p>
 */
public interface Messenger{
    
    public String getMessage();
    
    public String getMessage2();
    
    public String getMessage3(long sleep);
}