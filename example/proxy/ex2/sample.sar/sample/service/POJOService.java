package sample.service;

/**
 * POJOサービス。<p>
 */
public class POJOService implements Messenger{
    
    private String message;
    
    public void setMessage(String msg){
        message = msg;
    }
    
    public String getMessage(){
        return message;
    }
}