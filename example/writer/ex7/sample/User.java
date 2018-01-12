package sample;

import java.util.Map;
import java.util.HashMap;

public class User{
    
    private String id;
    private Map properties;
    
    public User(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setProperty(String name, Object prop){
        if(properties == null){
            properties = new HashMap();
        }
        properties.put(name, prop);
    }
    
    public void setProperties(Map props){
        properties = props;
    }
    
    public Map getProperties(){
        return properties;
    }
}