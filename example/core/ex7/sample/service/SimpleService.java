package sample.service;

import jp.ossc.nimbus.core.ServiceBase;

/**
 * �P���T�[�r�X�B<p>
 */
public class SimpleService extends ServiceBase{
    
    private String message = "";
    
    public void setMessage(String msg){
        message = msg;
    }
    
    public String toString(){
        return super.toString() + " : " + message + " : " + getStateString();
    }
}