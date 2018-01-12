package sample.service;

/**
 * MBean POJOサービス。<p>
 */
public class POJOService2 implements POJOService2MBean{
    
    private String message;
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String displayMessage(){
        System.out.println(message);
        return message;
    }
}