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
    
    public void displayMessage(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(message);
    }
    
    public void displayMessage2(long sleep){
        try{
            Thread.sleep(sleep);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(message);
    }
}