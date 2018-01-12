package sample.service;

/**
 * MBean POJOサービスのMBeanインタフェース。<p>
 */
public interface POJOService2MBean{
    
    public String getMessage();
    public void setMessage(String message);
    
    public String displayMessage();
}