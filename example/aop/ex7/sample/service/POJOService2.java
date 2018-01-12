package sample.service;

/**
 * POJOサービス。<p>
 */
public class POJOService2 implements Messenger{
    
    private String message;
    
    public void setMessage(String msg){
        message = msg;
    }
    
    public String getMessage(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        return message;
    }
    
    public String getMessage2(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
        }
        return message;
    }
    
    public String getMessage3(long sleep){
        try{
            Thread.sleep(sleep);
        }catch(InterruptedException e){
        }
        return message;
    }
}