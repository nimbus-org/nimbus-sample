package sample.service;

/**
 * POJOサービス。<p>
 */
public class POJOService{
    
    private String message = "";
    
    public void setMessage(String msg){
        message = msg;
    }
    
    public String toString(){
        return super.toString() + " : " + message;
    }
}