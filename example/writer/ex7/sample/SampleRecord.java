package sample;

import java.util.Date;

public class SampleRecord{
    
    private Date date;
    private String message;
    private User user;
    
    public SampleRecord(
        Date date,
        String message
    ){
        this.date = date;
        this.message = message;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getMessage(){
        return message;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
}