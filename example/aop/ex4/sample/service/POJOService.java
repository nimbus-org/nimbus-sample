package sample.service;

/**
 * POJO�T�[�r�X�B<p>
 */
public class POJOService implements Messenger{
    
    private String message;
    
    public void setMessage(String msg){
        message = msg;
    }
    
    public String getMessage(){
        return message;
    }
    
    public String getMessage2(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return message;
    }
}